package jaymanh.optools.Armor;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.equipment.ArmorType;

import static jaymanh.optools.Tools.ModTools.*;

public class ModArmor {

    public static final Item DIAMONDIUM_HELMET = register(new Item(new Item.Properties().humanoidArmor(ModArmorMaterials.DIAMONDIUM, ArmorType.HELMET).durability(ArmorType.HELMET.getDurability(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireResistant().rarity(Rarity.EPIC).setId(key("diamondium_helmet"))), "diamondium_helmet");
    public static final Item DIAMONDIUM_CHESTPLATE = register(new Item(new Item.Properties().humanoidArmor(ModArmorMaterials.DIAMONDIUM, ArmorType.CHESTPLATE).durability(ArmorType.CHESTPLATE.getDurability(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireResistant().rarity(Rarity.EPIC).setId(key("diamondium_chestplate"))), "diamondium_chestplate");
    public static final Item DIAMONDIUM_LEGGINGS = register(new Item(new Item.Properties().humanoidArmor(ModArmorMaterials.DIAMONDIUM, ArmorType.LEGGINGS).durability(ArmorType.LEGGINGS.getDurability(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireResistant().rarity(Rarity.EPIC).setId(key("diamondium_leggings"))), "diamondium_leggings");
    public static final Item DIAMONDIUM_BOOTS = register(new Item(new Item.Properties().humanoidArmor(ModArmorMaterials.DIAMONDIUM, ArmorType.BOOTS).durability(ArmorType.BOOTS.getDurability(ModArmorMaterials.DIAMONDIUM_DURABILITY_MULTIPLIER)).fireResistant().rarity(Rarity.EPIC).setId(key("diamondium_boots"))), "diamondium_boots");


    public static final Item DIAMONDILLIUM_HELMET = register(new Item(new Item.Properties().humanoidArmor(ModArmorMaterials.DIAMONDILLIUM, ArmorType.HELMET).durability(ArmorType.HELMET.getDurability(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireResistant().rarity(Rarity.RARE).setId(key("diamondillium_helmet"))), "diamondillium_helmet");
    public static final Item DIAMONDILLIUM_CHESTPLATE = register(new Item(new Item.Properties().humanoidArmor(ModArmorMaterials.DIAMONDILLIUM, ArmorType.CHESTPLATE).durability(ArmorType.CHESTPLATE.getDurability(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireResistant().rarity(Rarity.RARE).setId(key("diamondillium_chestplate"))), "diamondillium_chestplate");
    public static final Item DIAMONDILLIUM_LEGGINGS = register(new Item(new Item.Properties().humanoidArmor(ModArmorMaterials.DIAMONDILLIUM, ArmorType.LEGGINGS).durability(ArmorType.LEGGINGS.getDurability(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireResistant().rarity(Rarity.RARE).setId(key("diamondillium_leggings"))), "diamondillium_leggings");
    public static final Item DIAMONDILLIUM_BOOTS = register(new Item(new Item.Properties().humanoidArmor(ModArmorMaterials.DIAMONDILLIUM, ArmorType.BOOTS).durability(ArmorType.BOOTS.getDurability(ModArmorMaterials.DIAMONDILLIUM_DURABILITY_MULTIPLIER)).fireResistant().rarity(Rarity.RARE).setId(key("diamondillium_boots"))), "diamondillium_boots");

    public static void initialise(){

        CreativeModeTabEvents.modifyOutputEvent(OP_TOOLS_ITEM_GROUP_KEY).register(event -> {
            event.accept(DIAMONDIUM_HELMET);
            event.accept(DIAMONDIUM_CHESTPLATE);
            event.accept(DIAMONDIUM_LEGGINGS);
            event.accept(DIAMONDIUM_BOOTS);

            event.accept(DIAMONDILLIUM_HELMET);
            event.accept(DIAMONDILLIUM_CHESTPLATE);
            event.accept(DIAMONDILLIUM_LEGGINGS);
            event.accept(DIAMONDILLIUM_BOOTS);

        });
    }
}