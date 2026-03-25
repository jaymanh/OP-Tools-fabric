package jaymanh.optools.Tools;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModTools {
    public static Item register(Item item, String id){
        return Registry.register(BuiltInRegistries.ITEM, key(id), item);
    }

    public static ResourceKey<Item> key(String id){
        Identifier ItemID = Identifier.fromNamespaceAndPath(MOD_ID, id);
        return ResourceKey.create(Registries.ITEM, ItemID);
    }

    public static final ResourceKey<CreativeModeTab> OP_TOOLS_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MOD_ID,"op-tools"));
    public static final CreativeModeTab OP_TOOLS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModTools.DIAMONDIUM_SWORD))
            .title(Component.translatable("itemGroup.op-tools"))
            .build();

    public static final Item DIAMONDIUM_SWORD = register(
            new Item(new Item.Properties().sword(ToolMaterials.DIAMONDIUM.getMaterial(),12,0.6f).rarity(Rarity.EPIC).fireResistant().setId(key("diamondium_sword"))),
            "diamondium_sword"
    );
    public static final Item DIAMONDIUM_PICKAXE = register(
            new Item(new Item.Properties().pickaxe(ToolMaterials.DIAMONDIUM.getMaterial(),5,0.2f).rarity(Rarity.EPIC).fireResistant().setId(key("diamondium_pickaxe"))),
            "diamondium_pickaxe"
    );
    public static final Item DIAMONDIUM_AXE = register(
            new Item(new Item.Properties().axe(ToolMaterials.DIAMONDIUM.getMaterial(),15,0.4f).rarity(Rarity.EPIC).fireResistant().setId(key("diamondium_axe"))),
            "diamondium_axe"
    );
    public static final Item DIAMONDIUM_SHOVEL = register(
            new Item(new Item.Properties().shovel(ToolMaterials.DIAMONDIUM.getMaterial(),8,0.5f).rarity(Rarity.EPIC).fireResistant().setId(key("diamondium_shovel"))),
            "diamondium_shovel"
    );
    public static final Item DIAMONDIUM_HOE = register(
            new HoeItem(ToolMaterials.DIAMONDIUM.getMaterial(),7,1f, new Item.Properties().rarity(Rarity.EPIC).fireResistant().setId(key("diamondium_hoe"))),
            "diamondium_hoe"
    );

    public static final Item DIAMONDILLIUM_SWORD = register(
            new Item(new Item.Properties().sword(ToolMaterials.DIAMONDILLIUM.getMaterial(),10,0.5f).rarity(Rarity.RARE).fireResistant().setId(key("diamondillium_sword"))),
            "diamondillium_sword"
    );
    public static final Item DIAMONDILLIUM_PICKAXE = register(
            new Item(new Item.Properties().pickaxe(ToolMaterials.DIAMONDILLIUM.getMaterial(),5,0.2f).rarity(Rarity.RARE).fireResistant().setId(key("diamondillium_pickaxe"))),
            "diamondillium_pickaxe"
    );
    public static final Item DIAMONDILLIUM_AXE = register(
            new Item(new Item.Properties().axe(ToolMaterials.DIAMONDILLIUM.getMaterial(),15,0.4f).rarity(Rarity.RARE).fireResistant().setId(key("diamondillium_axe"))),
            "diamondillium_axe"
    );
    public static final Item DIAMONDILLIUM_SHOVEL = register(
            new Item(new Item.Properties().shovel(ToolMaterials.DIAMONDILLIUM.getMaterial(),8,0.5f).rarity(Rarity.RARE).fireResistant().setId(key("diamondillium_shovel"))),
            "diamondillium_shovel"
    );

    public static final Item DIAMONDILLIUM_HOE = register(
            new HoeItem(ToolMaterials.DIAMONDILLIUM.getMaterial(),6,1f, new Item.Properties().rarity(Rarity.RARE).fireResistant().setId(key("diamondillium_hoe"))),
            "diamondillium_hoe"
    );


    public static void initialise(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, OP_TOOLS_ITEM_GROUP_KEY, OP_TOOLS_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.accept(ModTools.DIAMONDILLIUM_SWORD);
            itemGroup.accept(ModTools.DIAMONDILLIUM_PICKAXE);
            itemGroup.accept(ModTools.DIAMONDILLIUM_AXE);
            itemGroup.accept(ModTools.DIAMONDILLIUM_SHOVEL);
            itemGroup.accept(ModTools.DIAMONDILLIUM_HOE);

            itemGroup.accept(ModTools.DIAMONDIUM_SWORD);
            itemGroup.accept(ModTools.DIAMONDIUM_PICKAXE);
            itemGroup.accept(ModTools.DIAMONDIUM_AXE);
            itemGroup.accept(ModTools.DIAMONDIUM_SHOVEL);
            itemGroup.accept(ModTools.DIAMONDIUM_HOE);
        });
    }
}