package net.tutla.client.util;

import net.tutla.client.Module;
import net.tutla.client.TutlaClientInitializer;

public class TutlaUtil {
    public static boolean isModuleEnabled(Class<? extends Module> module){
        return TutlaClientInitializer.getModules().get(module).isEnabled();
    }
}
