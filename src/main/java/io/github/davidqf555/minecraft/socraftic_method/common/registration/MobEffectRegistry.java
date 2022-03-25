package io.github.davidqf555.minecraft.socraftic_method.common.registration;

import io.github.davidqf555.minecraft.socraftic_method.common.SocrafticMethod;
import io.github.davidqf555.minecraft.socraftic_method.common.effects.InvisibilityEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class MobEffectRegistry {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SocrafticMethod.MOD_ID);

    public static final RegistryObject<MobEffect> NO_CONSEQUENCES = register("no_consequences", () -> new InvisibilityEffect(MobEffectCategory.BENEFICIAL, 1));

    private MobEffectRegistry() {
    }

    private static <T extends MobEffect> RegistryObject<T> register(String name, Supplier<T> effect) {
        return EFFECTS.register(name, effect);
    }
}
