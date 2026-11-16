package net.mcreator.hydromel.init;

import net.mcreator.hydromel.potion.DrunkMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HydromelModMobEffects {
   public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "hydromel");
   public static final RegistryObject<MobEffect> DRUNK = REGISTRY.register("drunk", () -> new DrunkMobEffect());
}
