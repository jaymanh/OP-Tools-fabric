package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import static jaymanh.optools.OpTools.LOGGER;

public class ElementalDamageEnchantments {

    public static void initialise(){
        OpTools.register(Identifier.of("elemental_fire"), (world, level, context, user, pos) -> {
            LOGGER.info("World: " + world.toString());
            LOGGER.info("Level: " + level);
            LOGGER.info("Context: " + context.toString());
            LOGGER.info("User: " + user.toString());
            LOGGER.info("Pos: " + pos.toString());
            BlockPos victimBlockPos = user.getBlockPos();
            world.setBlockState(victimBlockPos, Blocks.FIRE.getDefaultState());
            //make an effect that lasts for x seconds to prolong enchantment 
        });
        OpTools.register(Identifier.of("elemental_water"), (world, level, context, user, pos) -> {

        });
        OpTools.register(Identifier.of("elemental_earth"), (world, level, context, user, pos) -> {

        });
        OpTools.register(Identifier.of("elemental_lightning"), (world, level, context, user, pos) -> {

        });
    }
}
