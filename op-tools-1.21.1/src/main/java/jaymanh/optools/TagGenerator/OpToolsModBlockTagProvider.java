package jaymanh.optools.TagGenerator;

import jaymanh.optools.Blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class OpToolsModBlockTagProvider extends FabricTagProvider<Block> {
    public OpToolsModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DIAMONDILLIUM_BLOCK)
                .add(ModBlocks.DIAMONDIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_DARKMATTER_ORE)
                .add(ModBlocks.STONE_DARKMATTER_ORE)
                .add(ModBlocks.REFINERY);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.DIAMONDILLIUM_BLOCK)
                .add(ModBlocks.DIAMONDIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DIAMONDILLIUM_BLOCK)
                .add(ModBlocks.DIAMONDIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_DARKMATTER_ORE)
                .add(ModBlocks.STONE_DARKMATTER_ORE);
    }
}
