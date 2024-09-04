package jaymanh.optools.Tools;

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
        return Ingredient.ofItems(Items.AIR);
    }

    public static final DiamondilliumToolsMaterial INSTANCE = new DiamondilliumToolsMaterial();
}
