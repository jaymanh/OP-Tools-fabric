package jaymanh.optools.Enchantments;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.entity.EntityTypeTest;

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
    public void onEndTick(ServerLevel world) {
        List<? extends LivingEntity> entitiesList = world.getEntities(EntityTypeTest.forClass(LivingEntity.class), EntitySelector.ENTITY_STILL_ALIVE);
        for (Entity entity : entitiesList) {
            Set<String> tags = new HashSet<>(entity.getTags());
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
                                entity.removeTag("Num" + numPart);
                                entity.removeTag("Gravity");
                            } else {
                                entity.removeTag("Num" + numPart);
                                int nextNum = currentNum + 1;
                                entity.addTag("Num" + nextNum);
                            }
                        }
                    }
                }
            }
        }
    }
}