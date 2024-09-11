package jaymanh.optools.WorkStation;

import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Refinery extends Block {

    public Refinery(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if (!player.getAbilities().allowModifyWorld){
            return ActionResult.SUCCESS;
        }
        else{


            return ActionResult.SUCCESS;
        }
    }


}
