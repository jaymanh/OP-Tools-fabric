package jaymanh.optools.TagGenerator;

import jaymanh.optools.Armor.ModArmor;
import jaymanh.optools.Foods.ModFoodItems;
import jaymanh.optools.Items.ModItems;
import jaymanh.optools.Tools.ModTools;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class OpToolsModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public OpToolsModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModTools.DIAMONDILLIUM_SWORD)
                .add(ModTools.DIAMONDIUM_SWORD);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModTools.DIAMONDILLIUM_PICKAXE)
                .add(ModTools.DIAMONDIUM_PICKAXE);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModTools.DIAMONDILLIUM_AXE)
                .add(ModTools.DIAMONDIUM_AXE);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModTools.DIAMONDILLIUM_HOE)
                .add(ModTools.DIAMONDIUM_HOE);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModTools.DIAMONDILLIUM_SHOVEL)
                .add(ModTools.DIAMONDIUM_SHOVEL);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModArmor.DIAMONDILLIUM_HELMET)
                .add(ModArmor.DIAMONDIUM_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModArmor.DIAMONDILLIUM_CHESTPLATE)
                .add(ModArmor.DIAMONDIUM_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModArmor.DIAMONDILLIUM_LEGGINGS)
                .add(ModArmor.DIAMONDIUM_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModArmor.DIAMONDILLIUM_BOOTS)
                .add(ModArmor.DIAMONDIUM_BOOTS);

        valueLookupBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.DIAMONDILLIUM_INGOT)
                .add(ModItems.DIAMONDIUM_INGOT);

        valueLookupBuilder(ItemTags.MEAT)
                .add(ModFoodItems.SUPER_MEAT);
    }
}
