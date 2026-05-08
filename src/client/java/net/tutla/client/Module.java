package net.tutla.client;

import net.tutla.client.config.Config;
import net.tutla.client.config.ConfigType;

public class Module {
    public final String name;
    public final String description;
    private boolean enabled;

    public String configName = null;
    public ConfigType configType = null;

    public Module(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void setConfig(String name, ConfigType type){
        this.configName = name;
        this.configType = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

}
