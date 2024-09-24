package jaymanh.optools;

import jaymanh.optools.Tools.ModTools;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class OpToolsModItemTagProvider extends FabricTagProvider<Item> {
    public OpToolsModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModTools.DIAMONDILLIUM_SWORD)
                .add(ModTools.DIAMONDIUM_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModTools.DIAMONDILLIUM_PICKAXE)
                .add(ModTools.DIAMONDIUM_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModTools.DIAMONDILLIUM_AXE)
                .add(ModTools.DIAMONDIUM_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModTools.DIAMONDILLIUM_HOE)
                .add(ModTools.DIAMONDIUM_HOE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModTools.DIAMONDILLIUM_SHOVEL)
                .add(ModTools.DIAMONDIUM_SHOVEL);

    }
}
