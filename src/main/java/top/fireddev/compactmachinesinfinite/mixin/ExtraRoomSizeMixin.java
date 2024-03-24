package top.fireddev.compactmachinesinfinite.mixin;

import dev.compactmods.machines.api.room.RoomSize;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.fireddev.compactmachinesinfinite.CompactMachinesInfinite;
import top.fireddev.compactmachinesinfinite.RoomSizeHelper;

import java.util.ArrayList;
import java.util.Arrays;

// based under LudoCrypt/Noteblock-Expansion-Forge
@Mixin(value = RoomSize.class, remap = false)
public abstract class ExtraRoomSizeMixin {
    @Shadow
    @Final
    @Mutable
    private static RoomSize[] $VALUES;

    @Invoker("<init>")
    public static RoomSize compactmachinesinfinite$invokeInit(String internalName, int internalId, String name, int size){
        throw new AssertionError("mixin failed to apply");
    }
    @Unique
    private static RoomSize compactmachinesinfinite$addVariant(String internalName, String name, int size){
        assert ExtraRoomSizeMixin.$VALUES != null;
        ArrayList<RoomSize> variants = new ArrayList<>(Arrays.asList(ExtraRoomSizeMixin.$VALUES));
        RoomSize roomSize = compactmachinesinfinite$invokeInit(internalName, variants.get(variants.size() - 1).ordinal() + 1, name, size);
        variants.add(roomSize);
        ExtraRoomSizeMixin.$VALUES = variants.toArray(new RoomSize[0]);
        RoomSizeHelper.set(name, roomSize);
        return roomSize;
    }
    @Unique
    private static final RoomSize compactmachinesinfinite$XLARGE = compactmachinesinfinite$addVariant("XLARGE", "xlarge", 15);
    @Unique
    private static final RoomSize compactmachinesinfinite$EXTREME = compactmachinesinfinite$addVariant("EXTREME", "extreme", 17);
    @Unique
    private static final RoomSize compactmachinesinfinite$ULTRA = compactmachinesinfinite$addVariant("ULTRA", "ultra", 19);

    @Inject(method = "getFromSize", at = @At("HEAD"), cancellable = true)
    private static void getFromSizeInject(String size, CallbackInfoReturnable<RoomSize> cir){
        CompactMachinesInfinite.LOGGER.info("getting size "+size);
        switch(size) {
            case "xlarge":
                cir.setReturnValue(compactmachinesinfinite$XLARGE);
            case "extreme":
                cir.setReturnValue(compactmachinesinfinite$EXTREME);
            case "ultra":
                cir.setReturnValue(compactmachinesinfinite$ULTRA);
        }
    }
}
