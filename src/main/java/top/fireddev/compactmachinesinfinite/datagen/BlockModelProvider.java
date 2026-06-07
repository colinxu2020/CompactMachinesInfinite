package top.fireddev.compactmachinesinfinite.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.fireddev.compactmachinesinfinite.CompactMachinesInfinite;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import top.fireddev.compactmachinesinfinite.NewMachines;

public class BlockModelProvider extends BlockStateProvider {
    public BlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CompactMachinesInfinite.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        var mod = models().cubeAll("block/machine/machine_xlarge",
                modLoc("block/machine/machine_xlarge"));
        simpleBlock(NewMachines.MACHINE_BLOCK_XLARGE.get(), ConfiguredModel.builder().modelFile(mod).build());
        mod = models().cubeAll("block/machine/machine_extreme",
                modLoc("block/machine/machine_extreme"));
        simpleBlock(NewMachines.MACHINE_BLOCK_EXTREME.get(), ConfiguredModel.builder().modelFile(mod).build());
        mod = models().cubeAll("block/machine/machine_ultra",
                modLoc("block/machine/machine_ultra"));
        simpleBlock(NewMachines.MACHINE_BLOCK_ULTRA.get(), ConfiguredModel.builder().modelFile(mod).build());
    }
}
