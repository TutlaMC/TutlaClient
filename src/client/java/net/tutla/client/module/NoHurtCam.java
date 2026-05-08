package net.tutla.client.module;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.tutla.client.Module;
import net.tutla.client.config.ConfigType;

public class NoHurtCam extends Module {
    public NoHurtCam() {
        super("NoHurtCam", "Prevents shake when damaged");
        setConfig("nohurtcam", ConfigType.BOOLEAN);
    }

}
