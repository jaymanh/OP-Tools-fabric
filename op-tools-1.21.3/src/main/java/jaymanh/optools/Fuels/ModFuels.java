package jaymanh.optools.Fuels;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;
import static jaymanh.optools.Tools.ModTools.register;

public class ModFuels {

    public static final Item SUPER_FUEL = register(
            new Item(new Item.Settings().rarity(Rarity.RARE)), "super_fuel"
    );

    public static void initialize(){

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(SUPER_FUEL);
        });
        FuelRegistry.INSTANCE.add(SUPER_FUEL, 20 * 640);
    }
}
