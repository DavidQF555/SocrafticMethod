package io.github.davidqf555.minecraft.hypotheticals.common.registration;

import io.github.davidqf555.minecraft.hypotheticals.common.Hypotheticals;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public final class EffectRegistry {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Hypotheticals.MOD_ID);

    public static final RegistryObject<Effect> TRUE_INVISIBILITY = register("true_invisibility", () -> new Effect(EffectType.BENEFICIAL, 1));
    public static final RegistryObject<Effect> UNTARGETABLE = register("untargetable", () -> new Effect(EffectType.BENEFICIAL, 1));

    private EffectRegistry() {
    }

    private static <T extends Effect> RegistryObject<T> register(String name, Supplier<T> effect) {
        return EFFECTS.register(name, effect);
    }
}
