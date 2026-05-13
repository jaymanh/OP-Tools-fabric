package jaymanh.optools.Tools;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static jaymanh.optools.OpTools.MOD_ID;

public class TagKeys {
    public static class ItemKeys{
        public static final TagKey<Item> DIAMONDILLIUM_REPAIR_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID,"diamondillium_repair_item"));
        public static final TagKey<Item> DIAMONDIUM_REPAIR_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID,"diamondium_repair_item"));
    }
}