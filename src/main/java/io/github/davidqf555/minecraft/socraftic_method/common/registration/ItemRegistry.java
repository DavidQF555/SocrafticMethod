package io.github.davidqf555.minecraft.socraftic_method.common.registration;

import io.github.davidqf555.minecraft.socraftic_method.common.SocrafticMethod;
import io.github.davidqf555.minecraft.socraftic_method.common.items.EffectItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SocrafticMethod.MOD_ID);

    public static final RegistryObject<EffectItem> GYGES_RING = register("gyges_ring", () -> new EffectItem(MobEffectRegistry.NO_CONSEQUENCES, 1, true, false, true, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(CreativeModeTab.TAB_TOOLS)));

    private ItemRegistry() {
    }

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

}
