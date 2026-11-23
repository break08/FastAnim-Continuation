package net.lunade.fastanim.mixin;

import net.minecraft.client.model.GhastModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GhastModel.class)
public class GhastEntityModelMixin<T extends Entity> {
   @Final
   @Shadow
   private ModelPart[] tentacles;

   @Inject(at = @At("HEAD"), method = "setupAnim", cancellable = true)
   public void setAngles(T entity, float limbAngle, float limbDistance, float h, float i, float j, CallbackInfo info) {
      info.cancel();

      for (int k = 0; k < this.tentacles.length; k++) {
         this.tentacles[k].xRot = (float)(0.2F * Math.sin(h * 0.3F + k) + 0.4F);
      }
   }
}
