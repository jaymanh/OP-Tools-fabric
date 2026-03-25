package jaymanh.optools.Blocks.CustomBlockTypes;

import com.mojang.serialization.MapCodec;
import jaymanh.optools.Blocks.BlockEntitys.ModBlockEntitys;
import jaymanh.optools.Blocks.BlockEntitys.RefineryBlockEntity;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class RefineryBlock extends BaseEntityBlock implements EntityBlock {
    public RefineryBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends RefineryBlock> codec() {
        return simpleCodec(RefineryBlock::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RefineryBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void affectNeighborsAfterRemoval(BlockState state, ServerLevel serverWorld, BlockPos pos, boolean moved) {
        if (state.getBlock() != serverWorld.getBlockState(pos).getBlock()){
            BlockEntity blockEntity = serverWorld.getBlockEntity(pos);
            if(blockEntity instanceof RefineryBlockEntity){
                Containers.dropContents(serverWorld, pos, (RefineryBlockEntity)blockEntity);
                serverWorld.updateNeighbourForOutputSignal(pos, this);
            }
            super.affectNeighborsAfterRemoval(state, serverWorld, pos, moved);
        }
    }
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    protected int getComparatorOutput(BlockState state, Level world, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
    }

    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (!world.isClientSide()){
            MenuProvider screenHandlerFactory = ((RefineryBlockEntity) world.getBlockEntity(pos));

            if (screenHandlerFactory != null){
                player.openMenu(screenHandlerFactory);
            }
        }

        return InteractionResult.SUCCESS;
    }


    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntitys.REFINERY_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
