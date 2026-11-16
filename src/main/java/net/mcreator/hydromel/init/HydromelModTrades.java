package net.mcreator.hydromel.init;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.FORGE
)
public class HydromelModTrades {
   @SubscribeEvent
   public static void registerTrades(VillagerTradesEvent event) {
      if (event.getType() == HydromelModVillagerProfessions.BEEKEEPER.get()) {
         ((List)event.getTrades().get(1)).add(new BasicItemListing(new ItemStack(Items.HONEY_BOTTLE), new ItemStack(Items.EMERALD, 3), 10, 5, 0.06F));
      }

      if (event.getType() == HydromelModVillagerProfessions.BEEKEEPER.get()) {
         ((List)event.getTrades().get(1)).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Items.HONEYCOMB), 13, 5, 0.05F));
      }

      if (event.getType() == HydromelModVillagerProfessions.BEEKEEPER.get()) {
         ((List)event.getTrades().get(2))
            .add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack((ItemLike)HydromelModItems.YEAST.get()), 6, 5, 0.05F));
      }
   }
}
