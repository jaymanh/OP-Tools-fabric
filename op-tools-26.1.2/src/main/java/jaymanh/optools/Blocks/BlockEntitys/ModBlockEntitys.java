package jaymanh.optools.Blocks.BlockEntitys;

import jaymanh.optools.Blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModBlockEntitys {
    public static final BlockEntityType<RefineryBlockEntity> REFINERY_BLOCK_ENTITY =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, "refinery"),
                    FabricBlockEntityTypeBuilder.create(RefineryBlockEntity::new, ModBlocks.REFINERY).build());

    public static void initialise(){

    }
}