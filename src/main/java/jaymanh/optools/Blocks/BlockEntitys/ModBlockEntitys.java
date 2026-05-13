package jaymanh.optools.Blocks.BlockEntitys;

import jaymanh.optools.Blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModBlockEntitys {
    public static final BlockEntityType<RefineryBlockEntity> REFINERY_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MOD_ID, "refinery"),
                    FabricBlockEntityTypeBuilder.create(RefineryBlockEntity::new, ModBlocks.REFINERY).build());

    public static void initialise(){

    }
}