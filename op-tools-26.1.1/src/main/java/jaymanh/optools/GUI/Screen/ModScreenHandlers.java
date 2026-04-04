package jaymanh.optools.GUI.Screen;

import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.MenuType;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModScreenHandlers {
    public static final MenuType<RefineryScreenHandler> REFINERY_SCREEN_HANDLER =
            Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(MOD_ID, "refinery"),
            new ExtendedMenuType<>(RefineryScreenHandler::new, BlockPosPayload.PACKET_CODEC));

    public static void registerScreenHandlers(){

    }
}
