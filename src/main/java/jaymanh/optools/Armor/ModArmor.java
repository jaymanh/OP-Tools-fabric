package jaymanh.optools.Armor;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;
import static jaymanh.optools.Tools.ModTools.register;

public class ModArmor {

    public static final Item DIAMONDIUM_HELMET = register(new ArmorItem(ModArmorMaterials.DIAMONDIUM, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC)), "diamondium_helmet");
    public static final Item DIAMONDIUM_CHESTPLATE = register(new ArmorItem(ModArmorMaterials.DIAMONDIUM, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC)), "diamondium_chestplate");
    public static final Item DIAMONDIUM_LEGGINGS = register(new ArmorItem(ModArmorMaterials.DIAMONDIUM, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC)), "diamondium_leggings");
    public static final Item DIAMONDIUM_BOOTS = register(new ArmorItem(ModArmorMaterials.DIAMONDIUM, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC)), "diamondium_boots");


    public static final Item DIAMONDILLIUM_HELMET = register(new ArmorItem(ModArmorMaterials.DIAMONDILLIUM, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.RARE)), "diamondillium_helmet");
    public static final Item DIAMONDILLIUM_CHESTPLATE = register(new ArmorItem(ModArmorMaterials.DIAMONDILLIUM, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.RARE)), "diamondillium_chestplate");
    public static final Item DIAMONDILLIUM_LEGGINGS = register(new ArmorItem(ModArmorMaterials.DIAMONDILLIUM, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.RARE)), "diamondillium_leggings");
    public static final Item DIAMONDILLIUM_BOOTS = register(new ArmorItem(ModArmorMaterials.DIAMONDILLIUM, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.RARE)), "diamondillium_boots");


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
