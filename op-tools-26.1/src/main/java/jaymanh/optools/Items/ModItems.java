package jaymanh.optools.Items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static jaymanh.optools.Tools.ModTools.*;

public class ModItems {

    public static final Item DIAMONDIUM_INGOT = register(new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant().setId(key("diamondium_ingot"))), "diamondium_ingot");
    public static final Item DIAMONDILLIUM_INGOT = register(new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant().setId(key("diamondillium_ingot"))), "diamondillium_ingot");
    public static final Item RAW_DARKMATTER = register(new Item(new Item.Properties().rarity(Rarity.UNCOMMON).setId(key("raw_darkmatter"))),"raw_darkmatter");
    public static final Item REFINED_DARKMATTER = register(new Item(new Item.Properties().rarity(Rarity.UNCOMMON).setId(key("refined_darkmatter"))), "refined_darkmatter");

    public static void initialise(){
        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {

            itemGroup.accept(DIAMONDIUM_INGOT);
            itemGroup.accept(DIAMONDILLIUM_INGOT);
            itemGroup.accept(RAW_DARKMATTER);
            itemGroup.accept(REFINED_DARKMATTER);
        });
    }
}
