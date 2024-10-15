package jaymanh.optools.TagGenerator;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static jaymanh.optools.OpTools.MOD_ID;

public class OpToolsModEnchantTagProvider extends FabricTagProvider<Enchantment> {
    public OpToolsModEnchantTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ENCHANTMENT, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(Identifier.of(MOD_ID, "auto_replant")).addOptional(Identifier.of(MOD_ID, "tree_breaker"));

        getOrCreateTagBuilder(EnchantmentTags.ON_TRADED_EQUIPMENT).addOptional(Identifier.of(MOD_ID, "auto_replant")).addOptional(Identifier.of(MOD_ID, "tree_breaker"));

        getOrCreateTagBuilder(EnchantmentTags.NON_TREASURE).addOptional(Identifier.of(MOD_ID, "auto_replant")).addOptional(Identifier.of(MOD_ID, "tree_breaker"));

        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE).add(Enchantments.MENDING);
    }
}