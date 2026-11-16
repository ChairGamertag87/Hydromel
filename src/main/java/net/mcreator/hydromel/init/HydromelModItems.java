package net.mcreator.hydromel.init;

import net.mcreator.hydromel.item.DEnchantedHealHydromelItem;
import net.mcreator.hydromel.item.DHealHydromelBottleItem;
import net.mcreator.hydromel.item.DRicardbottleItem;
import net.mcreator.hydromel.item.EnchantedHealHydromelBottleItem;
import net.mcreator.hydromel.item.HealHydromelBottleItem;
import net.mcreator.hydromel.item.HydromelBottleItem;
import net.mcreator.hydromel.item.KatyushaItem;
import net.mcreator.hydromel.item.PolishCowItem;
import net.mcreator.hydromel.item.YeastItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HydromelModItems {
   public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "hydromel");
   public static final RegistryObject<Item> YEAST = REGISTRY.register("yeast", () -> new YeastItem());
   public static final RegistryObject<Item> HYDROMEL_BOTTLE_2 = REGISTRY.register("hydromel_bottle_2", () -> new DRicardbottleItem());
   public static final RegistryObject<Item> HEAL_HYDROMEL_BOTTLE = REGISTRY.register("heal_hydromel_bottle", () -> new HealHydromelBottleItem());
   public static final RegistryObject<Item> D_HEAL_HYDROMEL_BOTTLE = REGISTRY.register("d_heal_hydromel_bottle", () -> new DHealHydromelBottleItem());
   public static final RegistryObject<Item> ENCHANTED_HEAL_HYDROMEL_BOTTLE = REGISTRY.register(
      "enchanted_heal_hydromel_bottle", () -> new EnchantedHealHydromelBottleItem()
   );
   public static final RegistryObject<Item> D_ENCHANTED_HEAL_HYDROMEL = REGISTRY.register("d_enchanted_heal_hydromel", () -> new DEnchantedHealHydromelItem());
   public static final RegistryObject<Item> POLISH_COW = REGISTRY.register("polish_cow", () -> new PolishCowItem());
   public static final RegistryObject<Item> KATYUSHA = REGISTRY.register("katyusha", () -> new KatyushaItem());
   public static final RegistryObject<Item> DISTILLERY_STAND = block(HydromelModBlocks.DISTILLERY_STAND);
   public static final RegistryObject<Item> HYDROMEL_BOTTLE = REGISTRY.register("hydromel_bottle", () -> new HydromelBottleItem());

   private static RegistryObject<Item> block(RegistryObject<Block> block) {
      return REGISTRY.register(block.getId().getPath(), () -> new BlockItem((Block)block.get(), new Properties()));
   }
}
