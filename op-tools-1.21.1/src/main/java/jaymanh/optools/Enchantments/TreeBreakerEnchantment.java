package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.mojang.text2speech.Narrator.LOGGER;

public class TreeBreakerEnchantment {

    private static void BreakTrees(BlockPos blockPos, Block woodType, World world, int level, EnchantmentEffectContext context, Entity user){
        BlockPos currentBlock = blockPos;
        
    }

    public static void initialise(){
        OpTools.register(Identifier.of("tree_breaker_hit"), (world, level, context, user, pos) -> {
            BlockPos blockPos = new BlockPos((int)pos.x, (int)pos.y,(int)pos.z);
            LOGGER.info(world.getBlockState(blockPos).toString());

            if(world.getBlockState(blockPos).getBlock() == Blocks.OAK_LOG){
                BreakTrees(blockPos, world.getBlockState(blockPos).getBlock(), world, level, context, user);
            }
        });
    }
}
