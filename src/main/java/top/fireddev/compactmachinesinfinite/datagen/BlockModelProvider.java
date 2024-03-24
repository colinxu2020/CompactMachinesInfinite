package top.fireddev.compactmachinesinfinite.datagen;

import dev.compactmods.machines.machine.CompactMachineBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.fireddev.compactmachinesinfinite.CompactMachinesInfinite;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import top.fireddev.compactmachinesinfinite.RoomSizeHelper;

public class BlockModelProvider extends BlockStateProvider {
    public BlockModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CompactMachinesInfinite.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        var mod = models().cubeAll("block/machine/machine_xlarge",
                modLoc("block/machine/machine_xlarge"));
        simpleBlock(CompactMachineBlock.getBySize(RoomSizeHelper.get("xlarge")), ConfiguredModel.builder().modelFile(mod).build());
        mod = models().cubeAll("block/machine/machine_extreme",
                modLoc("block/machine/machine_extreme"));
        simpleBlock(CompactMachineBlock.getBySize(RoomSizeHelper.get("extreme")), ConfiguredModel.builder().modelFile(mod).build());
        mod = models().cubeAll("block/machine/machine_ultra",
                modLoc("block/machine/machine_ultra"));
        simpleBlock(CompactMachineBlock.getBySize(RoomSizeHelper.get("ultra")), ConfiguredModel.builder().modelFile(mod).build());
    }
}
