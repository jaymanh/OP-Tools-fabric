package jaymanh.optools.Enchantments;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

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

    // Usage Example
    public static void exampleUsage(PlayerEntity player) {
        ItemStack itemToCheck = new ItemStack(Items.DIAMOND);  // For example, a Diamond item
        int slot = findItemSlot(player, itemToCheck);

        if (slot != -1) {
            System.out.println("Found the item in slot: " + slot);
        } else {
            System.out.println("Item not found in the inventory.");
        }
    }
}
