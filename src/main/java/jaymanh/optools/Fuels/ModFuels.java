package jaymanh.optools.Fuels;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static jaymanh.optools.Tools.ModTools.*;

public class ModFuels {

    public static final Item SUPER_FUEL = register(
            new Item(new Item.Properties().rarity(Rarity.RARE).setId(key("super_fuel"))), "super_fuel"
    );

    public static void initialize(){

        CreativeModeTabEvents.modifyOutputEvent(OP_TOOLS_ITEM_GROUP_KEY).register(event -> {
            event.accept(SUPER_FUEL);
        });

        FuelValueEvents.BUILD.register(((builder, context) -> {
            builder.add(ModFuels.SUPER_FUEL, 20 * 640);
        }));
    }
}