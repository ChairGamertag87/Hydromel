package net.mcreator.hydromel.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HydromelModSounds {
   public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "hydromel");
   public static final RegistryObject<SoundEvent> POLISH_COW = REGISTRY.register(
      "polish_cow", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("hydromel", "polish_cow"))
   );
   public static final RegistryObject<SoundEvent> KATYUSHA = REGISTRY.register(
      "katyusha", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("hydromel", "katyusha"))
   );
}
