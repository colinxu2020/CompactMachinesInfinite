package top.fireddev.compactmachinesinfinite.mixin;

import dev.compactmods.machines.room.data.CompactRoomData;
import dev.compactmods.machines.shrinking.PersonalShrinkingDevice;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import top.fireddev.compactmachinesinfinite.RoomLocator;

@Mixin(value = PersonalShrinkingDevice.class, remap = false)
public abstract class PersonalShrinkingDeviceMixin {
    @Redirect(
            method = "use",
            remap = true,
            at = @At(
                    value = "INVOKE",
                    remap = false,
                    target =
                            "Ldev/compactmods/machines/room/data/CompactRoomData;" +
                                    "setSpawn(" +
                                    "Lnet/minecraft/world/level/ChunkPos;" +
                                    "Lnet/minecraft/world/phys/Vec3;" +
                                    "Lnet/minecraft/world/phys/Vec2;" +
                                    ")V"
            )
    )
    private void compactmachinesinfinite$setLargeRoomSpawn(
            CompactRoomData data,
            ChunkPos originalChunk,
            Vec3 position,
            Vec2 rotation
    ) {
        ChunkPos roomKey = RoomLocator
                .findRoomKey(data, position)
                .orElse(originalChunk);

        data.setSpawn(roomKey, position, rotation);
    }
}