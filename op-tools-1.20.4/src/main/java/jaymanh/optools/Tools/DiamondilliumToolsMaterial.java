package jaymanh.optools.Tools;

import jaymanh.optools.Items.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DiamondilliumToolsMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 4096;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 20f;
    }

    @Override
    public float getAttackDamage(){
        return 8f;
    }

    @Override
    public int getMiningLevel(){
        return 3;
    }

    @Override
    public int getEnchantability(){
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient(){
        return Ingredient.ofItems(ModItems.DIAMONDILLIUM_INGOT);
    }

    public static final DiamondilliumToolsMaterial INSTANCE = new DiamondilliumToolsMaterial();
}
