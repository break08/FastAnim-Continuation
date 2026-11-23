package net.lunade.fastanim.mixin.entity;

import net.minecraft.world.entity.animal.Bee;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Bee.class)
public class BeeEntityMixin {
   @Shadow
   private float rollAmount;
   @Shadow
   private float rollAmountO;

   @Inject(at = @At("HEAD"), method = "getRollAmount", cancellable = true)
   public void getBodyPitch(float tickDelta, CallbackInfoReturnable<Float> info) {
      info.setReturnValue(this.rollAmountO + tickDelta * (this.rollAmount - this.rollAmountO));
   }
}
