package jaymanh.optools.WorkStation;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;
import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;

public class ModBlockEntityType {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<Refinery> REFINERY = register(
            "refinery",
            BlockEntityType.Builder.create(Refinery::new, WorkStations.REFINERY).build()
    );

    public static void initialize() {

    }
}
