package top.fireddev.compactmachinesinfinite.mixin;

import dev.compactmods.machines.api.room.RoomSize;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.util.StringRepresentable;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import top.fireddev.compactmachinesinfinite.Config;

@Mixin(value = RoomSize.class, remap = false)
public abstract class RoomSizeMixin implements StringRepresentable{
    @Final
    @Shadow
    private String name;

    /**
     * @author Colinxu2020
     * @reason Support Custom Compact Machine Size
     */
    @Overwrite
    public int getInternalSize() {
        return Config.getRoomSize(this.name);
    }

    /**
     * @author Colinxu2020
     * @reason Support Custom Compact Machine Size
     */
    @Overwrite
    public static RoomSize maximum() {
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

    /**
     * @author Colinxu2020
     * @reason Support Custom Compact Machine Size
     */
    @Overwrite
    public AABB getBounds(BlockPos center) {
        AABB bounds = new AABB(center);
        return bounds.inflate(Math.floorDiv(this.getInternalSize(), 2));
    }
}
