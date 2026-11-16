package net.mcreator.hydromel.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.hydromel.init.HydromelModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class DistiliryrecipeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (((new Object() {
         public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
            }

            return _retval.get();
         }
      }).getItemStack(world, BlockPos.containing(x, y, z), 5).getItem() == Items.HONEY_BOTTLE || (new Object() {
         public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
            }

            return _retval.get();
         }
      }).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == Items.HONEY_BOTTLE || (new Object() {
         public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
            }

            return _retval.get();
         }
      }).getItemStack(world, BlockPos.containing(x, y, z), 4).getItem() == Items.HONEY_BOTTLE) && (new Object() {
         public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
            }

            return _retval.get();
         }
      }).getItemStack(world, BlockPos.containing(x, y, z), 3).getItem() == HydromelModItems.YEAST.get() && (new Object() {
         public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
            }

            return _retval.get();
         }
      }).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == Blocks.AIR.asItem() && (new Object() {
         public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
            }

            return _retval.get();
         }
      }).getItemStack(world, BlockPos.containing(x, y, z), 6).getItem() == Items.BLAZE_ROD) {
         if ((new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
               AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
               BlockEntity _ent = world.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
               }

               return _retval.get();
            }
         }).getItemStack(world, BlockPos.containing(x, y, z), 5).getItem() == Items.HONEY_BOTTLE) {
            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               int _slotid = 5;
               int _amount = 1;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(5).copy();
                     _stk.shrink(1);
                     ((IItemHandlerModifiable)capability).setStackInSlot(5, _stk);
                  }
               });
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               int _slotid = 5;
               ItemStack _setstack = new ItemStack((ItemLike)HydromelModItems.HYDROMEL_BOTTLE.get());
               _setstack.setCount(
                  (new Object() {
                           public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                              AtomicInteger _retval = new AtomicInteger(0);
                              BlockEntity _entx = world.getBlockEntity(pos);
                              if (_entx != null) {
                                 _entx.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                              }

                              return _retval.get();
                           }
                        })
                        .getAmount(world, BlockPos.containing(x, y, z), 5)
                     + 1
               );
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(5, _setstack);
                  }
               });
            }
         }

         if ((new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
               AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
               BlockEntity _ent = world.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
               }

               return _retval.get();
            }
         }).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == Items.HONEY_BOTTLE) {
            BlockEntity _entx = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_entx != null) {
               int _slotid = 1;
               int _amount = 1;
               _entx.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(1).copy();
                     _stk.shrink(1);
                     ((IItemHandlerModifiable)capability).setStackInSlot(1, _stk);
                  }
               });
            }

            _entx = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_entx != null) {
               int _slotid = 1;
               ItemStack _setstack = new ItemStack((ItemLike)HydromelModItems.HYDROMEL_BOTTLE.get());
               _setstack.setCount(
                  (new Object() {
                           public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                              AtomicInteger _retval = new AtomicInteger(0);
                              BlockEntity _ent = world.getBlockEntity(pos);
                              if (_ent != null) {
                                 _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                              }

                              return _retval.get();
                           }
                        })
                        .getAmount(world, BlockPos.containing(x, y, z), 1)
                     + 1
               );
               _entx.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(1, _setstack);
                  }
               });
            }
         }

         if ((new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
               AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
               BlockEntity _ent = world.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
               }

               return _retval.get();
            }
         }).getItemStack(world, BlockPos.containing(x, y, z), 4).getItem() == Items.HONEY_BOTTLE) {
            BlockEntity _entxx = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_entxx != null) {
               int _slotid = 4;
               int _amount = 1;
               _entxx.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(4).copy();
                     _stk.shrink(1);
                     ((IItemHandlerModifiable)capability).setStackInSlot(4, _stk);
                  }
               });
            }

            _entxx = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_entxx != null) {
               int _slotid = 4;
               ItemStack _setstack = new ItemStack((ItemLike)HydromelModItems.HYDROMEL_BOTTLE.get());
               _setstack.setCount(
                  (new Object() {
                           public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                              AtomicInteger _retval = new AtomicInteger(0);
                              BlockEntity _ent = world.getBlockEntity(pos);
                              if (_ent != null) {
                                 _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                              }

                              return _retval.get();
                           }
                        })
                        .getAmount(world, BlockPos.containing(x, y, z), 4)
                     + 1
               );
               _entxx.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(4, _setstack);
                  }
               });
            }
         }

         BlockEntity _entxxx = world.getBlockEntity(BlockPos.containing(x, y, z));
         if (_entxxx != null) {
            int _slotid = 6;
            int _amount = 1;
            _entxxx.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ItemStack _stk = capability.getStackInSlot(6).copy();
                  _stk.shrink(1);
                  ((IItemHandlerModifiable)capability).setStackInSlot(6, _stk);
               }
            });
         }

         _entxxx = world.getBlockEntity(BlockPos.containing(x, y, z));
         if (_entxxx != null) {
            int _slotid = 2;
            int _amount = 1;
            _entxxx.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ItemStack _stk = capability.getStackInSlot(2).copy();
                  _stk.shrink(1);
                  ((IItemHandlerModifiable)capability).setStackInSlot(2, _stk);
               }
            });
         }
      }
   }
}
