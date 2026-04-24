package net.tutla.client.module;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;

public class LeaveThisGoBack {
    private static int lastSlot = -1;
    private static final boolean[] prevState = new boolean[9];
    private static int previousSelectedSlot = -1;

    public static void main(Minecraft client){

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
