package net.mcreator.hydromel.item;

import java.util.List;
import net.mcreator.hydromel.procedures.EnchantedHealHydromelBottlePlayerFinishesUsingItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DEnchantedHealHydromelItem extends Item {
   public DEnchantedHealHydromelItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).food(new Builder().nutrition(4).saturationMod(6.0F).alwaysEat().build()));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.DRINK;
   }

   public int getEnchantmentValue() {
      return -1;
   }

   public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
      return 1.1F;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public boolean isCorrectToolForDrops(BlockState state) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, world, list, flag);
      list.add(Component.literal("§9Regeneration II (0:20) "));
      list.add(Component.literal("§9Absorption IV (1:30)"));
      list.add(Component.literal("§9Fire resistance (2:30)"));
      list.add(Component.literal("§9Resistance (2:30)"));
      list.add(Component.literal(""));
      list.add(Component.literal("§5When applied:"));
      list.add(Component.literal("§9+16 Health Point"));
      list.add(Component.literal(""));
      list.add(Component.literal("§6Capacity (1/2)"));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
      super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      EnchantedHealHydromelBottlePlayerFinishesUsingItemProcedure.execute(entity);
      if (itemstack.isEmpty()) {
         return retval;
      } else {
         if (entity instanceof Player player && !player.getAbilities().instabuild && !player.getInventory().add(retval)) {
            player.drop(retval, false);
         }

         return itemstack;
      }
   }
}
