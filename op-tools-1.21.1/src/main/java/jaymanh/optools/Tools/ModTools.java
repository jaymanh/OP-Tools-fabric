package jaymanh.optools.Tools;

import jaymanh.optools.OpTools;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


import static net.minecraft.item.Items.register;

public class ModTools {
    //DIAMONDIUM
    //DIAMONDILLIUM

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
            new SwordItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_sword"
    );
    public static final Item DIAMONDIUM_PICKAXE = register(
            new PickaxeItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_pickaxe"
    );
    public static final Item DIAMONDIUM_AXE = register(
            new AxeItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_axe"
    );
    public static final Item DIAMONDIUM_SHOVEL = register(
            new ShovelItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_shovel"
    );
    public static final Item DIAMONDIUM_HOE = register(
            new HoeItem(DiamondiumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_hoe"
    );

    public static final Item DIAMONDILLIUM_SWORD = register(
            new SwordItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_sword"
    );
    public static final Item DIAMONDILLIUM_PICKAXE = register(
            new PickaxeItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_pickaxe"
    );
    public static final Item DIAMONDILLIUM_AXE = register(
            new AxeItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_axe"
    );
    public static final Item DIAMONDILLIUM_SHOVEL = register(
            new ShovelItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_shovel"
    );
    public static final Item DIAMONDILLIUM_HOE = register(
            new PickaxeItem(DiamondilliumToolsMaterial.INSTANCE, new Item.Settings().rarity(Rarity.RARE).fireproof()),
            "diamondillium_hoe"
    );


    public static void initialise(){
        Registry.register(Registries.ITEM_GROUP, OP_TOOLS_ITEM_GROUP_KEY, OP_TOOLS_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
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
