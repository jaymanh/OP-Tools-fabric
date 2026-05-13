package jaymanh.optools.Armor;

import jaymanh.optools.Tools.ModTools;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;
import static jaymanh.optools.Tools.ModTools.register;

public class ModArmor {

    public static final Item DIAMONDIUM_HELMET = register(
            new ArmorItem(DiamondiumArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_helmet"
    );
    public static final Item DIAMONDIUM_CHESTPLATE = register(
            new ArmorItem(DiamondiumArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_chestplate"
    );
    public static final Item DIAMONDIUM_LEGGINGS = register(
            new ArmorItem(DiamondiumArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_leggings"
    );
    public static final Item DIAMONDIUM_BOOTS = register(
            new ArmorItem(DiamondiumArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_boots"
    );

    public static final Item DIAMONDILLIUM_HELMET = register(
            new ArmorItem(DiamondilliumArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_helmet"
    );
    public static final Item DIAMONDILLIUM_CHESTPLATE = register(
            new ArmorItem(DiamondilliumArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_chestplate"
    );
    public static final Item DIAMONDILLIUM_LEGGINGS = register(
            new ArmorItem(DiamondilliumArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_leggings"
    );
    public static final Item DIAMONDILLIUM_BOOTS = register(
            new ArmorItem(DiamondilliumArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_boots"
    );

    public static void initialise(){

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(DIAMONDIUM_HELMET);
            itemGroup.add(DIAMONDIUM_CHESTPLATE);
            itemGroup.add(DIAMONDIUM_LEGGINGS);
            itemGroup.add(DIAMONDIUM_BOOTS);

            itemGroup.add(DIAMONDILLIUM_HELMET);
            itemGroup.add(DIAMONDILLIUM_CHESTPLATE);
            itemGroup.add(DIAMONDILLIUM_LEGGINGS);
            itemGroup.add(DIAMONDILLIUM_BOOTS);

        });
    }
}
