package io.github.davidqf555.minecraft.socraftic_method.client;

import io.github.davidqf555.minecraft.socraftic_method.common.SocrafticMethod;
import io.github.davidqf555.minecraft.socraftic_method.common.registration.MobEffectRegistry;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SocrafticMethod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class EventBusSubscriber {

    private EventBusSubscriber() {
    }

    @SubscribeEvent
    public static <T extends LivingEntity, M extends EntityModel<T>> void preRenderLiving(RenderLivingEvent.Pre<T, M> event) {
        if (event.getEntity().hasEffect(MobEffectRegistry.NO_CONSEQUENCES.get())) {
            event.setCanceled(true);
        }
    }
}
