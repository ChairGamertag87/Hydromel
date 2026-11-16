package net.mcreator.hydromel.init;

import net.mcreator.hydromel.world.inventory.DistilryMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HydromelModMenus {
   public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "hydromel");
   public static final RegistryObject<MenuType<DistilryMenu>> DISTILRY = REGISTRY.register("distilry", () -> IForgeMenuType.create(DistilryMenu::new));
}
