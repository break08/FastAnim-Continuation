package net.lunade.fastanim.mixin.entity;

import net.minecraft.world.entity.monster.Guardian;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Guardian.class)
public class GuardianEntityMixin {
   @Shadow
   private float clientSideTailAnimationO;
   @Shadow
   private float clientSideTailAnimation;

   @Inject(at = @At("HEAD"), method = "getTailAnimation", cancellable = true)
   public void getTailAngle(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue(this.clientSideTailAnimationO + f * (this.clientSideTailAnimation - this.clientSideTailAnimationO));
   }
}
