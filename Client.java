package com.plasmafox256.plasmacraft;

import com.plasmafox256.plasmacraft.blocks.storage.bronze_box.BronzeBoxScreen;
import com.plasmafox256.plasmacraft.blocks.storage.stainless_steel_box.StainlessSteelBoxScreen;
import com.plasmafox256.plasmacraft.blocks.storage.steel_box.SteelBoxScreen;
import com.plasmafox256.plasmacraft.blocks.storage.stone_box.StoneBoxScreen;
import com.plasmafox256.plasmacraft.blocks.storage.wooden_box.WoodenBoxScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Main.WOODEN_BOX_SCREEN_HANDLER, WoodenBoxScreen::new);
        ScreenRegistry.register(Main.STONE_BOX_SCREEN_HANDLER, StoneBoxScreen::new);
        ScreenRegistry.register(Main.BRONZE_BOX_SCREEN_HANDLER, BronzeBoxScreen::new);
        ScreenRegistry.register(Main.STEEL_BOX_SCREEN_HANDLER, SteelBoxScreen::new);
        ScreenRegistry.register(Main.STAINLESS_STEEL_BOX_SCREEN_HANDLER, StainlessSteelBoxScreen::new);
    }
}
