package jaymanh.optools.Enchantments;

import jaymanh.optools.OpTools;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import java.util.Random;

import static jaymanh.optools.OpTools.LOGGER;

public class AutoRepairEnchantment {

    private static final Random random = new Random();

    public static void initialise() {
        OpTools.register(Identifier.of("auto_repair"), (world, level, context, user, pos) -> {
            if (context.stack().isDamaged() && random.nextInt(100) == 0) {
                context.stack().damage(-1, (LivingEntity) user, context.slot());
                LOGGER.info(context.slot().asString());
            }
        });
    }

}