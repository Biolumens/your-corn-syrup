package net.glowy.ycs.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.glowy.ycs.YCS;
import net.glowy.ycs.item.custom.SkoomaItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Skooma {

    private static final Item SKOOMA = Registry.register(Registry.ITEM, new Identifier(YCS.MOD_ID, "skooma"),
            new SkoomaItem(new FabricItemSettings().group(ItemGroup.BREWING).rarity(Rarity.EPIC)));

    public static void initialize(){
        YCS.LOGGER.debug("Loading Skooma!");
    }
}
