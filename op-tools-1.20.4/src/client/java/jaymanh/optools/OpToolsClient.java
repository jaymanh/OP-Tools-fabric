package jaymanh.optools;

import jaymanh.optools.GUI.Screen.ModScreenHandlers;
import jaymanh.optools.GUI.Screen.RefineryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class OpToolsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(){
		HandledScreens.register(ModScreenHandlers.REFINERY_SCREEN_HANDLER, RefineryScreen::new);
	}
}
