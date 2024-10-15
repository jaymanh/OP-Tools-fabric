package jaymanh.optools.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> AUTO_REPAIR = of("auto_repair");

    private static RegistryKey<Enchantment> of(String name){
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, name));
    }

    public static void initialize(){

    }
}
