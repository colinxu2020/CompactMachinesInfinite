package top.fireddev.compactmachinesinfinite;

import dev.compactmods.machines.client.CreativeTabs;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.fireddev.compactmachinesinfinite.datagen.BlockModelProvider;
import top.fireddev.compactmachinesinfinite.datagen.ChineseLanguageProvider;
import top.fireddev.compactmachinesinfinite.datagen.EnglishLanguageProvider;
import top.fireddev.compactmachinesinfinite.datagen.ItemModelProvider;

public class EventListener {
    @SubscribeEvent()
    public void onEntityJoinWorld(EntityJoinLevelEvent event) {
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }
        if (event.getEntity() instanceof Player) {
            return;
        }
        if (event.getLevel().isClientSide) {
            return;
        }
        if (!Config.AVOID_MOB_SPAWN.get())return;

        if (event.getLevel().dimensionTypeId().location().toString().equals("compactmachines:compact_world")){
            CompactMachinesInfinite.LOGGER.debug("AVOID SPAWN:" + event.getEntity().toString());
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event){
        var gen = event.getGenerator();
        var output = gen.getPackOutput();
        var helper = event.getExistingFileHelper();
        gen.addProvider(event.includeClient(), new ChineseLanguageProvider(output));
        gen.addProvider(event.includeClient(), new EnglishLanguageProvider(output));
        gen.addProvider(event.includeClient(), new BlockModelProvider(output, helper));
        gen.addProvider(event.includeClient(), new ItemModelProvider(output, helper));
    }

    @SubscribeEvent
    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (!event.getTabKey().location().equals(CreativeTabs.MAIN_RL)) {
            return;
        }

        event.accept(NewMachines.MACHINE_BLOCK_ITEM_XLARGE);
        event.accept(NewMachines.MACHINE_BLOCK_ITEM_EXTREME);
        event.accept(NewMachines.MACHINE_BLOCK_ITEM_ULTRA);
    }
}
