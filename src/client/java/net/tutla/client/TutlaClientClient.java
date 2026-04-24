package net.tutla.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.network.chat.Component;
import net.tutla.client.module.LeaveThisGoBack;
import org.lwjgl.glfw.GLFW;

public class TutlaClientClient implements ClientModInitializer {
    public static KeyMapping leaveKey;

    @Override
	public void onInitializeClient() {
        leaveKey = KeyMappingHelper.registerKeyMapping(
                new KeyMapping(
                        "key.tutlaclient.leaveKey", // The translation key for the key mapping.
                        InputConstants.Type.KEYSYM, // // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
                        GLFW.GLFW_KEY_P, // The GLFW keycode of the key.
                        KeyMapping.Category.MISC // The category of the mapping.
                )
        );



        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Minecraft mc = Minecraft.getInstance();
            while (leaveKey.consumeClick()) {
                if (mc.getCurrentServer() != null && mc.screen != null) {
                    mc.disconnect(new DisconnectedScreen(mc.screen, Component.literal("Left Server"), Component.literal("")), false);
                }
                if (mc.isSingleplayer()){
                    mc.disconnect(new DisconnectedScreen(mc.screen, Component.literal("Left World"), Component.literal("")), false);
                }
            }
            if (client.player != null){
                LeaveThisGoBack.main(mc);
            }
        });
	}
}