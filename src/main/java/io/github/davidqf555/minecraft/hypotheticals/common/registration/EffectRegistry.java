package io.github.davidqf555.minecraft.hypotheticals.common.registration;

import io.github.davidqf555.minecraft.hypotheticals.common.Hypotheticals;
import io.github.davidqf555.minecraft.hypotheticals.common.effects.InvisibilityEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public final class EffectRegistry {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Hypotheticals.MOD_ID);

    public static final RegistryObject<Effect> NO_CONSEQUENCES = register("no_consequences", () -> new InvisibilityEffect(EffectType.BENEFICIAL, 1));

    private EffectRegistry() {
    }

    private static <T extends Effect> RegistryObject<T> register(String name, Supplier<T> effect) {
        return EFFECTS.register(name, effect);
    }
}
