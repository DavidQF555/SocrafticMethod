package io.github.davidqf555.minecraft.hypotheticals.common;

import io.github.davidqf555.minecraft.hypotheticals.common.registration.EffectRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hypotheticals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class EventBusSubscriber {

    private EventBusSubscriber() {
    }

    @SubscribeEvent
    public static void onLivingSetAttackTarget(LivingSetAttackTargetEvent event) {
        LivingEntity target = event.getTarget();
        if (target != null && target.hasEffect(EffectRegistry.UNTARGETABLE.get())) {
            ((MobEntity) event.getEntity()).setTarget(null);
        }
    }
}
