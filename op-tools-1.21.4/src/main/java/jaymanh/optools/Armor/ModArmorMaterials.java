package jaymanh.optools.Armor;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

import static jaymanh.optools.OpTools.MOD_ID;
import static jaymanh.optools.Tools.TagKeys.ItemKeys.DIAMONDILLIUM_REPAIR_ITEMS;

public class ModArmorMaterials implements ArmorMaterials {

    public static final int DIAMONDILLIUM_DURABILITY_MULTIPLIER = 256;
    public static final int DIAMONDIUM_DURABILITY_MULTIPLIER = 512;


    public static final ArmorMaterial DIAMONDILLIUM = new ArmorMaterial(DIAMONDILLIUM_DURABILITY_MULTIPLIER, Util.make(new EnumMap(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 5);
        map.put(EquipmentType.LEGGINGS, 9);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 4);
    }), 24, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4, 1, TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID,"diamondillium_repair_item")), CustomArmorModels.DIAMONDILLIUM);

    public static final ArmorMaterial DIAMONDIUM = new ArmorMaterial(DIAMONDIUM_DURABILITY_MULTIPLIER, Util.make(new EnumMap(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 7);
        map.put(EquipmentType.LEGGINGS, 15);
        map.put(EquipmentType.CHESTPLATE, 11);
        map.put(EquipmentType.HELMET, 6);
    }), 24, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 6, 1.5f, DIAMONDILLIUM_REPAIR_ITEMS, CustomArmorModels.DIAMONDIUM);

    public static void initialise(){

    }
}