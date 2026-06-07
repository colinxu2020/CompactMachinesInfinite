package top.fireddev.compactmachinesinfinite.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.fireddev.compactmachinesinfinite.CompactMachinesInfinite;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CompactMachinesInfinite.MODID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        withExistingParent("machine_xlarge", modLoc("block/machine/machine_xlarge"));
        withExistingParent("machine_extreme", modLoc("block/machine/machine_extreme"));
        withExistingParent("machine_ultra", modLoc("block/machine/machine_ultra"));
    }
}
