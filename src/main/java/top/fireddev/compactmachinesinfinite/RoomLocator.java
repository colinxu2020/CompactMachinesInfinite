package top.fireddev.compactmachinesinfinite;

import dev.compactmods.machines.api.dimension.CompactDimension;
import dev.compactmods.machines.room.data.CompactRoomData;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public final class RoomLocator {

    private RoomLocator() {
    }
    public static Optional<CompactRoomData.RoomData> findContainingRoom(
            CompactRoomData data,
            Vec3 target,
            double margin
    ) {
        ChunkPos currentChunk =
                new ChunkPos(BlockPos.containing(target));

        Optional<CompactRoomData.RoomData> direct = data
                .forRoom(currentChunk)
                .filter(room ->
                        room.getRoomBounds()
                                .inflate(margin)
                                .contains(target)
                );

        if (direct.isPresent()) {
            return direct;
        }

        return data.streamRooms()
                .filter(room ->
                        room.getRoomBounds()
                                .inflate(margin)
                                .contains(target)
                )
                .findFirst();
    }

    public static Optional<ChunkPos> findRoomKey(
            CompactRoomData data,
            Vec3 target
    ) {
        return findContainingRoom(data, target, 0.0D)
                .map(room -> new ChunkPos(room.getCenter()));
    }
    public static Optional<CompactRoomData.RoomData> findContainingRoom(
            ServerLevel level,
            Vec3 target,
            double margin
    ) {
        if (!level.dimension().equals(CompactDimension.LEVEL_KEY)) {
            return Optional.empty();
        }

        return findContainingRoom(
                CompactRoomData.get(level),
                target,
                margin
        );
    }
}