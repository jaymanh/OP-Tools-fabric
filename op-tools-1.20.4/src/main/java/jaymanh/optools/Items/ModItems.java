package jaymanh.optools.Items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;
import static jaymanh.optools.Tools.ModTools.register;

public class ModItems {

    public static final Item DIAMONDIUM_INGOT = register(new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()), "diamondium_ingot");
    public static final Item DIAMONDILLIUM_INGOT = register(new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof()), "diamondillium_ingot");

    public static void initialise(){
        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {

            itemGroup.add(DIAMONDIUM_INGOT);
            itemGroup.add(DIAMONDILLIUM_INGOT);

        });
    }
}
