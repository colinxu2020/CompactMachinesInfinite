package top.fireddev.compactmachinesinfinite.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import top.fireddev.compactmachinesinfinite.CompactMachinesInfinite;
import top.fireddev.compactmachinesinfinite.NewMachines;

public class EnglishLanguageProvider extends LanguageProvider {
    public EnglishLanguageProvider(PackOutput output) {
        super(output, CompactMachinesInfinite.MODID, "en_us");
    }
    @Override
    protected void addTranslations(){
        this.add(NewMachines.MACHINE_BLOCK_XLARGE.get(), "XLarge Compact Machine");
        this.add(NewMachines.MACHINE_BLOCK_EXTREME.get(), "Extreme Compact Machine");
        this.add(NewMachines.MACHINE_BLOCK_ULTRA.get(), "Ultra Compact Machine");
    }
}
