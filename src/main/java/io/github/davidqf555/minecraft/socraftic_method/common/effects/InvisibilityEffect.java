package io.github.davidqf555.minecraft.socraftic_method.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class InvisibilityEffect extends Effect {

    public InvisibilityEffect(EffectType type, int color) {
        super(type, color);
    }

    @Override
    public void applyEffectTick(LivingEntity target, int amp) {
        target.addEffect(new EffectInstance(Effects.INVISIBILITY, 2, 0, true, false, false));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amp) {
        return true;
    }
}
