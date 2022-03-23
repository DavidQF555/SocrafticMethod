package io.github.davidqf555.minecraft.hypotheticals.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class EffectItem extends Item {

    private final Supplier<EffectInstance>[] effects;

    public EffectItem(Properties properties, Supplier<EffectInstance>... effects) {
        super(properties);
        this.effects = effects;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof LivingEntity && (selected || ((LivingEntity) entity).getOffhandItem().equals(stack))) {
            for (Supplier<EffectInstance> effect : effects) {
                ((LivingEntity) entity).addEffect(effect.get());
            }
        }
    }

}
