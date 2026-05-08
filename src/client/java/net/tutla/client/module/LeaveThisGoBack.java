package net.tutla.client.module;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.tutla.client.Module;
import net.tutla.client.TutlaUtil;
import net.tutla.client.config.ConfigType;

public class LeaveThisGoBack extends Module {
    private static int lastSlot = -1;
    private static final boolean[] prevState = new boolean[9];
    private static int previousSelectedSlot = -1;

    public LeaveThisGoBack() {
        super("LeaveThis, GoBack!", "Double click the same slot to go back to the previous slot");
        setConfig("leavethisgoback", ConfigType.BOOLEAN);
    }

    public static void main(Minecraft client){
        if (!TutlaUtil.isModuleEnabled(LeaveThisGoBack.class)) return;
        for (int i = 0; i < 9; i++) {
            int key = client.options.keyHotbarSlots[i].getDefaultKey().getValue();

            boolean down = InputConstants.isKeyDown(
                    client.getWindow(),
                    key
            );

            if (down && !prevState[i]) {
                if (previousSelectedSlot == -1) {
                    previousSelectedSlot = client.player.getInventory().getSelectedSlot();
                }

                if (i == previousSelectedSlot) {
                    if (lastSlot != -1) {
                        client.player.getInventory().setSelectedSlot(lastSlot);
                        previousSelectedSlot = lastSlot;
                    }

                } else {

                    lastSlot = previousSelectedSlot;
                    client.player.getInventory().setSelectedSlot(i);
                    previousSelectedSlot = i;
                }
            }

            prevState[i] = down;
        }
    }
}
