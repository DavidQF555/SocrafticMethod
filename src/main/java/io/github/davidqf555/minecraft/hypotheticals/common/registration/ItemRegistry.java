package io.github.davidqf555.minecraft.hypotheticals.common.registration;

import io.github.davidqf555.minecraft.hypotheticals.common.Hypotheticals;
import io.github.davidqf555.minecraft.hypotheticals.common.items.EffectItem;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public final class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Hypotheticals.MOD_ID);

    public static final RegistryObject<EffectItem> GYGES_RING = register("gyges_ring", () -> new EffectItem(EffectRegistry.NO_CONSEQUENCES::get, 1, true, false, true, new Item.Properties().stacksTo(1)));

    private ItemRegistry() {
    }

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

}
