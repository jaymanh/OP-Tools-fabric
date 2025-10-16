package jaymanh.optools.TagGenerator;

import jaymanh.optools.Blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class OpToolsModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public OpToolsModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DIAMONDILLIUM_BLOCK)
                .add(ModBlocks.DIAMONDIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_DARKMATTER_ORE)
                .add(ModBlocks.STONE_DARKMATTER_ORE)
                .add(ModBlocks.REFINERY);

        valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.DIAMONDILLIUM_BLOCK)
                .add(ModBlocks.DIAMONDIUM_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DIAMONDILLIUM_BLOCK)
                .add(ModBlocks.DIAMONDIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_DARKMATTER_ORE)
                .add(ModBlocks.STONE_DARKMATTER_ORE);
    }
}
