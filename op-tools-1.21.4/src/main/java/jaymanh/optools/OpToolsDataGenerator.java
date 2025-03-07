package jaymanh.optools;

import jaymanh.optools.TagGenerator.OpToolsModBlockTagProvider;
import jaymanh.optools.TagGenerator.OpToolsModEnchantTagProvider;
import jaymanh.optools.TagGenerator.OpToolsModItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OpToolsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(OpToolsModItemTagProvider::new);
		pack.addProvider(OpToolsModBlockTagProvider::new);
		pack.addProvider(OpToolsModEnchantTagProvider::new);
	}
}
