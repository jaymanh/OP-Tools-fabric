package jaymanh.optools.WorkStation;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class RefineryBlockEntity extends BlockEntity {

    public RefineryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.REFINERY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, RefineryBlockEntity blockEntity){

        return;
    }


}