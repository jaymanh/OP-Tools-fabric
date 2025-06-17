package jaymanh.optools.TagGenerator;

import jaymanh.optools.Enchantments.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.tag.EnchantmentTagProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;

import java.util.concurrent.CompletableFuture;


public class OpToolsModEnchantTagProvider extends EnchantmentTagProvider {
    public OpToolsModEnchantTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        this.builder(EnchantmentTags.IN_ENCHANTING_TABLE)
                .add(ModEnchantments.AUTO_REPAIR)
                .add(ModEnchantments.AUTO_REPLANT)
                .add(ModEnchantments.ELEMENTAL_EARTH)
                .add(ModEnchantments.ELEMENTAL_FIRE)
                .add(ModEnchantments.ELEMENTAL_LIGHTNING)
                .add(ModEnchantments.ELEMENTAL_WATER)
                .add(ModEnchantments.TREE_BREAKER);

        this.builder(EnchantmentTags.ON_TRADED_EQUIPMENT)
                .add(ModEnchantments.AUTO_REPAIR)
                .add(ModEnchantments.AUTO_REPLANT)
                .add(ModEnchantments.ELEMENTAL_EARTH)
                .add(ModEnchantments.ELEMENTAL_FIRE)
                .add(ModEnchantments.ELEMENTAL_LIGHTNING)
                .add(ModEnchantments.ELEMENTAL_WATER)
                .add(ModEnchantments.TREE_BREAKER);

        this.builder(EnchantmentTags.NON_TREASURE)
                .add(ModEnchantments.AUTO_REPAIR)
                .add(ModEnchantments.AUTO_REPLANT)
                .add(ModEnchantments.ELEMENTAL_EARTH)
                .add(ModEnchantments.ELEMENTAL_FIRE)
                .add(ModEnchantments.ELEMENTAL_LIGHTNING)
                .add(ModEnchantments.ELEMENTAL_WATER)
                .add(ModEnchantments.TREE_BREAKER);

        this.builder(EnchantmentTags.IN_ENCHANTING_TABLE)
                .add(ModEnchantments.AUTO_REPAIR)
                .add(ModEnchantments.AUTO_REPLANT)
                .add(ModEnchantments.ELEMENTAL_EARTH)
                .add(ModEnchantments.ELEMENTAL_FIRE)
                .add(ModEnchantments.ELEMENTAL_LIGHTNING)
                .add(ModEnchantments.ELEMENTAL_WATER)
                .add(ModEnchantments.TREE_BREAKER)
                .add(Enchantments.MENDING);
    }
}