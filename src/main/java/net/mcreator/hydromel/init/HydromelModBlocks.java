package net.mcreator.hydromel.init;

import net.mcreator.hydromel.block.DistilleryStandBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HydromelModBlocks {
   public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "hydromel");
   public static final RegistryObject<Block> DISTILLERY_STAND = REGISTRY.register("distillery_stand", () -> new DistilleryStandBlock());
}
