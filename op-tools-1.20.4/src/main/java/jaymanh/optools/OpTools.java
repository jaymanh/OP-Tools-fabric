package jaymanh.optools;

import jaymanh.optools.Armor.ModArmor;
import jaymanh.optools.Blocks.BlockEntitys.ModBlockEntitys;
import jaymanh.optools.Blocks.ModBlocks;
import jaymanh.optools.Items.ModItems;
import jaymanh.optools.Tools.ModTools;
import jaymanh.optools.OreGen.ModOreGenerator;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpTools implements ModInitializer {
	public static final String MOD_ID = "op-tools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loading %s".formatted(MOD_ID));

		ModTools.initialise();
		ModArmor.initialise();
		ModItems.initialise();
		ModBlocks.initialize();
		ModOreGenerator.initialise();
		ModBlockEntitys.initialise();

	}
}