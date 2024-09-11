package jaymanh.optools.WorkStation;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;
import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;

public class WorkStations {

    public static Block register(Block block, String name, boolean shouldRegisterItem){
        Identifier id = new Identifier(MOD_ID, name);

        if(shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final Refinery REFINERY = (Refinery) register(
            new Refinery(AbstractBlock.Settings.create().sounds(BlockSoundGroup.ANVIL).hardness(0.5f)),
            "refinery",
            true
    );

    public static void initialise(){

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(WorkStations.REFINERY.asItem());
        });

    }
}
