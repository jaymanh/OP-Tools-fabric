package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.util.Identifier;

public class ElementalDamageEnchantments {

    public static void initialise(){
        OpTools.register(Identifier.of("elemental_fire"), (world, level, context, user, pos) -> {

        });
        OpTools.register(Identifier.of("elemental_water"), (world, level, context, user, pos) -> {

        });
        OpTools.register(Identifier.of("elemental_earth"), (world, level, context, user, pos) -> {

        });
        OpTools.register(Identifier.of("elemental_lightning"), (world, level, context, user, pos) -> {

        });
    }
}
