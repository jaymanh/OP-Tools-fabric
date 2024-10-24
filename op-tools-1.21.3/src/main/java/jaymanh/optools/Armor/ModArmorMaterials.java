package jaymanh.optools.Armor;

import jaymanh.optools.Items.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.equipment.trim.ArmorTrim;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModArmorMaterials {
    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<EquipmentType, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(MOD_ID, id), "", dyeable)
        );
        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(MOD_ID, id), material);
        return RegistryEntry.of(material);
    }

    public static final int DIAMONDILLIUM_DURABILITY_MULTIPLIER = 256;
    public static final int DIAMONDIUM_DURABILITY_MULTIPLIER = 512;

    public static final RegistryEntry<ArmorMaterial> DIAMONDILLIUM = registerMaterial("diamondillium",
            Map.of(
                    EquipmentType.HELMET, 5,
                    EquipmentType.CHESTPLATE, 9,
                    EquipmentType.LEGGINGS, 7,
                    EquipmentType.BOOTS, 4
            ),
            24,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(ModItems.DIAMONDILLIUM_INGOT),
            4.0F,
            1.0F,
            false);

    public static final RegistryEntry<ArmorMaterial> DIAMONDIUM = registerMaterial("diamondium",
            Map.of(
                    EquipmentType.HELMET, 7,
                    EquipmentType.CHESTPLATE, 15,
                    EquipmentType.LEGGINGS, 11,
                    EquipmentType.BOOTS, 6
            ),
            24,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(ModItems.DIAMONDIUM_INGOT),
            6.0F,
            1.5F,
            false);


    public static void initialize(){

    }
}
