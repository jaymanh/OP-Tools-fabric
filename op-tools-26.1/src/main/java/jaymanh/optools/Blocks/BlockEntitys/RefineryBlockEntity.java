package jaymanh.optools.Blocks.BlockEntitys;

import jaymanh.optools.GUI.ImplementedInventory;
import jaymanh.optools.GUI.Screen.BlockPosPayload;
import jaymanh.optools.GUI.Screen.RefineryScreenHandler;
import jaymanh.optools.Items.ModItems;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;


public class RefineryBlockEntity extends BaseContainerBlockEntity implements ExtendedScreenHandlerFactory<BlockPosPayload>, ImplementedInventory, WorldlyContainer {


    private final  NonNullList<ItemStack> inventory = NonNullList.withSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int[] TOP_SLOTS = new int[]{0};
    private static final int[] BOTTOM_SLOTS = new int[]{1, 1};
    private static final int[] SIDE_SLOTS = new int[]{0};

    protected final ContainerData propertyDelegate;
    private int progress = 0;
    private int maxProgress = 120;

    public RefineryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntitys.REFINERY_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> RefineryBlockEntity.this.progress;
                    case 1 -> RefineryBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> RefineryBlockEntity.this.progress = value;
                    case 1 -> RefineryBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public void setChanged() {
        assert level != null;
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        super.setChanged();
    }

    @Override
    protected void saveAdditional(ValueOutput writeView) {
        super.saveAdditional(writeView);
        ContainerHelper.saveAllItems(writeView, this.inventory);
        writeView.putInt("refinery.progress", 0);
    }

    @Override
    public void loadAdditional(ValueInput readView) {
        super.loadAdditional(readView);
        ContainerHelper.loadAllItems(readView, this.inventory);
        readView.getInt("refinery.progress").ifPresent(progress -> this.progress = progress);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.op-tools.refinery");
    }

    @Override
    protected Component getDefaultName() {
        return this.getDisplayName();
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> inventory) {

    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new RefineryScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return null;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public void tick(Level world, BlockPos pos, BlockState state) {
        if(world.isClientSide()){
            return;
        }
        //called every tick

        if(isOutputSlotEmptyOrReceivable()){
            if(this.hasRecipe()){
                this.increaseCraftProgress();
                setChanged(world, pos, state);

                if(hasCraftingFinished()){
                    this.craftItem();
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            setChanged(world, pos, state);
        }
    }

    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return BOTTOM_SLOTS;
        } else {
            return side == Direction.UP ? TOP_SLOTS : SIDE_SLOTS;
        }
    }

    private void craftItem() {
        this.removeItem(INPUT_SLOT, 1);
        ItemStack result = new ItemStack(ModItems.REFINED_DARKMATTER);

        this.setItem(OUTPUT_SLOT, new ItemStack(result.getItem(), getItem(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack result = new ItemStack(ModItems.REFINED_DARKMATTER);
        boolean hasInput = getItem(INPUT_SLOT).getItem() == ModItems.RAW_DARKMATTER;

        return hasInput && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getItem(OUTPUT_SLOT).getItem() == item || this.getItem(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getItem(OUTPUT_SLOT).getCount() + result.getCount() <= getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getCount() < this.getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayer player) {
        return new BlockPosPayload(this.worldPosition);
    }
}
