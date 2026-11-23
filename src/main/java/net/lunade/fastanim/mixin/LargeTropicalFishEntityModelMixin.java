package net.lunade.fastanim.mixin;

import net.minecraft.client.model.TropicalFishModelB;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TropicalFishModelB.class)
public class LargeTropicalFishEntityModelMixin<T extends Entity> {
   @Final
   @Shadow
   private ModelPart tail;

   @Inject(at = @At("HEAD"), method = "setupAnim", cancellable = true)
   public void setAngles(T entity, float limbAngle, float limbDistance, float h, float i, float j, CallbackInfo info) {
      info.cancel();
      if (!entity.isInWater()) {
         this.tail.yRot = (float)(-0.675F * Math.sin(0.6F * h));
      } else {
         this.tail.yRot = (float)(-0.45F * Math.sin(0.6F * h));
      }
   }
}
