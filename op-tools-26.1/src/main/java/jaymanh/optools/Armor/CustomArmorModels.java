package jaymanh.optools.Armor;

import java.util.function.BiConsumer;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import static jaymanh.optools.OpTools.MOD_ID;

public class CustomArmorModels implements EquipmentAssets {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> DIAMONDILLIUM = ResourceKey.create(REGISTRY_KEY,Identifier.fromNamespaceAndPath(MOD_ID, "diamondillium"));
    public static final ResourceKey<EquipmentAsset>  DIAMONDIUM = ResourceKey.create(REGISTRY_KEY,Identifier.fromNamespaceAndPath(MOD_ID, "diamondium"));

}