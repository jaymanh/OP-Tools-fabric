package jaymanh.optools.Armor;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import java.util.EnumMap;

import static jaymanh.optools.OpTools.MOD_ID;
import static jaymanh.optools.Tools.TagKeys.ItemKeys.DIAMONDILLIUM_REPAIR_ITEMS;

public class ModArmorMaterials implements ArmorMaterials {

    public static final int DIAMONDILLIUM_DURABILITY_MULTIPLIER = 256;
    public static final int DIAMONDIUM_DURABILITY_MULTIPLIER = 512;


    public static final ArmorMaterial DIAMONDILLIUM = new ArmorMaterial(DIAMONDILLIUM_DURABILITY_MULTIPLIER, Util.make(new EnumMap(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 5);
        map.put(ArmorType.LEGGINGS, 9);
        map.put(ArmorType.CHESTPLATE, 7);
        map.put(ArmorType.HELMET, 4);
    }), 24, SoundEvents.ARMOR_EQUIP_NETHERITE, 4, 1, TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID,"diamondillium_repair_item")), CustomArmorModels.DIAMONDILLIUM);

    public static final ArmorMaterial DIAMONDIUM = new ArmorMaterial(DIAMONDIUM_DURABILITY_MULTIPLIER, Util.make(new EnumMap(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 7);
        map.put(ArmorType.LEGGINGS, 15);
        map.put(ArmorType.CHESTPLATE, 11);
        map.put(ArmorType.HELMET, 6);
    }), 24, SoundEvents.ARMOR_EQUIP_NETHERITE, 6, 1.5f, DIAMONDILLIUM_REPAIR_ITEMS, CustomArmorModels.DIAMONDIUM);

    public static void initialise(){

    }
}