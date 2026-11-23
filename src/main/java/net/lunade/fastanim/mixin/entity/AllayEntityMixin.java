package net.lunade.fastanim.mixin.entity;

import net.minecraft.world.entity.animal.allay.Allay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Allay.class)
public class AllayEntityMixin {
   @Shadow
   private float holdingItemAnimationTicks0;
   @Shadow
   private float holdingItemAnimationTicks;
   @Shadow
   private float spinningAnimationTicks0;
   @Shadow
   private float spinningAnimationTicks;

   @Inject(at = @At("HEAD"), method = "getHoldingItemAnimationProgress", cancellable = true)
   public void getHoldingItemAnimationProgress(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue((this.holdingItemAnimationTicks0 + f * (this.holdingItemAnimationTicks - this.holdingItemAnimationTicks0)) * 0.2F);
   }

   @Inject(at = @At("HEAD"), method = "getSpinningProgress", cancellable = true)
   public void getSpinningProgress(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue((this.spinningAnimationTicks0 + f * (this.spinningAnimationTicks - this.spinningAnimationTicks0)) * 0.06666667F);
   }
}
