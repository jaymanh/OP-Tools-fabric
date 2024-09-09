package jaymanh.optools.Blocks;

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

public class ModBlocks {
    public static Block register(Block block, String name, boolean shouldRegisterItem){
        Identifier id = new Identifier(MOD_ID, name);

        if(shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final Block DIAMONDIUM_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE).hardness(5f).requiresTool()),
            "diamondium_block",
            true
    );

    public static final Block DIAMONDILLIUM_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE).hardness(5f).requiresTool()),
            "diamondillium_block",
            true
    );

    public static void initialize(){

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.DIAMONDIUM_BLOCK.asItem());
            itemGroup.add(ModBlocks.DIAMONDILLIUM_BLOCK.asItem());
        });

    }
}
