package jaymanh.optools.Armor;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static jaymanh.optools.Tools.ModTools.*;

public class ModArmor {

    public static final Item DIAMONDIUM_HELMET = register(new ArmorItem(ModArmorMaterials.DIAMONDIUM, EquipmentType.HELMET, new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC).registryKey(key("diamondium_helmet"))), "diamondium_helmet");
    public static final Item DIAMONDIUM_CHESTPLATE = register(new ArmorItem(ModArmorMaterials.DIAMONDIUM, EquipmentType.CHESTPLATE, new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC).registryKey(key("diamondium_chestplate"))), "diamondium_chestplate");
    public static final Item DIAMONDIUM_LEGGINGS = register(new ArmorItem(ModArmorMaterials.DIAMONDIUM, EquipmentType.LEGGINGS, new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC).registryKey(key("diamondium_leggings"))), "diamondium_leggings");
    public static final Item DIAMONDIUM_BOOTS = register(new ArmorItem(ModArmorMaterials.DIAMONDIUM, EquipmentType.BOOTS, new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC).registryKey(key("diamondium_boots"))), "diamondium_boots");


    public static final Item DIAMONDILLIUM_HELMET = register(new ArmorItem(ModArmorMaterials.DIAMONDILLIUM, EquipmentType.HELMET, new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.RARE).registryKey(key("diamondillium_helmet"))), "diamondillium_helmet");
    public static final Item DIAMONDILLIUM_CHESTPLATE = register(new ArmorItem(ModArmorMaterials.DIAMONDILLIUM, EquipmentType.CHESTPLATE, new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.RARE).registryKey(key("diamondillium_chestplate"))), "diamondillium_chestplate");
    public static final Item DIAMONDILLIUM_LEGGINGS = register(new ArmorItem(ModArmorMaterials.DIAMONDILLIUM, EquipmentType.LEGGINGS, new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.RARE).registryKey(key("diamondillium_leggings"))), "diamondillium_leggings");
    public static final Item DIAMONDILLIUM_BOOTS = register(new ArmorItem(ModArmorMaterials.DIAMONDILLIUM, EquipmentType.BOOTS, new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.RARE).registryKey(key("diamondillium_boots"))), "diamondillium_boots");


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