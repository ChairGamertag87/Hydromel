package net.mcreator.hydromel.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class HydromelModTabs {
   public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "hydromel");
   public static final RegistryObject<CreativeModeTab> HYDROMEL = REGISTRY.register(
      "hydromel",
      () -> CreativeModeTab.builder()
         .title(Component.translatable("item_group.hydromel.hydromel"))
         .icon(() -> new ItemStack((ItemLike)HydromelModBlocks.DISTILLERY_STAND.get()))
         .displayItems((parameters, tabData) -> {
            tabData.accept((ItemLike)HydromelModItems.YEAST.get());
            tabData.accept((ItemLike)HydromelModItems.HYDROMEL_BOTTLE_2.get());
            tabData.accept((ItemLike)HydromelModItems.HEAL_HYDROMEL_BOTTLE.get());
            tabData.accept((ItemLike)HydromelModItems.D_HEAL_HYDROMEL_BOTTLE.get());
            tabData.accept((ItemLike)HydromelModItems.ENCHANTED_HEAL_HYDROMEL_BOTTLE.get());
            tabData.accept((ItemLike)HydromelModItems.D_ENCHANTED_HEAL_HYDROMEL.get());
            tabData.accept(((Block)HydromelModBlocks.DISTILLERY_STAND.get()).asItem());
            tabData.accept((ItemLike)HydromelModItems.HYDROMEL_BOTTLE.get());
         })
         .withSearchBar()
         .build()
   );
}
