package jaymanh.optools.TagGenerator;

import jaymanh.optools.Enchantments.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

public class OpToolsModEnchantTagProvider extends FabricTagProvider<Enchantment> {
    public OpToolsModEnchantTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ENCHANTMENT, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE).add(ModEnchantments.AUTO_REPAIR);

        getOrCreateTagBuilder(EnchantmentTags.ON_TRADED_EQUIPMENT).add(ModEnchantments.AUTO_REPAIR);


    }
}
