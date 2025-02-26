package jaymanh.optools.Enchantments;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

public class InventoryHelper {

    public static int findItemSlot(PlayerEntity player, ItemStack itemStack) {
        PlayerInventory inventory = player.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            ItemStack slotStack = inventory.getStack(i);

            if (ItemStack.areItemsEqual(slotStack, itemStack)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean hasItemInInventory(PlayerEntity player, ItemStack itemStack) {
        return findItemSlot(player, itemStack) != -1;
    }

    public static void removeItemInInventory(PlayerEntity player, int itemSlot){
        player.getInventory().getStack(itemSlot).decrement(1);
    }
}
