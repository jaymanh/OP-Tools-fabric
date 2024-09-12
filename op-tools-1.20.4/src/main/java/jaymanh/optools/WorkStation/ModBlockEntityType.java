package jaymanh.optools.WorkStation;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModBlockEntityType {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<RefineryBlockEntity> REFINERY = register(
            "refinery",
            BlockEntityType.Builder.create(RefineryBlockEntity::new, WorkStations.REFINERY).build()
    );

    public static void initialise(){

    }
}