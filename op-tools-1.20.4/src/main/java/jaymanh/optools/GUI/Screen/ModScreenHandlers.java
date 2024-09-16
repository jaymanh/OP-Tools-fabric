package jaymanh.optools.GUI.Screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModScreenHandlers {
    public static final ScreenHandlerType<RefineryScreenHandler> REFINERY_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(MOD_ID, "refinery"),
            new ExtendedScreenHandlerType<>(RefineryScreenHandler::new));

    public static void registerScreenHandlers(){

    }
}
