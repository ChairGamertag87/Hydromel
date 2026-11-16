package net.mcreator.hydromel.item;

import java.util.List;
import net.mcreator.hydromel.init.HydromelModItems;
import net.mcreator.hydromel.procedures.HealHydromelBottlePlayerFinishesUsingItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HealHydromelBottleItem extends Item {
   public HealHydromelBottleItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON).food(new Builder().nutrition(4).saturationMod(6.0F).build()));
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

   public boolean isCorrectToolForDrops(BlockState state) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, world, list, flag);
      list.add(Component.literal("§9Regeneration II (0:05)"));
      list.add(Component.literal("§9Absorption (1:30)"));
      list.add(Component.literal(""));
      list.add(Component.literal("§5When applied:"));
      list.add(Component.literal("§9+4 Health Point"));
      list.add(Component.literal(""));
      list.add(Component.literal("§6Capacity (2/2)"));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = new ItemStack((ItemLike)HydromelModItems.D_HEAL_HYDROMEL_BOTTLE.get());
      super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      HealHydromelBottlePlayerFinishesUsingItemProcedure.execute(entity);
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
