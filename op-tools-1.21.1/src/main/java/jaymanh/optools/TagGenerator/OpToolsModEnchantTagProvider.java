package jaymanh.optools.TagGenerator;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
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
        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE).addOptionalTag(Identifier.of(MOD_ID, "auto_repair"));

        getOrCreateTagBuilder(EnchantmentTags.ON_TRADED_EQUIPMENT).addOptionalTag(Identifier.of(MOD_ID, "auto_repair"));


    }
}
