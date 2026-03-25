package jaymanh.optools;

import jaymanh.optools.GUI.Screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class OpToolsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(){
		MenuScreens.register(ModScreenHandlers.REFINERY_SCREEN_HANDLER, RefineryScreen::new);
	}
}
