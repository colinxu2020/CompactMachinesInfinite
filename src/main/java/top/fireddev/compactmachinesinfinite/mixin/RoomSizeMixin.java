package top.fireddev.compactmachinesinfinite.mixin;

import dev.compactmods.machines.api.room.RoomSize;
import net.minecraft.core.Vec3i;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.util.StringRepresentable;
import org.spongepowered.asm.mixin.Shadow;
import top.fireddev.compactmachinesinfinite.Config;

@Mixin(value = RoomSize.class)
public abstract class RoomSizeMixin implements StringRepresentable{
    @Final
    @Shadow
    private String name;
    public int getInternalSize() {
        return Config.getRoomSize(this.name);
    }

    public Vec3i toVec3() {
        int size = getInternalSize();
        return new Vec3i(size, size, size);
    }

    public RoomSize maximum() {
        int size = 0;
        RoomSize value = null;
        for(RoomSize cur : RoomSize.values()){
            if(cur.getInternalSize() > size){
                size = cur.getInternalSize();
                value = cur;
            }
        }
        return value;
    }
}
