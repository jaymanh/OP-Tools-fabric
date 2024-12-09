package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static jaymanh.optools.OpTools.LOGGER;

public class ElementalDamageEnchantments {

    private static void createFireRadius(BlockPos center, World world, int radius) {
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos posToCheck = center.add(x, y, z);
                    if (x * x + y * y + z * z <= radius * radius) {
                        if (world.isAir(posToCheck) || world.getBlockState(posToCheck).getBlock() == Blocks.AIR || world.getBlockState(posToCheck).getBlock() == Blocks.TALL_GRASS || world.getBlockState(posToCheck).getBlock() == Blocks.SHORT_GRASS) {
                            world.setBlockState(posToCheck, Blocks.FIRE.getDefaultState());
                        }
                    }
                }
            }
        }
    }



    public static void initialise(){
        OpTools.register(Identifier.of("elemental_fire"), (world, level, context, user, pos) -> {
            BlockPos victimBlockPos = user.getBlockPos();
            level--;
            createFireRadius(victimBlockPos, world, level);
            //world.setBlockState(victimBlockPos, Blocks.FIRE.getDefaultState());
        });
        OpTools.register(Identifier.of("elemental_water"), (world, level, context, user, pos) -> {

        });
        OpTools.register(Identifier.of("elemental_earth"), (world, level, context, user, pos) -> {

        });
        OpTools.register(Identifier.of("elemental_lightning"), (world, level, context, user, pos) -> {

        });
    }
}
