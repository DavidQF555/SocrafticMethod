package io.github.davidqf555.minecraft.socraftic_method.common.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class InvisibilityEffect extends MobEffect {

    public InvisibilityEffect(MobEffectCategory type, int color) {
        super(type, color);
    }

    @Override
    public void applyEffectTick(LivingEntity target, int amp) {
        target.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2, 0, true, false, false));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amp) {
        return true;
    }
}
