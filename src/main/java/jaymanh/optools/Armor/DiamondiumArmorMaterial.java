package jaymanh.optools.Armor;

import jaymanh.optools.Items.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class DiamondiumArmorMaterial implements ArmorMaterial {
    @Override
    public int getDurability(ArmorItem.Type type){

        int multiplier = 512;
        return switch (type){
            case BOOTS -> 13 * multiplier;
            case HELMET -> 11 * multiplier;
            case LEGGINGS -> 15 * multiplier;
            case CHESTPLATE -> 16 * multiplier;
            default -> 0;
        };
    }

    @Override
    public int getProtection(ArmorItem.Type type){
        return switch (type){
            case BOOTS -> 6;
            case HELMET -> 7;
            case LEGGINGS -> 10;
            case CHESTPLATE -> 13;
            default -> 0;
        };
    }

    @Override
    public int getEnchantability(){
        return 35;
    }
    @Override
    public SoundEvent getEquipSound(){
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }
    @Override
    public Ingredient getRepairIngredient(){
        return Ingredient.ofItems(ModItems.DIAMONDIUM_INGOT);
    }
    @Override
    public String getName(){
        return "diamondium";
    }
    @Override
    public float getToughness(){
        return 6f;
    }
    @Override
    public float getKnockbackResistance() {
        return 1.5f;
    }

    public static final DiamondiumArmorMaterial INSTANCE = new DiamondiumArmorMaterial();
}
