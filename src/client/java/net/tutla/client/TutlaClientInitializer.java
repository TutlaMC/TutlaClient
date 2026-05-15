package net.tutla.client;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.itzispyder.improperui.ImproperUIAPI;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.tutla.client.config.Config;
import net.tutla.client.module.*;
import net.tutla.client.ui.MenuCallback;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TutlaClientInitializer implements ClientModInitializer {
    public static KeyMapping leaveKey;
    public static KeyMapping menuKey;
    private static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("tutlaclient", "keys"));

    private static final Map<Class<? extends Module>, Module> modules = new HashMap<>();

    @Override
	public void onInitializeClient() {
        menuKey = KeyMappingHelper.registerKeyMapping(
                new KeyMapping(
                        "key.tutlaclient.menuKey", // The translation key for the key mapping.
                        InputConstants.Type.KEYSYM, // // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
                        GLFW.GLFW_KEY_K, // The GLFW keycode of the key.
                        CATEGORY // The category of the mapping.
                )
        );
        leaveKey = KeyMappingHelper.registerKeyMapping(
                new KeyMapping(
                        "key.tutlaclient.leaveKey", // The translation key for the key mapping.
                        InputConstants.Type.KEYSYM, // // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
                        GLFW.GLFW_KEY_P, // The GLFW keycode of the key.
                        CATEGORY // The category of the mapping.
                )
        );

        initAllModules();
        Config.loadAll();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Minecraft mc = Minecraft.getInstance();
            while (leaveKey.consumeClick()) {
                if (mc.getCurrentServer() != null) {
                    mc.disconnect(new DisconnectedScreen(mc.screen, Component.literal("Left World"), Component.literal("")), false);
                }
            }
            while (menuKey.consumeClick()){
                openMenu();
            }
            if (client.player != null){
                LeaveThisGoBack.main(mc);
            }
        });
	}

    public static void openMenu() {
        ImproperUIAPI.parseAndRunFile("tutlaclient", "menu.ui", new MenuCallback());
        ImproperUIAPI.collectContext();
    }

    public static Map<Class<? extends Module>, Module> getModules(){
        return modules;
    }

    public void initAllModules(){
        modules.put(LeaveThisGoBack.class, new LeaveThisGoBack());
        modules.put(NoHurtCam.class, new NoHurtCam());
        modules.put(NoViewBob.class, new NoViewBob());
        modules.put(ClearWater.class, new ClearWater());
        modules.put(NoPortalOverlay.class, new NoPortalOverlay());
        modules.put(NoPumpkinHead.class, new NoPumpkinHead());
        modules.put(NoFire.class, new NoFire());
        modules.put(FullBright.class, new FullBright());
    }
}