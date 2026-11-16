package net.mcreator.hydromel.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class PolishCowItem extends RecordItem {
   public PolishCowItem() {
      super(
         0,
         () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("hydromel:polish_cow")),
         new Properties().stacksTo(1).rarity(Rarity.EPIC),
         4460
      );
   }

   public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, world, list, flag);
   }
}
