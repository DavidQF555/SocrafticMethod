package io.github.davidqf555.minecraft.socraftic_method.common;

import io.github.davidqf555.minecraft.socraftic_method.common.registration.MobEffectRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SocrafticMethod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class EventBusSubscriber {

    private EventBusSubscriber() {
    }

    @SubscribeEvent
    public static void onLivingSetAttackTarget(LivingSetAttackTargetEvent event) {
        LivingEntity target = event.getTarget();
        if (target != null && target.hasEffect(MobEffectRegistry.NO_CONSEQUENCES.get())) {
            ((Mob) event.getEntity()).setTarget(null);
        }
    }
}
