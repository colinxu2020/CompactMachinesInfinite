package top.fireddev.compactmachinesinfinite;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CompactMachinesInfinite.MODID)
public class CompactMachinesInfinite
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "compactmachinesinfinite";
    public static final Logger LOGGER = LogManager.getLogger();

    public CompactMachinesInfinite()
    {
        ModLoadingContext ctx = ModLoadingContext.get();
        ctx.registerConfig(ModConfig.Type.COMMON, Config.CONFIG);

        MinecraftForge.EVENT_BUS.register(new EventListener());
    }
}
