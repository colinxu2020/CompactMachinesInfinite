package top.fireddev.compactmachinesinfinite;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CompactMachinesInfinite.MODID)
public class CompactMachinesInfinite
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "compactmachinesinfinite";
    public CompactMachinesInfinite()
    {
        ModLoadingContext ctx = ModLoadingContext.get();
        ctx.registerConfig(ModConfig.Type.SERVER, Config.CONFIG);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
