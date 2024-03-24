package top.fireddev.compactmachinesinfinite.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import top.fireddev.compactmachinesinfinite.CompactMachinesInfinite;
import top.fireddev.compactmachinesinfinite.NewMachines;

public class ChineseLanguageProvider extends LanguageProvider {
    public ChineseLanguageProvider(DataGenerator gen) {
        super(gen, CompactMachinesInfinite.MODID, "zh_cn");
    }
    @Override
    protected void addTranslations(){
        this.add(NewMachines.MACHINE_BLOCK_XLARGE.get(), "特大压缩机械");
        this.add(NewMachines.MACHINE_BLOCK_EXTREME.get(), "极端压缩机械");
        this.add(NewMachines.MACHINE_BLOCK_ULTRA.get(), "终极压缩机械");
    }
}
