package net.lunade.fastanim.mixin;

import net.minecraft.client.model.PufferfishMidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PufferfishMidModel.class)
public class MediumPufferfishEntityModelMixin<T extends Entity> {
   @Final
   @Shadow
   private ModelPart leftBlueFin;
   @Final
   @Shadow
   private ModelPart rightBlueFin;

   @Inject(at = @At("HEAD"), method = "setupAnim", cancellable = true)
   public void setAngles(T entity, float limbAngle, float limbDistance, float h, float i, float j, CallbackInfo info) {
      info.cancel();
      float sin = (float)Math.sin(h * 0.2F);
      this.leftBlueFin.zRot = -0.2F + 0.4F * sin;
      this.rightBlueFin.zRot = 0.2F - 0.4F * sin;
   }
}
