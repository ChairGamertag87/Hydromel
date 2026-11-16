package net.mcreator.hydromel.recipes.brewing;

import net.mcreator.hydromel.init.HydromelModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class HealHydromelRecipeBrewingRecipe implements IBrewingRecipe {
   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(new HealHydromelRecipeBrewingRecipe()));
   }

   public boolean isInput(ItemStack input) {
      return Ingredient.of(new ItemStack[]{new ItemStack((ItemLike)HydromelModItems.HYDROMEL_BOTTLE.get())}).test(input);
   }

   public boolean isIngredient(ItemStack ingredient) {
      return Ingredient.of(new ItemStack[]{new ItemStack(Items.GOLDEN_APPLE)}).test(ingredient);
   }

   public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
      return this.isInput(input) && this.isIngredient(ingredient) ? new ItemStack((ItemLike)HydromelModItems.HEAL_HYDROMEL_BOTTLE.get()) : ItemStack.EMPTY;
   }
}
