package jaymanh.optools.WorkStation;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;
import static jaymanh.optools.OpTools.MOD_ID;

public class WorkStations {

    public static final RefineryBlock REFINERY = Registry.register(
            Registries.BLOCK,
            new Identifier(MOD_ID, "refinery"),
            new RefineryBlock(AbstractBlock.Settings.create())
    );
    public static void initialise(){

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(REFINERY.asItem());
        });
    }

}

