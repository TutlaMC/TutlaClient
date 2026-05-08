package net.tutla.client.mixin;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
import net.tutla.client.util.TutlaUtil;
import net.tutla.client.module.NoPortalOverlay;
import net.tutla.client.module.NoPumpkinHead;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class MixinGui {
    @Inject(method = "extractPortalOverlay", at = @At("HEAD"), cancellable = true)
    public void renderPortalOverlay(GuiGraphicsExtractor context, float nauseaStrength, CallbackInfo ci) {
        if (TutlaUtil.isModuleEnabled(NoPortalOverlay.class)) ci.cancel();
    }

    @Inject(method = "extractTextureOverlay", at = @At("HEAD"), cancellable = true)
    public void renderOverlay(GuiGraphicsExtractor context, Identifier texture, float opacity, CallbackInfo ci) {
        if (!texture.getPath().contains("pumpkinblur")) return;
        if (TutlaUtil.isModuleEnabled(NoPumpkinHead.class)) ci.cancel();
    }

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    public void renderHuds(GuiGraphicsExtractor context, DeltaTracker tickCounter, CallbackInfo ci) {
        //TODO: for rendering huds in the future
    }
}
