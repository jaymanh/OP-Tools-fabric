package jaymanh.optools.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> AUTO_REPAIR = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "auto_repair"));
    public static final RegistryKey<Enchantment> AUTO_REPLANT = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "auto_replant"));
    public static final RegistryKey<Enchantment> ELEMENTAL_EARTH = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "elemental_earth"));
    public static final RegistryKey<Enchantment> ELEMENTAL_FIRE = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "elemental_fire"));
    public static final RegistryKey<Enchantment> ELEMENTAL_LIGHTNING = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "elemental_lightning"));
    public static final RegistryKey<Enchantment> ELEMENTAL_WATER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "elemental_water"));
    public static final RegistryKey<Enchantment> TREE_BREAKER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "tree_breaker"));

    public static void initialise(){

    }
}
