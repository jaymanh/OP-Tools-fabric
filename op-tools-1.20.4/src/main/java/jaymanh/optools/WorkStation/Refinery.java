package jaymanh.optools.WorkStation;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;


public class Refinery extends BlockEntity {

    public Refinery(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.REFINERY, pos, state);
    }


}
