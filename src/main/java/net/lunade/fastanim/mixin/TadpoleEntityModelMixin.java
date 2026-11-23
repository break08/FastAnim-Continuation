package net.lunade.fastanim.mixin;

import net.minecraft.client.model.TadpoleModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.frog.Tadpole;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TadpoleModel.class, priority = 900)
public class TadpoleEntityModelMixin<T extends Tadpole> {
   @Final
   @Shadow
   private ModelPart tail;

   @Inject(at = @At("HEAD"), method = "setupAnim*", cancellable = true)
   public void setAngles(T tadpoleEntity, float limbAngle, float limbDistance, float h, float i, float j, CallbackInfo info) {
      info.cancel();
      if (tadpoleEntity.isInWater()) {
         this.tail.yRot = -0.25F * Mth.sin(0.3F * h);
      } else {
         this.tail.yRot = -0.375F * Mth.sin(0.3F * h);
      }
   }
}
