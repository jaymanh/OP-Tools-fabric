package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static jaymanh.optools.OpTools.LOGGER;

public class AutoReplantEnchantment{

    private static void ReplantCrop(BlockPos blockPos, Block blockType, World world, int level, EnchantmentEffectContext context, Entity user) {
        LOGGER.info(blockType.toString());
        world.setBlockState(blockPos, blockType.getDefaultState());
    }

    public static void initialise() {
        OpTools.register(Identifier.of("crop_break"), (world, level, context, user, pos) -> {
            BlockPos blockPos = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);

            if (world.getBlockState(blockPos).getBlock() == Blocks.CARROTS || world.getBlockState(blockPos).getBlock() == Blocks.POTATOES ||
                    world.getBlockState(blockPos).getBlock() == Blocks.BEETROOTS || world.getBlockState(blockPos).getBlock() == Blocks.NETHER_WART ||
                    world.getBlockState(blockPos).getBlock() == Blocks.WHEAT || world.getBlockState(blockPos).getBlock() == Blocks.MELON_STEM ||
                    world.getBlockState(blockPos).getBlock() == Blocks.PUMPKIN_STEM || world.getBlockState(blockPos).getBlock() == Blocks.COCOA ||
                    world.getBlockState(blockPos).getBlock() == Blocks.PITCHER_PLANT || world.getBlockState(blockPos).getBlock() == Blocks.TORCHFLOWER_CROP) {
                Block blockType = world.getBlockState(blockPos).getBlock();
                ServerWorld serverWorld = (ServerWorld) world;

                serverWorld.getServer().execute(() -> {
                    ReplantCrop(blockPos, blockType, world, level, context, user);
                });
            }
        });
    }
}
