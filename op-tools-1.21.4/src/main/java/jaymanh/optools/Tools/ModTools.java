package jaymanh.optools.Tools;

import jaymanh.optools.OpTools;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModTools {
    public static Item register(Item item, String id){
        return Registry.register(Registries.ITEM, key(id), item);
    }

    public static RegistryKey<Item> key(String id){
        Identifier ItemID = Identifier.of(MOD_ID, id);
        return RegistryKey.of(RegistryKeys.ITEM, ItemID);
    }

    public static final RegistryKey<ItemGroup> OP_TOOLS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID,"op-tools"));
    public static final ItemGroup OP_TOOLS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModTools.DIAMONDIUM_SWORD))
            .displayName(Text.translatable("itemGroup.op-tools"))
            .build();

    public static final Item DIAMONDIUM_SWORD = register(
            new SwordItem(ToolMaterials.DIAMONDIUM.getMaterial(),12,0.6f, new Item.Settings().rarity(Rarity.EPIC).fireproof().registryKey(key("diamondium_sword"))),
            "diamondium_sword"
    );
    public static final Item DIAMONDIUM_PICKAXE = register(
            new PickaxeItem(ToolMaterials.DIAMONDIUM.getMaterial(),5,0.2f, new Item.Settings().rarity(Rarity.EPIC).fireproof().registryKey(key("diamondium_pickaxe"))),
            "diamondium_pickaxe"
    );
    public static final Item DIAMONDIUM_AXE = register(
            new AxeItem(ToolMaterials.DIAMONDIUM.getMaterial(),15,0.4f, new Item.Settings().rarity(Rarity.EPIC).fireproof().registryKey(key("diamondium_axe"))),
            "diamondium_axe"
    );
    public static final Item DIAMONDIUM_SHOVEL = register(
            new ShovelItem(ToolMaterials.DIAMONDIUM.getMaterial(),8,0.5f, new Item.Settings().rarity(Rarity.EPIC).fireproof().registryKey(key("diamondium_shovel"))),
            "diamondium_shovel"
    );
    public static final Item DIAMONDIUM_HOE = register(
            new HoeItem(ToolMaterials.DIAMONDIUM.getMaterial(),7,1f, new Item.Settings().rarity(Rarity.EPIC).fireproof().registryKey(key("diamondium_hoe"))),
            "diamondium_hoe"
    );

    public static final Item DIAMONDILLIUM_SWORD = register(
            new SwordItem(ToolMaterials.DIAMONDILLIUM.getMaterial(),10,0.5f, new Item.Settings().rarity(Rarity.RARE).fireproof().registryKey(key("diamondillium_sword"))),
            "diamondillium_sword"
    );
    public static final Item DIAMONDILLIUM_PICKAXE = register(
            new PickaxeItem(ToolMaterials.DIAMONDILLIUM.getMaterial(),5,0.2f, new Item.Settings().rarity(Rarity.RARE).fireproof().registryKey(key("diamondillium_pickaxe"))),
            "diamondillium_pickaxe"
    );
    public static final Item DIAMONDILLIUM_AXE = register(
            new AxeItem(ToolMaterials.DIAMONDILLIUM.getMaterial(),15,0.4f, new Item.Settings().rarity(Rarity.RARE).fireproof().registryKey(key("diamondillium_axe"))),
            "diamondillium_axe"
    );
    public static final Item DIAMONDILLIUM_SHOVEL = register(
            new ShovelItem(ToolMaterials.DIAMONDILLIUM.getMaterial(),8,0.5f, new Item.Settings().rarity(Rarity.RARE).fireproof().registryKey(key("diamondillium_shovel"))),
            "diamondillium_shovel"
    );
    public static final Item DIAMONDILLIUM_HOE = register(
            new PickaxeItem(ToolMaterials.DIAMONDILLIUM.getMaterial(),6,1f, new Item.Settings().rarity(Rarity.RARE).fireproof().registryKey(key("diamondillium_hoe"))),
            "diamondillium_hoe"
    );


    public static void initialise(){
        Registry.register(Registries.ITEM_GROUP, OP_TOOLS_ITEM_GROUP_KEY, OP_TOOLS_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModTools.DIAMONDILLIUM_SWORD);
            itemGroup.add(ModTools.DIAMONDILLIUM_PICKAXE);
            itemGroup.add(ModTools.DIAMONDILLIUM_AXE);
            itemGroup.add(ModTools.DIAMONDILLIUM_SHOVEL);
            itemGroup.add(ModTools.DIAMONDILLIUM_HOE);

            itemGroup.add(ModTools.DIAMONDIUM_SWORD);
            itemGroup.add(ModTools.DIAMONDIUM_PICKAXE);
            itemGroup.add(ModTools.DIAMONDIUM_AXE);
            itemGroup.add(ModTools.DIAMONDIUM_SHOVEL);
            itemGroup.add(ModTools.DIAMONDIUM_HOE);
        });
    }
}