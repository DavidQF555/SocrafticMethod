package io.github.davidqf555.minecraft.hypotheticals.common;

import io.github.davidqf555.minecraft.hypotheticals.common.registration.EffectRegistry;
import io.github.davidqf555.minecraft.hypotheticals.common.registration.ItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("hypotheticals")
public class Hypotheticals {

    public static final String MOD_ID = "hypotheticals";

    public Hypotheticals() {
        addRegistries(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addRegistries(IEventBus bus) {
        EffectRegistry.EFFECTS.register(bus);
        ItemRegistry.ITEMS.register(bus);
    }
}