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
                .addOptional(ModEnchantments.AUTO_REPAIR)
                .addOptional(ModEnchantments.AUTO_REPLANT)
                .addOptional(ModEnchantments.ELEMENTAL_EARTH)
                .addOptional(ModEnchantments.ELEMENTAL_FIRE)
                .addOptional(ModEnchantments.ELEMENTAL_LIGHTNING)
                .addOptional(ModEnchantments.ELEMENTAL_WATER)
                .addOptional(ModEnchantments.TREE_BREAKER);

        this.builder(EnchantmentTags.ON_TRADED_EQUIPMENT)
                .addOptional(ModEnchantments.AUTO_REPAIR)
                .addOptional(ModEnchantments.AUTO_REPLANT)
                .addOptional(ModEnchantments.ELEMENTAL_EARTH)
                .addOptional(ModEnchantments.ELEMENTAL_FIRE)
                .addOptional(ModEnchantments.ELEMENTAL_LIGHTNING)
                .addOptional(ModEnchantments.ELEMENTAL_WATER)
                .addOptional(ModEnchantments.TREE_BREAKER);

        this.builder(EnchantmentTags.NON_TREASURE)
                .addOptional(ModEnchantments.AUTO_REPAIR)
                .addOptional(ModEnchantments.AUTO_REPLANT)
                .addOptional(ModEnchantments.ELEMENTAL_EARTH)
                .addOptional(ModEnchantments.ELEMENTAL_FIRE)
                .addOptional(ModEnchantments.ELEMENTAL_LIGHTNING)
                .addOptional(ModEnchantments.ELEMENTAL_WATER)
                .addOptional(ModEnchantments.TREE_BREAKER);

        this.builder(EnchantmentTags.IN_ENCHANTING_TABLE)
                .addOptional(ModEnchantments.AUTO_REPAIR)
                .addOptional(ModEnchantments.AUTO_REPLANT)
                .addOptional(ModEnchantments.ELEMENTAL_EARTH)
                .addOptional(ModEnchantments.ELEMENTAL_FIRE)
                .addOptional(ModEnchantments.ELEMENTAL_LIGHTNING)
                .addOptional(ModEnchantments.ELEMENTAL_WATER)
                .addOptional(ModEnchantments.TREE_BREAKER)
                .addOptional(Enchantments.MENDING);
    }
}