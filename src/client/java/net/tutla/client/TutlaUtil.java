package net.tutla.client;

public class TutlaUtil {
    public static boolean isModuleEnabled(Class<? extends Module> module){
        return TutlaClientInitializer.getModules().get(module).isEnabled();
    }
}
