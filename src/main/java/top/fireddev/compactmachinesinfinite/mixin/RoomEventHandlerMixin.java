package top.fireddev.compactmachinesinfinite.mixin;

import dev.compactmods.machines.room.RoomEventHandler;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.fireddev.compactmachinesinfinite.RoomLocator;

@Mixin(value = RoomEventHandler.class, remap = false)
public class RoomEventHandlerMixin {
    @Inject(method = "positionInsideRoom", at = @At("HEAD"), cancellable = true)

    private static void compactmachinesinfinite$positionInsideRoom(
            Entity entity,
            Vec3 target,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (!(entity.level() instanceof ServerLevel serverLevel)) {
            cir.setReturnValue(false);
            return;
        }

        boolean inside = RoomLocator
                .findContainingRoom(serverLevel, target, 1.0D)
                .isPresent();

        cir.setReturnValue(inside);
    }
}
