package jaymanh.optools.Fuels;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static jaymanh.optools.Tools.ModTools.*;

public class ModFuels {

    public static final Item SUPER_FUEL = register(
            new Item(new Item.Settings().rarity(Rarity.RARE).registryKey(key("super_fuel"))), "super_fuel"
    );

    public static void initialize(){

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(SUPER_FUEL);
        });

        FuelRegistryEvents.BUILD.register(((builder, context) -> {
            builder.add(ModFuels.SUPER_FUEL, 20 * 640);
        }));
    }
}