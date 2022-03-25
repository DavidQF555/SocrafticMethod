package io.github.davidqf555.minecraft.socraftic_method.common.registration;

import com.google.common.collect.ImmutableList;
import io.github.davidqf555.minecraft.socraftic_method.common.SocrafticMethod;
import io.github.davidqf555.minecraft.socraftic_method.common.items.AdditionLootModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public final class LootModifierRegistry {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, SocrafticMethod.MOD_ID);

    public static final RegistryObject<AdditionLootModifier.Serializer> GYGES_RING = register("gyges_ring", () -> new AdditionLootModifier.Serializer(ImmutableList.of(() -> ItemRegistry.GYGES_RING.get().getDefaultInstance())));

    private LootModifierRegistry() {
    }

    private static <T extends GlobalLootModifierSerializer<?>> RegistryObject<T> register(String name, Supplier<T> serializer) {
        return SERIALIZERS.register(name, serializer);
    }
}
