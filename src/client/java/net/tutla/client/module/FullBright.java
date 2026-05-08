package net.tutla.client.module;

import net.tutla.client.Module;
import net.tutla.client.config.ConfigType;

public class FullBright extends Module {
    public FullBright() {
        super("fullbright", "See in darkness");
        setConfig("fullbright", ConfigType.BOOLEAN);
    }
}
