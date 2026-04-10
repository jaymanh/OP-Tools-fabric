package jaymanh.optools.OreGen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModOreGenerator {
    public static final ResourceKey<PlacedFeature> DARKMATTER_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MOD_ID, "darkmatter_ore_gen"));

    public static void initialise(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, DARKMATTER_ORE_PLACED_KEY);
    }
}
