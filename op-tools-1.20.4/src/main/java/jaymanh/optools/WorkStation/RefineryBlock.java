package jaymanh.optools.WorkStation;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RefineryBlock extends BlockWithEntity {
    public RefineryBlock(Settings settings){
        super(settings);
    }

    @Override
    protected MapCodec<? extends RefineryBlock> getCodec() {
        return createCodec(RefineryBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Refinery(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
