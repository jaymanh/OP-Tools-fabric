package jaymanh.optools.Enchantments;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.registry.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

import static java.lang.Math.max;
import static jaymanh.optools.OpTools.MOD_ID;

public class AutoRepairEnchantment implements ServerTickEvents.EndWorldTick {
    private static final Random random = new Random();
    public static final ResourceKey<Enchantment> AUTO_REPAIR = ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(MOD_ID, "auto_repair"));

    @Override
    public void onEndTick(ServerLevel world) {
        world.players().forEach((player) -> CheckInventory(player,world));
    }

    private static void CheckInventory(Player player, ServerLevel world){
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {

            ItemStack itemStack = player.getInventory().getItem(i);
            RegistryAccess drm = world.registryAccess();
            Registry<Enchantment> reg = drm.lookupOrThrow(Registries.ENCHANTMENT);
            Optional<Holder<Enchantment>> optional = Optional.ofNullable(reg.wrapAsHolder(reg.getValue(AUTO_REPAIR)));
            Holder<Enchantment> auto_repair = optional.orElseThrow();
            int level = EnchantmentHelper.getItemEnchantmentLevel(auto_repair, itemStack);
            if (level > 0) {
                int chance = Math.max(level / 2, 1);
                chance = Math.min(chance, 100);
                if(itemStack.isDamaged() && random.nextInt(100 / chance) == 0) {
                    Consumer<Item> repairConsumer = item -> {

                    };
                    itemStack.hurtAndBreak(-1 * level, world, (ServerPlayer) player, repairConsumer);
                }
            }
        }
    }

    public static void initialise() {
        ServerTickEvents.END_WORLD_TICK.register(new AutoRepairEnchantment());
    }
}