package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.entity.Entity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static jaymanh.optools.OpTools.LOGGER;

public class TreeBreakerEnchantment {

    private static final int MAX_BLOCKS = 64 * 9;

    private static void BreakTrees(BlockPos blockPos, Block woodType, World world, int level, EnchantmentEffectContext context, Entity user) {
        ArrayList<BlockPos> blockPosList = new ArrayList<>();
        blockPosList.add(blockPos);

        while (!blockPosList.isEmpty()) {
            ArrayList<BlockPos> newPositions = new ArrayList<>();
            Set<BlockPos> seenPositions = new HashSet<>();

            Iterator<BlockPos> iterator = blockPosList.iterator();

            while (iterator.hasNext()) {
                BlockPos currentPos = iterator.next();

                world.breakBlock(currentPos, true);
                iterator.remove();

                for (Direction direction : Direction.values()) {
                    BlockPos offsetPos = currentPos.offset(direction);

                    if (world.getBlockState(offsetPos).getBlock() == woodType && seenPositions.add(offsetPos)) {
                        newPositions.add(offsetPos);
                    }
                }

                for (Direction direction1 : Direction.values()) {
                    for (Direction direction2 : Direction.values()) {
                        if (direction1 != direction2 && direction1.getAxis() != direction2.getAxis()) {
                            BlockPos diagonalOffset = currentPos.offset(direction1).offset(direction2);
                            if (world.getBlockState(diagonalOffset).getBlock() == woodType && seenPositions.add(diagonalOffset)) {
                                newPositions.add(diagonalOffset);
                            }
                        }
                    }
                }

                if (newPositions.size() > MAX_BLOCKS) {
                    for (BlockPos pos : blockPosList) {
                        world.breakBlock(pos, true);
                    }
                    return;
                }
            }

            blockPosList.addAll(newPositions);
        }
    }






    public static void initialise(){
        OpTools.register(Identifier.of("tree_breaker_hit"), (world, level, context, user, pos) -> {
            BlockPos blockPos = new BlockPos(
                    (int)Math.floor(pos.x),
                    (int)Math.floor(pos.y),
                    (int)Math.floor(pos.z)
            );
            //LOGGER.info(world.getBlockState(blockPos).toString());

            if(world.getBlockState(blockPos).isIn(BlockTags.LOGS))
            {
                BreakTrees(blockPos, world.getBlockState(blockPos).getBlock(), world, level, context, user);
            }

        });
    }
}
