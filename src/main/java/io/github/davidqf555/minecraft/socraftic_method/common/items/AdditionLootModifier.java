package io.github.davidqf555.minecraft.socraftic_method.common.items;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Supplier;

public class AdditionLootModifier extends LootModifier {

    private final List<Supplier<ItemStack>> additions;

    protected AdditionLootModifier(List<Supplier<ItemStack>> additions, LootItemCondition[] conditionsIn) {
        super(conditionsIn);
        this.additions = additions;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        for (Supplier<ItemStack> addition : additions) {
            generatedLoot.add(addition.get());
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<AdditionLootModifier> {

        private final List<Supplier<ItemStack>> additions;

        public Serializer(List<Supplier<ItemStack>> additions) {
            this.additions = additions;
        }

        @Override
        public AdditionLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] conditions) {
            return new AdditionLootModifier(additions, conditions);
        }

        @Override
        public JsonObject write(AdditionLootModifier instance) {
            return makeConditions(instance.conditions);
        }
    }
}
