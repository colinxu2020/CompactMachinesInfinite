package top.fireddev.compactmachinesinfinite;

import dev.compactmods.machines.api.room.RoomSize;

import java.util.HashMap;

public class RoomSizeHelper {
    private static final HashMap<String, RoomSize> sizes = new HashMap<>();

    public static RoomSize get(String name){
        return sizes.get(name);
    }

    public static void set(String name, RoomSize size){
        sizes.put(name, size);
    }
}
