package net.lunade.fastanim.mixin.entity;

import net.minecraft.world.entity.monster.Shulker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Shulker.class)
public class ShulkerEntityMixin {
   @Shadow
   private float currentPeekAmountO;
   @Shadow
   private float currentPeekAmount;

   @Inject(at = @At("HEAD"), method = "getClientPeekAmount", cancellable = true)
   public void getOpenProgress(float f, CallbackInfoReturnable<Float> info) {
      info.setReturnValue(this.currentPeekAmountO + f * (this.currentPeekAmount - this.currentPeekAmountO));
   }
}
