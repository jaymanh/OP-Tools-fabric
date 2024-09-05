package jaymanh.optools.Armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class DiamondilliumArmorMaterial implements ArmorMaterial {
    @Override
    public int getDurability(ArmorItem.Type type){

        int multiplier = 256;
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
            case BOOTS -> 4;
            case HELMET -> 5;
            case LEGGINGS -> 7;
            case CHESTPLATE -> 9;
            default -> 0;
        };
    }

    @Override
    public int getEnchantability(){
        return 24;
    }
    @Override
    public SoundEvent getEquipSound(){
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }
    @Override
    public Ingredient getRepairIngredient(){
        return Ingredient.ofItems(Items.AIR);
    }
    @Override
    public String getName(){
        return "diamondillium";
    }
    @Override
    public float getToughness(){
        return 4f;
    }
    @Override
    public float getKnockbackResistance() {
        return 1f;
    }
    public static final DiamondilliumArmorMaterial INSTANCE = new DiamondilliumArmorMaterial();
}
