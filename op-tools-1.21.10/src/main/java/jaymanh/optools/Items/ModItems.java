package jaymanh.optools.Items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static jaymanh.optools.Tools.ModTools.*;

public class ModItems {

    public static final Item DIAMONDIUM_INGOT = register(new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof().registryKey(key("diamondium_ingot"))), "diamondium_ingot");
    public static final Item DIAMONDILLIUM_INGOT = register(new Item(new Item.Settings().rarity(Rarity.RARE).fireproof().registryKey(key("diamondillium_ingot"))), "diamondillium_ingot");
    public static final Item RAW_DARKMATTER = register(new Item(new Item.Settings().rarity(Rarity.UNCOMMON).registryKey(key("raw_darkmatter"))),"raw_darkmatter");
    public static final Item REFINED_DARKMATTER = register(new Item(new Item.Settings().rarity(Rarity.UNCOMMON).registryKey(key("refined_darkmatter"))), "refined_darkmatter");

    public static void initialise(){
        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {

            itemGroup.add(DIAMONDIUM_INGOT);
            itemGroup.add(DIAMONDILLIUM_INGOT);
            itemGroup.add(RAW_DARKMATTER);
            itemGroup.add(REFINED_DARKMATTER);
        });
    }
}
