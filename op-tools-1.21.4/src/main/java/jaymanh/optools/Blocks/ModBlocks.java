package jaymanh.optools.Blocks;

import jaymanh.optools.Blocks.CustomBlockTypes.RefineryBlock;
import jaymanh.optools.Tools.ModTools;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;
import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;

public class ModBlocks {
    public static Block register(Block block, String name, boolean shouldRegisterItem){
        if(shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(ModTools.key(name)).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, ModTools.key(name), blockItem);
        }
        return Registry.register(Registries.BLOCK, key(name), block);
    }

    public static RegistryKey<Block> key(String id){
        Identifier BLOCK_ID = Identifier.of(MOD_ID, id);
        return RegistryKey.of(RegistryKeys.BLOCK, BLOCK_ID);
    }

    public static final Block DIAMONDIUM_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE).hardness(4f).requiresTool().registryKey(key("diamondium_block"))),
            "diamondium_block",
            true
    );

    public static final Block DIAMONDILLIUM_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE).hardness(5f).requiresTool().registryKey(key("diamondillium_block"))),
            "diamondillium_block",
            true
    );

    public static final Block STONE_DARKMATTER_ORE = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).hardness(1f).requiresTool().registryKey(key("stone_darkmatter_ore"))),
            "stone_darkmatter_ore",
            true
    );

    public static final Block DEEPSLATE_DARKMATTER_ORE = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE).hardness(1.5f).requiresTool().registryKey(key("deepslate_darkmatter_ore"))),
            "deepslate_darkmatter_ore",
            true
    );

    public static final Block REFINERY = register(
            new RefineryBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).hardness(0.5f).registryKey(key("refinery"))),
            "refinery",
            true
    );

    public static void initialize(){

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.DIAMONDIUM_BLOCK.asItem());
            itemGroup.add(ModBlocks.DIAMONDILLIUM_BLOCK.asItem());
            itemGroup.add(ModBlocks.STONE_DARKMATTER_ORE.asItem());
            itemGroup.add(ModBlocks.DEEPSLATE_DARKMATTER_ORE.asItem());
            itemGroup.add(ModBlocks.REFINERY.asItem());
        });
    }
}
