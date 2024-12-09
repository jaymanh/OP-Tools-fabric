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
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static jaymanh.optools.OpTools.LOGGER;

public class AutoReplantEnchantment {

    private static void ReplantCrop(BlockPos blockPos, Block blockType, World world, int level, EnchantmentEffectContext context, Entity user){
        LOGGER.info(blockType.toString());
        //world.breakBlock(blockPos, true);
        world.setBlockState(blockPos, blockType.getDefaultState().with(Properties.AGE_7, 0));

    }

    public static void initialise(){
        OpTools.register(Identifier.of("crop_break"), (world, level, context, user, pos) -> {
            BlockPos blockPos = new BlockPos((int)pos.x, (int)pos.y,(int)pos.z);

            if(world.getBlockState(blockPos).getBlock() == Blocks.CARROTS || world.getBlockState(blockPos).getBlock() == Blocks.POTATOES || world.getBlockState(blockPos).getBlock() == Blocks.BEETROOTS
            || world.getBlockState(blockPos).getBlock() == Blocks.NETHER_WART || world.getBlockState(blockPos).getBlock() == Blocks.WHEAT || world.getBlockState(blockPos).getBlock() == Blocks.MELON_STEM
            || world.getBlockState(blockPos).getBlock() == Blocks.PUMPKIN_STEM || world.getBlockState(blockPos).getBlock() == Blocks.COCOA || world.getBlockState(blockPos).getBlock() == Blocks.PITCHER_PLANT
            || world.getBlockState(blockPos).getBlock() == Blocks.TORCHFLOWER_CROP){
                ReplantCrop(blockPos, world.getBlockState(blockPos).getBlock(), world, level, context, user);
            }
        });
    }
}
