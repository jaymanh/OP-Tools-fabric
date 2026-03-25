package jaymanh.optools.Enchantments;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaymanh.optools.OpTools;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

import static jaymanh.optools.OpTools.LOGGER;

public record ModEnchantmentsRunCode(Identifier hook) implements EnchantmentEntityEffect {
    @Override
    public void apply(ServerLevel world, int level, EnchantedItemInUse context, Entity user, Vec3 pos) {
        OpTools.CodeRunner runner = OpTools.get(hook);
        if (runner != null){
            runner.run(world, level, context, user, pos);
        }
        else{
            LOGGER.error("Run_code failed no hook: {}", this.hook);
        }
    }

    public static final MapCodec<ModEnchantmentsRunCode> CODEC = RecordCodecBuilder.mapCodec(
      instance -> instance.group(Identifier.CODEC.fieldOf("hook").forGetter(ModEnchantmentsRunCode::hook))
              .apply(instance, ModEnchantmentsRunCode::new)
    );

    @Override
    public MapCodec<ModEnchantmentsRunCode> codec() {
        return CODEC;
    }
}
