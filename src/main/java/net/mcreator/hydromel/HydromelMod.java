package net.mcreator.hydromel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.mcreator.hydromel.init.HydromelModBlockEntities;
import net.mcreator.hydromel.init.HydromelModBlocks;
import net.mcreator.hydromel.init.HydromelModItems;
import net.mcreator.hydromel.init.HydromelModMenus;
import net.mcreator.hydromel.init.HydromelModMobEffects;
import net.mcreator.hydromel.init.HydromelModSounds;
import net.mcreator.hydromel.init.HydromelModTabs;
import net.mcreator.hydromel.init.HydromelModVillagerProfessions;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent.Context;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("hydromel")
public class HydromelMod {
   public static final Logger LOGGER = LogManager.getLogger(HydromelMod.class);
   public static final String MODID = "hydromel";
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(
      new ResourceLocation("hydromel", "hydromel"), () -> "1", "1"::equals, "1"::equals
   );
   private static int messageID = 0;
   private static final Collection<SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

   public HydromelMod() {
      MinecraftForge.EVENT_BUS.register(this);
      IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
      HydromelModSounds.REGISTRY.register(bus);
      HydromelModBlocks.REGISTRY.register(bus);
      HydromelModBlockEntities.REGISTRY.register(bus);
      HydromelModItems.REGISTRY.register(bus);
      HydromelModTabs.REGISTRY.register(bus);
      HydromelModMobEffects.REGISTRY.register(bus);
      HydromelModVillagerProfessions.PROFESSIONS.register(bus);
      HydromelModMenus.REGISTRY.register(bus);
   }

   public static <T> void addNetworkMessage(
      Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<Context>> messageConsumer
   ) {
      PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
      messageID++;
   }

   public static void queueServerWork(int tick, Runnable action) {
      workQueue.add(new SimpleEntry<>(action, tick));
   }

   @SubscribeEvent
   public void tick(ServerTickEvent event) {
      if (event.phase == Phase.END) {
         List<SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
         workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() == 0) {
               actions.add((SimpleEntry<Runnable, Integer>)work);
            }
         });
         actions.forEach(e -> e.getKey().run());
         workQueue.removeAll(actions);
      }
   }
}
