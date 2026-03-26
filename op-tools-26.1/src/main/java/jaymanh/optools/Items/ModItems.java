package jaymanh.optools.Items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static jaymanh.optools.Tools.ModTools.*;

public class ModItems {

    public static final Item DIAMONDIUM_INGOT = register(new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant().setId(key("diamondium_ingot"))), "diamondium_ingot");
    public static final Item DIAMONDILLIUM_INGOT = register(new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant().setId(key("diamondillium_ingot"))), "diamondillium_ingot");
    public static final Item RAW_DARKMATTER = register(new Item(new Item.Properties().rarity(Rarity.UNCOMMON).setId(key("raw_darkmatter"))),"raw_darkmatter");
    public static final Item REFINED_DARKMATTER = register(new Item(new Item.Properties().rarity(Rarity.UNCOMMON).setId(key("refined_darkmatter"))), "refined_darkmatter");

    public static void initialise(){
        CreativeModeTabEvents.modifyOutputEvent(OP_TOOLS_ITEM_GROUP_KEY).register(entries -> {  // note: parameter name is arbitrary
            entries.accept(DIAMONDIUM_INGOT);
            entries.accept(DIAMONDILLIUM_INGOT);
            entries.accept(RAW_DARKMATTER);
            entries.accept(REFINED_DARKMATTER);
        });
    }
}
