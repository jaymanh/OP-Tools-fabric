package jaymanh.optools.GUI.Screen;

import jaymanh.optools.Blocks.BlockEntitys.RefineryBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class ModScreenHandlers extends ScreenHandler {
    private  final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final RefineryBlockEntity blockEntity;

    public RefineryScreenHandler(int )

    protected ModScreenHandlers(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}
