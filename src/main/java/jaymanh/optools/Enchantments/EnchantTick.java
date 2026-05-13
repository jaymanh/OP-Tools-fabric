package jaymanh.optools.Enchantments;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TypeFilter;

import static jaymanh.optools.OpTools.LOGGER;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class EnchantTick implements ServerTickEvents.EndWorldTick {
    public static void initialise() {
        ServerTickEvents.END_WORLD_TICK.register(new EnchantTick());
    }

    @Override
    public void onEndTick(ServerWorld world) {
        List<? extends LivingEntity> entitiesList = world.getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class), EntityPredicates.VALID_ENTITY);
        for (Entity entity : entitiesList) {
            Set<String> tags = new HashSet<>(entity.getCommandTags());
            for (String cTag : tags) {
                if (Objects.equals(cTag, "Gravity")) {
                    for (String cTags : tags) {
                        if (cTags.startsWith("Num")) {
                            String numPart = cTags.substring(3);
                            int currentNum;
                            try {
                                currentNum = Integer.parseInt(numPart);
                            } catch (NumberFormatException e) {
                                LOGGER.error("Invalid number format for tag: " + cTags);
                                continue;
                            }

                            if (currentNum == 100) {
                                entity.setNoGravity(false);
                                entity.removeCommandTag("Num" + numPart);
                                entity.removeCommandTag("Gravity");
                            } else {
                                entity.removeCommandTag("Num" + numPart);
                                int nextNum = currentNum + 1;
                                entity.addCommandTag("Num" + nextNum);
                            }
                        }
                    }
                }
            }
        }
    }
}