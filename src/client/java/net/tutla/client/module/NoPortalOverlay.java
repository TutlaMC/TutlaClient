package net.tutla.client.module;

import net.tutla.client.Module;
import net.tutla.client.config.ConfigType;

public class NoPortalOverlay extends Module {
    public NoPortalOverlay() {
        super("NoPortalOverlay", "Disables portal overlay");
        setConfig("noportaloverlay", ConfigType.BOOLEAN);
    }

}
