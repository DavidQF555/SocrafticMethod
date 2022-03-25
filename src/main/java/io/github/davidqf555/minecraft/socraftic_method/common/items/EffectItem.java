package io.github.davidqf555.minecraft.socraftic_method.common.items;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class EffectItem extends Item {

    private final Supplier<MobEffect> effect;
    private final int amplifier;
    private final boolean ambient, visible, showIcon;

    public EffectItem(Supplier<MobEffect> effect, int amplifier, boolean ambient, boolean visible, boolean showIcon, Properties properties) {
        super(properties);
        this.effect = effect;
        this.amplifier = amplifier;
        this.ambient = ambient;
        this.visible = visible;
        this.showIcon = showIcon;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (entity instanceof LivingEntity && (selected || ((LivingEntity) entity).getOffhandItem().equals(stack))) {
            ((LivingEntity) entity).addEffect(createEffectInstance());
        }
    }

    protected MobEffectInstance createEffectInstance() {
        return new MobEffectInstance(effect.get(), 2, amplifier - 1, ambient, visible, showIcon);
    }
}
