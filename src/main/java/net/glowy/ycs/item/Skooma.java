package net.glowy.ycs.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.glowy.ycs.YCS;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Skooma {

    private static final Item SKOOMA = Registry.register(Registry.ITEM, new Identifier(YCS.MOD_ID, "skooma"),
            new Item(new FabricItemSettings().group(ItemGroup.BREWING)));

    public static void initialize(){
        YCS.LOGGER.debug("Loading Skooma!");
    }
}
