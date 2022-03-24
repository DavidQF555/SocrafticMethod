package io.github.davidqf555.minecraft.hypotheticals.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class EffectItem extends Item {

    private final Supplier<Effect> effect;
    private final int amplifier;
    private final boolean ambient, visible, showIcon;

    public EffectItem(Supplier<Effect> effect, int amplifier, boolean ambient, boolean visible, boolean showIcon, Properties properties) {
        super(properties);
        this.effect = effect;
        this.amplifier = amplifier;
        this.ambient = ambient;
        this.visible = visible;
        this.showIcon = showIcon;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof LivingEntity && (selected || ((LivingEntity) entity).getOffhandItem().equals(stack))) {
            ((LivingEntity) entity).addEffect(createEffectInstance());
        }
    }

    protected EffectInstance createEffectInstance() {
        return new EffectInstance(effect.get(), 2, amplifier - 1, ambient, visible, showIcon);
    }
}
