package net.tutla.client.module;

import net.tutla.client.Module;
import net.tutla.client.config.ConfigType;

public class NoViewBob extends Module {
    public NoViewBob() {
        super("NoViewBob", "Prevents shake while walking");
        setConfig("noviewbob", ConfigType.BOOLEAN);
    }

}
