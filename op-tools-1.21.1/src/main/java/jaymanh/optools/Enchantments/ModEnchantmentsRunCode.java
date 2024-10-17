package jaymanh.optools.Enchantments;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaymanh.optools.OpTools;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

import static com.mojang.text2speech.Narrator.LOGGER;

public record ModEnchantmentsRunCode(Identifier hook) implements EnchantmentEntityEffect {
    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
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
    public MapCodec<ModEnchantmentsRunCode> getCodec() {
        return CODEC;
    }
}
