package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

import static jaymanh.optools.OpTools.LOGGER;
import static jaymanh.optools.Enchantments.InventoryHelper.*;

public class AutoReplantEnchantment{

    private static final Map<Block, Item> blockToItemMap = new HashMap<>();

    static {
        blockToItemMap.put(Blocks.CARROTS, Items.CARROT);
        blockToItemMap.put(Blocks.POTATOES, Items.POTATO);
        blockToItemMap.put(Blocks.BEETROOTS, Items.BEETROOT);
        blockToItemMap.put(Blocks.NETHER_WART, Items.NETHER_WART);
        blockToItemMap.put(Blocks.WHEAT, Items.WHEAT);
        blockToItemMap.put(Blocks.MELON_STEM, Items.MELON_SEEDS);
        blockToItemMap.put(Blocks.PUMPKIN_STEM, Items.PUMPKIN_SEEDS);
        blockToItemMap.put(Blocks.COCOA, Items.COCOA_BEANS);
    }

    private static void ReplantCrop(BlockPos blockPos, Block blockType, World world, int level, EnchantmentEffectContext context, Entity user) {
        LOGGER.info(blockType.toString());

        Item item = blockToItemMap.get(blockType);

        if(item != null) {
            PlayerEntity player = (PlayerEntity) user;
            ItemStack itemStack = new ItemStack(item);
            if(hasItemInInventory(player, itemStack)){

            }
            
            world.setBlockState(blockPos, blockType.getDefaultState());
        }
    }

    public static void initialise() {
        OpTools.register(Identifier.of("crop_break"), (world, level, context, user, pos) -> {
            BlockPos blockPos = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);

            if (world.getBlockState(blockPos).getBlock() == Blocks.CARROTS || world.getBlockState(blockPos).getBlock() == Blocks.POTATOES ||
                    world.getBlockState(blockPos).getBlock() == Blocks.BEETROOTS || world.getBlockState(blockPos).getBlock() == Blocks.NETHER_WART ||
                    world.getBlockState(blockPos).getBlock() == Blocks.WHEAT || world.getBlockState(blockPos).getBlock() == Blocks.MELON_STEM ||
                    world.getBlockState(blockPos).getBlock() == Blocks.PUMPKIN_STEM || world.getBlockState(blockPos).getBlock() == Blocks.COCOA) {
                Block blockType = world.getBlockState(blockPos).getBlock();
                ServerWorld serverWorld = (ServerWorld) world;

                serverWorld.getServer().execute(() -> {
                    ReplantCrop(blockPos, blockType, world, level, context, user);
                });
            }
        });
    }
}
