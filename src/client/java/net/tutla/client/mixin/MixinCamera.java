package net.tutla.client.mixin;

import net.minecraft.client.Camera;
import net.minecraft.world.level.material.FogType;
import net.tutla.client.util.TutlaUtil;
import net.tutla.client.module.ClearWater;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public abstract class MixinCamera{

    @Inject(method = "getFluidInCamera", at = @At("RETURN"), cancellable = true)
    public void getSubmersionType(CallbackInfoReturnable<FogType> cir) {
        if (TutlaUtil.isModuleEnabled(ClearWater.class)) {
            cir.setReturnValue(FogType.NONE);
        }

    }


}
