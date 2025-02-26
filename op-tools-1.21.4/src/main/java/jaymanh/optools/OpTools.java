package jaymanh.optools;

import jaymanh.optools.Armor.ModArmorMaterials;
import jaymanh.optools.Armor.ModArmor;
import jaymanh.optools.Blocks.BlockEntitys.ModBlockEntitys;
import jaymanh.optools.Blocks.ModBlocks;
import jaymanh.optools.Enchantments.*;
import jaymanh.optools.Foods.ModFoodItems;
import jaymanh.optools.Fuels.ModFuels;
import jaymanh.optools.GUI.Screen.ModScreenHandlers;
import jaymanh.optools.Items.ModItems;
import jaymanh.optools.Tools.ModTools;
import jaymanh.optools.OreGen.ModOreGenerator;
import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.entity.Entity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class OpTools implements ModInitializer {
	public static final String MOD_ID = "op-tools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Map<Identifier, CodeRunner> registry = new HashMap<>();
	public static void register(Identifier hook, CodeRunner code) {
		registry.put(hook, code);
	}

	@FunctionalInterface
	public interface CodeRunner {
		void run(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos);
	}
	public static CodeRunner get(Identifier hook){
		return registry.get(hook);
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loading %s".formatted(MOD_ID));

		Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(MOD_ID, "run_code"), ModEnchantmentsRunCode.CODEC);

		ModArmorMaterials.initialize();

		ModTools.initialise();
		ModArmor.initialise();
		ModItems.initialise();
		ModBlocks.initialize();
		ModOreGenerator.initialise();
		ModBlockEntitys.initialise();
		ModScreenHandlers.registerScreenHandlers();
		ModFoodItems.initialise();
		ModFuels.initialize();
		TreeBreakerEnchantment.initialise();
		AutoRepairEnchantment.initialise();
		AutoReplantEnchantment.initialise();
		ElementalDamageEnchantments.initialise();
		EnchantTick.initialise();
	}
}