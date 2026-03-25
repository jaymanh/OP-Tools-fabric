package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jaymanh.optools.OpTools.LOGGER;
import static jaymanh.optools.Enchantments.InventoryHelper.*;

public class AutoReplantEnchantment {

    private static final Map<Block, Item> blockToItemMap = new HashMap<>();

    private static final List<ReplantTask> replantTasks = new ArrayList<>();

    static record ReplantTask(ServerLevel world, BlockPos pos, Block block) {}

    static {
        blockToItemMap.put(Blocks.WHEAT, Items.WHEAT_SEEDS);
        blockToItemMap.put(Blocks.CARROTS, Items.CARROT);
        blockToItemMap.put(Blocks.POTATOES, Items.POTATO);
        blockToItemMap.put(Blocks.BEETROOTS, Items.BEETROOT_SEEDS);
        blockToItemMap.put(Blocks.MELON_STEM, Items.MELON_SEEDS);
        blockToItemMap.put(Blocks.PUMPKIN_STEM, Items.PUMPKIN_SEEDS);
        blockToItemMap.put(Blocks.NETHER_WART, Items.NETHER_WART);
        blockToItemMap.put(Blocks.COCOA, Items.COCOA_BEANS);
    }

    private static void scheduleReplant(BlockPos blockPos, Block blockType, ServerLevel world, int level, EnchantedItemInUse context, Entity user) {
        Item item = blockToItemMap.get(blockType);
        if (item != null) {
            Player player = (Player) user;
            ItemStack itemStack = new ItemStack(item);

            if (hasItemInInventory(player, itemStack)) {
                int itemSlot = findItemSlot(player, itemStack);
                removeItemInInventory(player, itemSlot);
                replantTasks.add(new ReplantTask(world, blockPos, blockType));
            }
        }
    }

    public static void initialise() {
        OpTools.register(Identifier.parse("crop_break"), (world, level, context, user, pos) -> {
            BlockPos blockPos = new BlockPos(
                    (int) Math.floor(pos.x),
                    (int) Math.floor(pos.y),
                    (int) Math.floor(pos.z)
            );

            Block block = world.getBlockState(blockPos).getBlock();

            if (world.getBlockState(blockPos).is(BlockTags.CROPS)) {
                ((ServerLevel) world).getServer().execute(() -> {
                    scheduleReplant(blockPos, block, (ServerLevel) world, level, context, user);
                });
            }
        });
    }

    public static List<ReplantTask> getReplantTasks() {
        return replantTasks;
    }
}