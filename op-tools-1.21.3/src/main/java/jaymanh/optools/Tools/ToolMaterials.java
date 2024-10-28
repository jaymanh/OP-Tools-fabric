package jaymanh.optools.Tools;

import net.minecraft.item.ToolMaterial;

import static jaymanh.optools.Tools.TagKeys.ItemKeys.DIAMONDILLIUM_REPAIR_ITEMS;
import static jaymanh.optools.Tools.TagKeys.ItemKeys.DIAMONDIUM_REPAIR_ITEMS;
import static net.minecraft.registry.tag.BlockTags.*;

public enum ToolMaterials {
    DIAMONDILLIUM(
            new ToolMaterial(
                    INCORRECT_FOR_DIAMOND_TOOL, 4096, 20f, 8f, 30,
                    DIAMONDILLIUM_REPAIR_ITEMS
            )
    ),
    DIAMONDIUM(
            new ToolMaterial(
            INCORRECT_FOR_DIAMOND_TOOL, 8192, 30f, 10f, 30,
            DIAMONDIUM_REPAIR_ITEMS
            )
    );


    private final ToolMaterial material;

    ToolMaterials(ToolMaterial material) {
        this.material = material;
    }

    public ToolMaterial getMaterial() {
        return this.material;
    }
}
