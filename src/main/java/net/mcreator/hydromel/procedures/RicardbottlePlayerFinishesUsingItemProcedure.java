package net.mcreator.hydromel.procedures;

import net.mcreator.hydromel.init.HydromelModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class RicardbottlePlayerFinishesUsingItemProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)HydromelModMobEffects.DRUNK.get(), 1200, 0));
         }
      }
   }
}
