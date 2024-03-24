package top.fireddev.compactmachinesinfinite.datagen;

import dev.compactmods.machines.api.room.RoomSize;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.fireddev.compactmachinesinfinite.CompactMachinesInfinite;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CompactMachinesInfinite.MODID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        withExistingParent("machine_xlarge", modLoc("block/machine/machine_xlarge"));
        withExistingParent("machine_extreme", modLoc("block/machine/machine_extreme"));
        withExistingParent("machine_ultra", modLoc("block/machine/machine_ultra"));
    }
}
