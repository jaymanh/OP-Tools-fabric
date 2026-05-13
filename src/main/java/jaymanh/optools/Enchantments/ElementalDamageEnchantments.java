package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import static jaymanh.optools.OpTools.LOGGER;

public class ElementalDamageEnchantments {

    private static void createFireRadius(BlockPos center, Level world, int radius) {
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos posToCheck = center.offset(x, y, z);
                    if (x * x + y * y + z * z <= radius * radius) {
                        if (world.isEmptyBlock(posToCheck) || world.getBlockState(posToCheck).getBlock() == Blocks.TALL_GRASS || world.getBlockState(posToCheck).getBlock() == Blocks.SHORT_GRASS) {
                            world.setBlockAndUpdate(posToCheck, Blocks.FIRE.defaultBlockState());
                        }
                    }
                }
            }
        }
    }



    public static void initialise(){
        OpTools.register(Identifier.parse("elemental_fire"), (world, level, context, user, pos) -> {
            BlockPos victimBlockPos = user.blockPosition();
            level--;
            createFireRadius(victimBlockPos, world, level);
            //world.setBlockState(victimBlockPos, Blocks.FIRE.getDefaultState());
        });

        OpTools.register(Identifier.parse("elemental_water"), (world, level, context, user, pos) -> {
            user.setDeltaMovement(user.getDeltaMovement().x,0.02,user.getDeltaMovement().z);
            user.setNoGravity(true);
            user.addTag("Gravity");
            user.addTag("Num0");
            world.sendParticles(ParticleTypes.BUBBLE, user.getX(), user.getY(), user.getZ(), 100, 0.5,1,0.5,10);
        });

        OpTools.register(Identifier.parse("elemental_earth"), (world, level, context, user, pos) -> {
            user.setDeltaMovement(0,0,0);
            user.setPosRaw(user.getX(), user.getY() - (0.8 * level), user.getZ());
            if(user instanceof Mob mob){
                mob.getNavigation().stop();
            }
        });

        OpTools.register(Identifier.parse("elemental_lightning"), (world, level, context, user, pos) -> {
            LOGGER.info("test");
            LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
            lightning.setPos(user.position());
            world.addFreshEntity(lightning);
        });

        OpTools.register(Identifier.parse("elemental_ice"), (world, level, context, user, pos) -> {
            //I should probably make my own effect here so it can be a more gradual thing that builds up slowly and wears off slowly
            if(user instanceof LivingEntity mob){
                mob.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 100, level));
            }
        });
    }
}
