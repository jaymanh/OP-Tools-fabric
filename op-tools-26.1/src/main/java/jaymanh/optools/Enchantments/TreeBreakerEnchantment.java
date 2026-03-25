package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static jaymanh.optools.OpTools.LOGGER;

public class TreeBreakerEnchantment {

    private static final int MAX_BLOCKS = 64 * 9;

    private static void BreakTrees(BlockPos blockPos, Block woodType, Level world, int level, EnchantedItemInUse context, Entity user) {
        ArrayList<BlockPos> blockPosList = new ArrayList<>();
        blockPosList.add(blockPos);

        while (!blockPosList.isEmpty()) {
            ArrayList<BlockPos> newPositions = new ArrayList<>();
            Set<BlockPos> seenPositions = new HashSet<>();

            Iterator<BlockPos> iterator = blockPosList.iterator();

            while (iterator.hasNext()) {
                BlockPos currentPos = iterator.next();

                world.destroyBlock(currentPos, true);
                iterator.remove();

                for (Direction direction : Direction.values()) {
                    BlockPos offsetPos = currentPos.relative(direction);

                    if (world.getBlockState(offsetPos).getBlock() == woodType && seenPositions.add(offsetPos)) {
                        newPositions.add(offsetPos);
                    }
                }

                for (Direction direction1 : Direction.values()) {
                    for (Direction direction2 : Direction.values()) {
                        if (direction1 != direction2 && direction1.getAxis() != direction2.getAxis()) {
                            BlockPos diagonalOffset = currentPos.relative(direction1).relative(direction2);
                            if (world.getBlockState(diagonalOffset).getBlock() == woodType && seenPositions.add(diagonalOffset)) {
                                newPositions.add(diagonalOffset);
                            }
                        }
                    }
                }

                if (newPositions.size() > MAX_BLOCKS) {
                    for (BlockPos pos : blockPosList) {
                        world.destroyBlock(pos, true);
                    }
                    return;
                }
            }

            blockPosList.addAll(newPositions);
        }
    }






    public static void initialise(){
        OpTools.register(Identifier.parse("tree_breaker_hit"), (world, level, context, user, pos) -> {
            BlockPos blockPos = new BlockPos(
                    (int)Math.floor(pos.x),
                    (int)Math.floor(pos.y),
                    (int)Math.floor(pos.z)
            );
            //LOGGER.info(world.getBlockState(blockPos).toString());

            if(world.getBlockState(blockPos).is(BlockTags.LOGS))
            {
                BreakTrees(blockPos, world.getBlockState(blockPos).getBlock(), world, level, context, user);
            }

        });
    }
}
