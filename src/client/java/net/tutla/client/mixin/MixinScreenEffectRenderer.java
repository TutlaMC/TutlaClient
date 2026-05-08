package net.tutla.client.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.tutla.client.module.NoFire;
import net.tutla.client.util.TutlaUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ScreenEffectRenderer.class)
public abstract class MixinScreenEffectRenderer {
    /*
    @ModifyArgs(method = "renderItemActivationAnimation", at = @At(target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V", value = "INVOKE"))
    public void renderFloatingItemScaled(Args args) {
        if (!Module.isEnabled(TotemPopScale.class)) {
            return;
        }

        double scale = Module.get(TotemPopScale.class).scale.getVal();
        float f = (float)scale;
        args.set(0, (float)args.get(0) * f);
        args.set(1, (float)args.get(1) * f);
        args.set(2, (float)args.get(2) * f);
    }

    @ModifyArgs(method = "renderItemActivationAnimation", at = @At(target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V", value = "INVOKE"))
    public void renderFloatingItemTranslated(Args args) {
        if (!Module.isEnabled(TotemPopScale.class)) {
            return;
        }

        TotemPopScale tps = Module.get(TotemPopScale.class);
        double deltaX = tps.translateX.getVal();
        double deltaY = tps.translateY.getVal();
        float x = (float)deltaX;
        float y = (float)deltaY;
        args.set(0, (float)args.get(0) + x);
        args.set(1, (float)args.get(1) - y);
    }*/ // thank you improper for your totem code // TODO: add totem size

    @Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void renderFire(PoseStack poseStack, MultiBufferSource bufferSource, TextureAtlasSprite sprite, CallbackInfo ci) {
        if (TutlaUtil.isModuleEnabled(NoFire.class))
            ci.cancel();
    }
}