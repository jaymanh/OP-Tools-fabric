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
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModTools {
    public static Item register(Item item, String id){
         Identifier ItemID = Identifier.of(OpTools.MOD_ID, id);
        return Registry.register(Registries.ITEM, ItemID, item);
    }

    public static final RegistryKey<ItemGroup> OP_TOOLS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(OpTools.MOD_ID,"op-tools"));
    public static final ItemGroup OP_TOOLS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModTools.DIAMONDIUM_SWORD))
            .displayName(Text.translatable("itemGroup.op-tools"))
            .build();

    public static final Item DIAMONDIUM_SWORD = register(
            new SwordItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(DiamondiumToolsMaterial.INSTANCE,12,0.6f))),
            "diamondium_sword"
    );
    public static final Item DIAMONDIUM_PICKAXE = register(
            new PickaxeItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(DiamondiumToolsMaterial.INSTANCE,5,0.2f))),
            "diamondium_pickaxe"
    );
    public static final Item DIAMONDIUM_AXE = register(
            new AxeItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()
                    .attributeModifiers(AxeItem.createAttributeModifiers(DiamondiumToolsMaterial.INSTANCE,15,0.4f))),
            "diamondium_axe"
    );
    public static final Item DIAMONDIUM_SHOVEL = register(
            new ShovelItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(DiamondiumToolsMaterial.INSTANCE,8,0.5f))),
            "diamondium_shovel"
    );
    public static final Item DIAMONDIUM_HOE = register(
            new HoeItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()
                    .attributeModifiers(HoeItem.createAttributeModifiers(DiamondiumToolsMaterial.INSTANCE,7,1f))),
            "diamondium_hoe"
    );

    public static final Item DIAMONDILLIUM_SWORD = register(
            new SwordItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(DiamondilliumToolsMaterial.INSTANCE,10,0.5f))),
            "diamondillium_sword"
    );
    public static final Item DIAMONDILLIUM_PICKAXE = register(
            new PickaxeItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(DiamondilliumToolsMaterial.INSTANCE,5,0.2f))),
            "diamondillium_pickaxe"
    );
    public static final Item DIAMONDILLIUM_AXE = register(
            new AxeItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()
                    .attributeModifiers(AxeItem.createAttributeModifiers(DiamondilliumToolsMaterial.INSTANCE,15,0.4f))),
            "diamondillium_axe"
    );
    public static final Item DIAMONDILLIUM_SHOVEL = register(
            new ShovelItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(DiamondilliumToolsMaterial.INSTANCE,8,0.5f))),
            "diamondillium_shovel"
    );
    public static final Item DIAMONDILLIUM_HOE = register(
            new PickaxeItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()
                    .attributeModifiers(HoeItem.createAttributeModifiers(DiamondilliumToolsMaterial.INSTANCE,6,1f))),
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
