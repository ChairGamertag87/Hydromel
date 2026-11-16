package net.mcreator.hydromel.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DrunkMobEffect extends MobEffect {
   public DrunkMobEffect() {
      super(MobEffectCategory.HARMFUL, -6737152);
   }

   public String getDescriptionId() {
      return "effect.hydromel.drunk";
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
