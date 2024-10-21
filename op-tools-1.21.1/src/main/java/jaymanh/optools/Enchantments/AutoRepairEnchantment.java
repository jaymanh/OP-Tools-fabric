package jaymanh.optools.Enchantments;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.Random;

import static jaymanh.optools.OpTools.LOGGER;
import static jaymanh.optools.OpTools.MOD_ID;

public class AutoRepairEnchantment implements ServerTickEvents.EndWorldTick {
    private static final Random random = new Random();
    public static final RegistryKey<Enchantment> AUTO_REPAIR = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "auto_repair"));

    @Override
    public void onEndTick(ServerWorld world) {
        world.getPlayers().forEach((player) -> CheckInventory(player,world));
    }

    private static void CheckInventory(PlayerEntity player, ServerWorld world){
        for (int i = 0; i < player.getInventory().size(); i++) {

            ItemStack itemStack = player.getInventory().getStack(i);
            DynamicRegistryManager drm = world.getRegistryManager();
            Registry<Enchantment> reg = drm.get(RegistryKeys.ENCHANTMENT);
            Optional<RegistryEntry<Enchantment>> optional = Optional.ofNullable(reg.getEntry(reg.get(AUTO_REPAIR)));
            // you can also use an Identifier, or an Enchantment in which case the returned RegistryEntry is not wrapped in an Optional

            RegistryEntry<Enchantment> auto_repair = optional.orElseThrow();
            if (EnchantmentHelper.getLevel(auto_repair, itemStack) > 0) {
                //LOGGER.info("Found item with enchantment in slot: " + i);
                if(itemStack.isDamaged() && random.nextInt(100) == 0) {
                    itemStack.damage(-1, (LivingEntity) player, );
                }
            }
        }
    }

    public static void initialise() {
        ServerTickEvents.END_WORLD_TICK.register(new AutoRepairEnchantment());
    }



/*
    private static final Random random = new Random();

    public static void initialise() {
        OpTools.register(Identifier.of("auto_repair"), (world, level, context, user, pos) -> {
            if (context.stack().isDamaged() && random.nextInt(100) == 0) {
                context.stack().damage(-1, (LivingEntity) user, context.slot());
                LOGGER.info(context.slot().asString()); //Slot "any" means only "active" slots mainhand, offhand, armor ect
            }
        });
    }
 */
}