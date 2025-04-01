package jaymanh.optools.Enchantments;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

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
            RegistryEntry<Enchantment> auto_repair = optional.orElseThrow();

            int level = EnchantmentHelper.getLevel(auto_repair, itemStack);
            if (level > 0) {
                int chance = Math.max(level / 2, 1);
                chance = Math.min(chance, 100);
                if(itemStack.isDamaged() && random.nextInt(100 / chance) == 0) {
                    Consumer<Item> repairConsumer = item -> {

                    };
                    itemStack.damage(-1 * level, world, (ServerPlayerEntity) player, repairConsumer);
                }
            }
        }
    }

    public static void initialise() {
        ServerTickEvents.END_WORLD_TICK.register(new AutoRepairEnchantment());
    }
}