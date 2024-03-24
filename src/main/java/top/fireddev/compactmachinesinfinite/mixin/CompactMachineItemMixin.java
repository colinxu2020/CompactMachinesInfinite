package top.fireddev.compactmachinesinfinite.mixin;

import dev.compactmods.machines.api.room.RoomSize;
import dev.compactmods.machines.machine.CompactMachineItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.fireddev.compactmachinesinfinite.NewMachines;
import top.fireddev.compactmachinesinfinite.RoomSizeHelper;


@Mixin(value = CompactMachineItem.class, remap = false)
public abstract class CompactMachineItemMixin {
    @Inject(method = "getItemBySize", at = @At(value = "HEAD"), cancellable = true)
    private static void getItemBySize(RoomSize size, CallbackInfoReturnable<Item> cir){
        if(size == RoomSizeHelper.get("xlarge"))cir.setReturnValue(NewMachines.MACHINE_BLOCK_ITEM_XLARGE.get());
        if(size == RoomSizeHelper.get("extreme"))cir.setReturnValue(NewMachines.MACHINE_BLOCK_ITEM_EXTREME.get());
        if(size == RoomSizeHelper.get("ultra"))cir.setReturnValue(NewMachines.MACHINE_BLOCK_ITEM_ULTRA.get());
    }
}
