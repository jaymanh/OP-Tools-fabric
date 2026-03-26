package jaymanh.optools.Foods;

import jaymanh.optools.OpTools;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static jaymanh.optools.Tools.ModTools.*;

public class ModFoodItems {
    public static final Item SUPER_MEAT = register(new Item(new Item.Properties().rarity(Rarity.RARE).food(new FoodProperties.Builder()
                    .nutrition(20)
                    .saturationModifier(20)
                    .build())
                    .setId(key("super_meat"))),
            "super_meat");

    public static void initialise(){
        CreativeModeTabEvents.modifyOutputEvent(OP_TOOLS_ITEM_GROUP_KEY).register((event) -> {
            event.accept(SUPER_MEAT);
        });
    }
}
