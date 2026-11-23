package net.lunade.fastanim.mixin.entity;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
   @Shadow
   private float swimAmountO;
   @Shadow
   private float swimAmount;

   @Inject(at = @At("HEAD"), method = "getSwimAmount", cancellable = true)
   public void getLeaningPitch(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue(this.swimAmountO + f * (this.swimAmount - this.swimAmountO));
   }
}
