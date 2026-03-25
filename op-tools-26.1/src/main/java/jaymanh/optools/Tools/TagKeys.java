package jaymanh.optools.Tools;

import static jaymanh.optools.OpTools.MOD_ID;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagKeys {
    public static class ItemKeys{
        public static final TagKey<Item> DIAMONDILLIUM_REPAIR_ITEMS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID,"diamondillium_repair_item"));
        public static final TagKey<Item> DIAMONDIUM_REPAIR_ITEMS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID,"diamondium_repair_item"));
    }
}