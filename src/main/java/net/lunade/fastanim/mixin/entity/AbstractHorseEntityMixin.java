package net.lunade.fastanim.mixin.entity;

import net.minecraft.world.entity.animal.horse.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorse.class)
public class AbstractHorseEntityMixin {
   @Shadow
   private float eatAnimO;
   @Shadow
   private float eatAnim;
   @Shadow
   private float standAnimO;
   @Shadow
   private float standAnim;
   @Shadow
   private float mouthAnimO;
   @Shadow
   private float mouthAnim;

   @Inject(at = @At("HEAD"), method = "getEatAnim", cancellable = true)
   public void getEatingGrassAnimationProgress(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue(this.eatAnimO + f * (this.eatAnim - this.eatAnimO));
   }

   @Inject(at = @At("HEAD"), method = "getStandAnim", cancellable = true)
   public void getAngryAnimationProgress(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue(this.standAnimO + f * (this.standAnim - this.standAnimO));
   }

   @Inject(at = @At("HEAD"), method = "getMouthAnim", cancellable = true)
   public void getEatingAnimationProgress(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue(this.mouthAnimO + f * (this.mouthAnim - this.mouthAnimO));
   }
}
