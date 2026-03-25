package jaymanh.optools.TagGenerator;

import jaymanh.optools.Enchantments.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;
import java.util.concurrent.CompletableFuture;


public class OpToolsModEnchantTagProvider extends EnchantmentTagsProvider {
    public OpToolsModEnchantTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {

        this.tag(EnchantmentTags.IN_ENCHANTING_TABLE)
                .addOptional(ModEnchantments.AUTO_REPAIR)
                .addOptional(ModEnchantments.AUTO_REPLANT)
                .addOptional(ModEnchantments.ELEMENTAL_EARTH)
                .addOptional(ModEnchantments.ELEMENTAL_FIRE)
                .addOptional(ModEnchantments.ELEMENTAL_LIGHTNING)
                .addOptional(ModEnchantments.ELEMENTAL_WATER)
                .addOptional(ModEnchantments.TREE_BREAKER);

        this.tag(EnchantmentTags.ON_TRADED_EQUIPMENT)
                .addOptional(ModEnchantments.AUTO_REPAIR)
                .addOptional(ModEnchantments.AUTO_REPLANT)
                .addOptional(ModEnchantments.ELEMENTAL_EARTH)
                .addOptional(ModEnchantments.ELEMENTAL_FIRE)
                .addOptional(ModEnchantments.ELEMENTAL_LIGHTNING)
                .addOptional(ModEnchantments.ELEMENTAL_WATER)
                .addOptional(ModEnchantments.TREE_BREAKER);

        this.tag(EnchantmentTags.NON_TREASURE)
                .addOptional(ModEnchantments.AUTO_REPAIR)
                .addOptional(ModEnchantments.AUTO_REPLANT)
                .addOptional(ModEnchantments.ELEMENTAL_EARTH)
                .addOptional(ModEnchantments.ELEMENTAL_FIRE)
                .addOptional(ModEnchantments.ELEMENTAL_LIGHTNING)
                .addOptional(ModEnchantments.ELEMENTAL_WATER)
                .addOptional(ModEnchantments.TREE_BREAKER);

        this.tag(EnchantmentTags.IN_ENCHANTING_TABLE)
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