package net.tutla.client.module;

import net.tutla.client.Module;
import net.tutla.client.config.ConfigType;

public class NoFire extends Module {
    public NoFire() {
        super("NoFire", "Disables the fire overlay");
        setConfig("nofire", ConfigType.BOOLEAN);
    }

}
