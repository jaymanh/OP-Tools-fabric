package jaymanh.optools.Enchantments;

import static jaymanh.optools.OpTools.MOD_ID;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> AUTO_REPAIR = ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(MOD_ID, "auto_repair"));
    public static final ResourceKey<Enchantment> AUTO_REPLANT = ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(MOD_ID, "auto_replant"));
    public static final ResourceKey<Enchantment> ELEMENTAL_EARTH = ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(MOD_ID, "elemental_earth"));
    public static final ResourceKey<Enchantment> ELEMENTAL_FIRE = ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(MOD_ID, "elemental_fire"));
    public static final ResourceKey<Enchantment> ELEMENTAL_LIGHTNING = ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(MOD_ID, "elemental_lightning"));
    public static final ResourceKey<Enchantment> ELEMENTAL_WATER = ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(MOD_ID, "elemental_water"));
    public static final ResourceKey<Enchantment> TREE_BREAKER = ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(MOD_ID, "tree_breaker"));

    public static void initialise(){

    }
}
