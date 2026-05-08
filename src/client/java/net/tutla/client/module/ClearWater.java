package net.tutla.client.module;

import net.tutla.client.Module;
import net.tutla.client.config.ConfigType;

public class ClearWater extends Module {
    public ClearWater() {
        super("Clear Water", "See through the water clearly");
        setConfig("clearwater", ConfigType.BOOLEAN);
    }
}
