package net.tutla.client.config;

import io.github.itzispyder.improperui.ImproperUIAPI;
import io.github.itzispyder.improperui.config.ConfigReader;
import net.tutla.client.TutlaClientInitializer;

public class Config {
    private static final ConfigReader configReader = ImproperUIAPI.getConfigReader("tutlaclient", "config.properties");

    public static ConfigReader getConfigReader(){
        return configReader;
    }

    public static void saveAll(){
        TutlaClientInitializer.getModules().forEach((t, module) -> {
            if(module.configType == ConfigType.BOOLEAN){
                module.setEnabled(configReader.readBool(module.configName, false));
            }
        });
    }
}
