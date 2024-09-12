package jaymanh.optools.WorkStation;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.LOGGER;
import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;
import static jaymanh.optools.OpTools.MOD_ID;

public class WorkStations {

    public static Block register(Block block, String name, boolean shouldRegisterItem){
        Identifier id = new Identifier(MOD_ID, name);

        if(shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final RefineryBlock REFINERY = (RefineryBlock) register(new RefineryBlock(AbstractBlock.Settings.create()), "refinery", true);


    public static void initialise(){
        //LOGGER.info(String.valueOf(REFINERY)); REFINERY is initialised ???? why is it empty

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(REFINERY.asItem());
        });
    }

}