package top.fireddev.compactmachinesinfinite.mixin;

import dev.compactmods.machines.api.core.CMTags;
import dev.compactmods.machines.api.room.RoomSize;
import dev.compactmods.machines.machine.CompactMachineBlock;
import dev.compactmods.machines.shrinking.Shrinking;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.NameTagItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.fireddev.compactmachinesinfinite.Config;
import top.fireddev.compactmachinesinfinite.NewMachines;
import top.fireddev.compactmachinesinfinite.RoomSizeHelper;

@Mixin(value = CompactMachineBlock.class, remap = false)
public abstract class CompactMachineBlockMixin{
    @Inject(
            method = "use",
            at = @At("RETURN"),
            cancellable = true,
            remap = true
    )
    private void compactmachinesinfinite$allowUnhandledItemUse(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand handIn,
            BlockHitResult hit,
            CallbackInfoReturnable<InteractionResult> cir
    ) {
        if (!Config.ENABLE_BUG_FIX.get()) {
            return;
        }
        ItemStack mainItem = player.getMainHandItem();
        if (compactmachinesinfinite$isHandledByCompactMachines(mainItem)) {
            return;
        }
        cir.setReturnValue(InteractionResult.PASS);
    }

    @Unique
    private static boolean compactmachinesinfinite$isHandledByCompactMachines(
            ItemStack stack
    ) {
        return stack.isEmpty()
                || stack.getItem() == Shrinking.PERSONAL_SHRINKING_DEVICE.get()
                || (stack.getItem() instanceof NameTagItem
                && stack.hasCustomHoverName())
                || stack.is(CMTags.ROOM_UPGRADE_ITEM);
    }

    @Inject(method = "getBySize", at = @At(value = "HEAD"), cancellable = true)
    private static void getFromSizeInject(RoomSize size, CallbackInfoReturnable<Block> cir){
        if(size == RoomSizeHelper.get("xlarge"))cir.setReturnValue(NewMachines.MACHINE_BLOCK_XLARGE.get());
        if(size == RoomSizeHelper.get("extreme"))cir.setReturnValue(NewMachines.MACHINE_BLOCK_EXTREME.get());
        if(size == RoomSizeHelper.get("ultra"))cir.setReturnValue(NewMachines.MACHINE_BLOCK_ULTRA.get());
    }
}
