package top.fireddev.compactmachinesinfinite;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
        var helper = event.getExistingFileHelper();
        gen.addProvider(event.includeClient(), new ChineseLanguageProvider(gen));
        gen.addProvider(event.includeClient(), new EnglishLanguageProvider(gen));
        gen.addProvider(event.includeClient(), new BlockModelProvider(gen, helper));
        gen.addProvider(event.includeClient(), new ItemModelProvider(gen, helper));
    }
}
