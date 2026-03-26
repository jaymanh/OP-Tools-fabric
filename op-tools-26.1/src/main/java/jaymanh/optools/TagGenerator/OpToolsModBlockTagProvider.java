package jaymanh.optools.TagGenerator;

import jaymanh.optools.Blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import java.util.concurrent.CompletableFuture;

public class OpToolsModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public OpToolsModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
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
