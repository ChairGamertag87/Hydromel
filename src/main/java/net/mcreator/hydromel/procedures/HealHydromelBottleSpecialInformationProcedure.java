package net.mcreator.hydromel.procedures;

import net.minecraft.world.item.ItemStack;

public class HealHydromelBottleSpecialInformationProcedure {
   public static void execute(ItemStack itemstack) {
      itemstack.getOrCreateTag().putString("line1", "Hey");
   }
}
