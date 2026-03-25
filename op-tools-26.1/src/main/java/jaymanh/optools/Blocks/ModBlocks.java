package jaymanh.optools.Blocks;

import jaymanh.optools.Blocks.CustomBlockTypes.RefineryBlock;
import jaymanh.optools.Tools.ModTools;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static jaymanh.optools.OpTools.MOD_ID;
import static jaymanh.optools.Tools.ModTools.OP_TOOLS_ITEM_GROUP_KEY;

public class ModBlocks {
    public static Block register(Block block, String name, boolean shouldRegisterItem){
        if(shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(ModTools.key(name)).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, ModTools.key(name), blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, key(name), block);
    }

    public static ResourceKey<Block> key(String id){
        Identifier BLOCK_ID = Identifier.fromNamespaceAndPath(MOD_ID, id);
        return ResourceKey.create(Registries.BLOCK, BLOCK_ID);
    }

    public static final Block DIAMONDIUM_BLOCK = register(
            new Block(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK).destroyTime(4f).requiresCorrectToolForDrops().setId(key("diamondium_block"))),
            "diamondium_block",
            true
    );

    public static final Block DIAMONDILLIUM_BLOCK = register(
            new Block(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK).destroyTime(5f).requiresCorrectToolForDrops().setId(key("diamondillium_block"))),
            "diamondillium_block",
            true
    );

    public static final Block STONE_DARKMATTER_ORE = register(
            new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).destroyTime(1f).requiresCorrectToolForDrops().setId(key("stone_darkmatter_ore"))),
            "stone_darkmatter_ore",
            true
    );

    public static final Block DEEPSLATE_DARKMATTER_ORE = register(
            new Block(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).destroyTime(1.5f).requiresCorrectToolForDrops().setId(key("deepslate_darkmatter_ore"))),
            "deepslate_darkmatter_ore",
            true
    );

    public static final Block REFINERY = register(
            new RefineryBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).destroyTime(0.5f).setId(key("refinery"))),
            "refinery",
            true
    );

    public static void initialize(){

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(ModBlocks.DIAMONDIUM_BLOCK.asItem());
            itemGroup.accept(ModBlocks.DIAMONDILLIUM_BLOCK.asItem());
            itemGroup.accept(ModBlocks.STONE_DARKMATTER_ORE.asItem());
            itemGroup.accept(ModBlocks.DEEPSLATE_DARKMATTER_ORE.asItem());
            itemGroup.accept(ModBlocks.REFINERY.asItem());
        });
    }
}
