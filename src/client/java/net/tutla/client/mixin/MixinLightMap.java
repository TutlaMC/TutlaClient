package net.tutla.client.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import net.minecraft.client.renderer.Lightmap;
import net.minecraft.client.renderer.state.LightmapRenderState;
import net.minecraft.util.profiling.ProfilerFiller;
import net.tutla.client.module.FullBright;
import net.tutla.client.util.TutlaUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Lightmap.class)
public abstract class MixinLightMap {

    @Shadow @Final private GpuTexture texture;

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;push(Ljava/lang/String;)V", shift = At.Shift.AFTER), cancellable = true)
    private void onUpdate(LightmapRenderState renderState, CallbackInfo ci, @Local ProfilerFiller profiler) {
        if (TutlaUtil.isModuleEnabled(FullBright.class)) {
            RenderSystem.getDevice().createCommandEncoder().clearColorTexture(this.texture, 0xFFFFFFFF);
            profiler.pop();
            ci.cancel();
        }
    }
}
