package net.lunade.fastanim.mixin.entity;

import net.minecraft.world.entity.monster.warden.Warden;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Warden.class)
public class WardenEntityMixin {
   @Shadow
   private int tendrilAnimationO;
   @Shadow
   private int tendrilAnimation;
   @Shadow
   private int heartAnimationO;
   @Shadow
   private int heartAnimation;

   @Inject(at = @At("HEAD"), method = "getTendrilAnimation", cancellable = true)
   public void getTendrilPitch(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue((this.tendrilAnimationO + f * (this.tendrilAnimation - this.tendrilAnimationO)) * 0.1F);
   }

   @Inject(at = @At("HEAD"), method = "getHeartAnimation", cancellable = true)
   public void getHeartPitch(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue((this.heartAnimationO + f * (this.heartAnimation - this.heartAnimationO)) * 0.1F);
   }
}
