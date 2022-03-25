package io.github.davidqf555.minecraft.socraftic_method.common;

import io.github.davidqf555.minecraft.socraftic_method.common.registration.EffectRegistry;
import io.github.davidqf555.minecraft.socraftic_method.common.registration.ItemRegistry;
import io.github.davidqf555.minecraft.socraftic_method.common.registration.LootModifierRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("socraftic_method")
public class SocrafticMethod {

    public static final String MOD_ID = "socraftic_method";

    public SocrafticMethod() {
        addRegistries(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addRegistries(IEventBus bus) {
        EffectRegistry.EFFECTS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        LootModifierRegistry.SERIALIZERS.register(bus);
    }
}