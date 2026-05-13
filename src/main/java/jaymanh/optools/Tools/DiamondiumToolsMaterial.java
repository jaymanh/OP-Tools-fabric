package jaymanh.optools.Tools;

import jaymanh.optools.Items.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DiamondiumToolsMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 8192;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 30f;
    }

    @Override
    public float getAttackDamage(){
        return 10f;
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
        return Ingredient.ofItems(ModItems.DIAMONDIUM_INGOT);
    }

    public static final DiamondiumToolsMaterial INSTANCE = new DiamondiumToolsMaterial();
}
