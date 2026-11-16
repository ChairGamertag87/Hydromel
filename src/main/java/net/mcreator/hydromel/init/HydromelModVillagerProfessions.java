package net.mcreator.hydromel.init;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.mcreator.hydromel.HydromelMod;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries.Keys;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class HydromelModVillagerProfessions {
   private static final Map<String, HydromelModVillagerProfessions.ProfessionPoiType> POI_TYPES = new HashMap<>();
   public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, "hydromel");
   public static final RegistryObject<VillagerProfession> BEEKEEPER = registerProfession(
      "beekeeper",
      () -> (Block)HydromelModBlocks.DISTILLERY_STAND.get(),
      () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.work_cleric"))
   );

   private static RegistryObject<VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
      POI_TYPES.put(name, new HydromelModVillagerProfessions.ProfessionPoiType(block, null));
      return PROFESSIONS.register(
         name,
         () -> {
            Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> POI_TYPES.get(name).poiType != null
               && poiTypeHolder.get() == POI_TYPES.get(name).poiType.get();
            return new VillagerProfession("hydromel:" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
         }
      );
   }

   @SubscribeEvent
   public static void registerProfessionPointsOfInterest(RegisterEvent event) {
      event.register(
         Keys.POI_TYPES,
         registerHelper -> {
            for (Entry<String, HydromelModVillagerProfessions.ProfessionPoiType> entry : POI_TYPES.entrySet()) {
               Block block = entry.getValue().block.get();
               String name = entry.getKey();
               Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
               if (existingCheck.isPresent()) {
                  HydromelMod.LOGGER
                     .error("Skipping villager profession " + name + " that uses POI block " + block + " that is already in use by " + existingCheck);
               } else {
                  PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
                  registerHelper.register(name, poiType);
                  entry.getValue().poiType = (Holder<PoiType>)ForgeRegistries.POI_TYPES.getHolder(poiType).get();
               }
            }
         }
      );
   }

   private static class ProfessionPoiType {
      final Supplier<Block> block;
      Holder<PoiType> poiType;

      ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
         this.block = block;
         this.poiType = poiType;
      }
   }
}
