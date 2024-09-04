package jaymanh.optools.Tools;

import jaymanh.optools.OpTools;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.SwordItem;
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
         Identifier ItemID = new Identifier(OpTools.MOD_ID, id);
        return Registry.register(Registries.ITEM, ItemID, item);
    }

    public static final RegistryKey<ItemGroup> OP_TOOLS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(OpTools.MOD_ID,"op-tools"));
    public static final ItemGroup OP_TOOLS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModTools.DIAMONDIUM_SWORD))
            .displayName(Text.translatable("itemGroup.op-tools"))
            .build();


    public static final Item DIAMONDIUM_SWORD = register(
            new SwordItem(DiamondiumToolsMaterial.INSTANCE, 12, 0.6f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()),
            "diamondium_sword"
        );


    public static void initialise(){
        Registry.register(Registries.ITEM_GROUP, OP_TOOLS_ITEM_GROUP_KEY, OP_TOOLS_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(OP_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModTools.DIAMONDIUM_SWORD);
        });
    }
}