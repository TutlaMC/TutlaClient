package net.tutla.client.module;

import net.tutla.client.Module;
import net.tutla.client.config.ConfigType;

public class NoPumpkinHead extends Module {
    public NoPumpkinHead() {
        super("NoPumpkinHead", "No more annoying pumpkin overlays!");
        setConfig("nopumpkinhead", ConfigType.BOOLEAN);
    }

}
