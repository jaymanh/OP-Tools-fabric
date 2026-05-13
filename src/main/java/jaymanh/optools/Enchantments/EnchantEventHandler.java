package jaymanh.optools.Enchantments;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;

import java.util.ArrayList;
import java.util.List;

public class EnchantEventHandler implements ServerTickEvents.EndWorldTick {

    public static void initialise() {
        ServerTickEvents.END_WORLD_TICK.register(new EnchantEventHandler());
    }

    @Override
    public void onEndTick(ServerWorld serverWorld) {
        List<AutoReplantEnchantment.ReplantTask> tasksToProcess = new ArrayList<>();
        for (AutoReplantEnchantment.ReplantTask task : AutoReplantEnchantment.getReplantTasks()) {
            if (task.world() == serverWorld) {
                tasksToProcess.add(task);
            }
        }
        for (AutoReplantEnchantment.ReplantTask task : tasksToProcess) {
            serverWorld.setBlockState(task.pos(), task.block().getDefaultState());
            AutoReplantEnchantment.getReplantTasks().remove(task);
        }
    }
}