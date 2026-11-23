package net.lunade.fastanim.mixin;

import net.minecraft.client.model.PufferfishSmallModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PufferfishSmallModel.class, priority = 900)
public class SmallPufferfishEntityModelMixin<T extends Entity> {
   @Final
   @Shadow
   private ModelPart leftFin;
   @Final
   @Shadow
   private ModelPart rightFin;

   @Inject(at = @At("HEAD"), method = "setupAnim", cancellable = true)
   public void setAngles(T entity, float limbAngle, float limbDistance, float h, float i, float j, CallbackInfo info) {
      info.cancel();
      float sin = (float)Math.sin(h * 0.2F);
      this.leftFin.zRot = -0.2F + 0.4F * sin;
      this.rightFin.zRot = 0.2F - 0.4F * sin;
   }
}
