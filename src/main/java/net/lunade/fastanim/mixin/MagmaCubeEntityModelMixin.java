package net.lunade.fastanim.mixin;

import net.minecraft.client.model.LavaSlimeModel;
import net.minecraft.world.entity.monster.Slime;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LavaSlimeModel.class)
public class MagmaCubeEntityModelMixin<T extends Slime> {
   @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;lerp(FFF)F"), method = "prepareMobModel")
   public float animateModel(float h, float par1, float par2) {
      return par1 + h * (par2 - par1);
   }
}
