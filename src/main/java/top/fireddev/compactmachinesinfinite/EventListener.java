package top.fireddev.compactmachinesinfinite;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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
            event.setCanceled(true);
        }
    }

}
