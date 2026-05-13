package jaymanh.optools.Armor;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

import static jaymanh.optools.OpTools.MOD_ID;

public class CustomArmorModels implements EquipmentAssetKeys {
    public static final RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    public static final RegistryKey<EquipmentAsset> DIAMONDILLIUM = RegistryKey.of(REGISTRY_KEY,Identifier.of(MOD_ID, "diamondillium"));
    public static final RegistryKey<EquipmentAsset>  DIAMONDIUM = RegistryKey.of(REGISTRY_KEY,Identifier.of(MOD_ID, "diamondium"));

}