package jaymanh.optools.Enchantments;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class InventoryHelper {

    public static int findItemSlot(Player player, ItemStack itemStack) {
        Inventory inventory = player.getInventory();

        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack slotStack = inventory.getItem(i);

            if (ItemStack.isSameItem(slotStack, itemStack)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean hasItemInInventory(Player player, ItemStack itemStack) {
        return findItemSlot(player, itemStack) != -1;
    }

    public static void removeItemInInventory(Player player, int itemSlot){
        player.getInventory().getItem(itemSlot).shrink(1);
    }
}
