package io.github.davidqf555.minecraft.hypotheticals.client;

import io.github.davidqf555.minecraft.hypotheticals.common.Hypotheticals;
import io.github.davidqf555.minecraft.hypotheticals.common.registration.EffectRegistry;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hypotheticals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class EventBusSubscriber {

    private EventBusSubscriber() {
    }

    @SubscribeEvent
    public static <T extends LivingEntity, M extends EntityModel<T>> void preRenderLiving(RenderLivingEvent.Pre<T, M> event) {
        if (event.getEntity().hasEffect(EffectRegistry.TRUE_INVISIBILITY.get())) {
            event.setCanceled(true);
        }
    }
}
