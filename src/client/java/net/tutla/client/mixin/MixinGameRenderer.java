package net.tutla.client.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.tutla.client.util.TutlaUtil;
import net.tutla.client.module.NoHurtCam;
import net.tutla.client.module.NoViewBob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {

    @Inject(method = "bobHurt", at = @At("HEAD"), cancellable = true)
    public void onHurtViewTilt(CameraRenderState cameraState, PoseStack poseStack, CallbackInfo ci) {
        if (TutlaUtil.isModuleEnabled(NoHurtCam.class)) {
            ci.cancel();
        }
    }

    @Inject(method = "bobView", at = @At("HEAD"), cancellable = true)
    public void onViewBob(CameraRenderState cameraState, PoseStack poseStack, CallbackInfo ci) {
        if (TutlaUtil.isModuleEnabled(NoViewBob.class)) {
            ci.cancel();
        }
    }
}