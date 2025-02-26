package jaymanh.optools.Armor;

import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

import static jaymanh.optools.OpTools.MOD_ID;

public class CustomArmorModels implements EquipmentModels {
    static Identifier DIAMONDILLIUM = Identifier.of(MOD_ID,"diamondillium");
    static Identifier DIAMONDIUM = Identifier.of(MOD_ID,"diamondium");


    public static void accept(BiConsumer<Identifier, EquipmentModel> equipmentModelBiConsumer) {
        equipmentModelBiConsumer.accept(DIAMONDILLIUM, makeDefault("diamondillium"));
        equipmentModelBiConsumer.accept(DIAMONDIUM, makeDefault("diamondium"));
    }

    private static EquipmentModel makeDefault(String path) {
        return EquipmentModel.builder().addHumanoidLayers( Identifier.of(MOD_ID,path)).build();
    }
}