package net.lunade.fastanim.mixin;

import net.minecraft.client.model.ModelUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ModelUtils.class)
public class ModelUtilMixin {
   @Inject(at = @At("HEAD"), method = "rotlerpRad", cancellable = true)
   private static void interpolateAngle(float f, float g, float h, CallbackInfoReturnable<Float> info) {
      float i = (h - g) % (float) (Math.PI * 2);
      if (i < (float) -Math.PI) {
         i += (float) (Math.PI * 2);
      }

      if (i >= (float) Math.PI) {
         i -= (float) (Math.PI * 2);
      }

      info.setReturnValue(g + f * i);
   }
}
