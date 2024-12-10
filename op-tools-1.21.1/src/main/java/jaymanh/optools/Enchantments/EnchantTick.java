package jaymanh.optools.Enchantments;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TypeFilter;

import static jaymanh.optools.OpTools.LOGGER;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class EnchantTick implements ServerTickEvents.EndWorldTick{
    public static void initialise(){
        ServerTickEvents.END_WORLD_TICK.register(new EnchantTick());
    }
    @Override
    public void onEndTick(ServerWorld world) {
        List<? extends LivingEntity> entitiesList = world.getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class), EntityPredicates.VALID_ENTITY);
        for(Entity entity: entitiesList){
            Set<String> tag = entity.getCommandTags();
            for(String cTag : tag){
                if(Objects.equals(cTag, "Gravity")){
                    LOGGER.info("test");
                    Set<String> tags = entity.getCommandTags();
                    for(String cTags : tags){
                        if(cTags.startsWith("Num")){
                            int cur = (int)cTags.charAt(cTags.length() -1);
                            if(cur == 100){
                                entity.setNoGravity(false);
                                entity.removeCommandTag("Num100");
                                entity.removeCommandTag("Gravity");
                            }
                            else{
                                cur++;
                                entity.addCommandTag("Num" + cur);
                            }
                        }
                    }
                }
            }
        }
    }
}
