package io.github.davidqf555.minecraft.hypotheticals.common.items;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Supplier;

public class AdditionLootModifier extends LootModifier {

    private final List<Supplier<ItemStack>> additions;

    protected AdditionLootModifier(List<Supplier<ItemStack>> additions, ILootCondition[] conditionsIn) {
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
        public AdditionLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] conditions) {
            return new AdditionLootModifier(additions, conditions);
        }

        @Override
        public JsonObject write(AdditionLootModifier instance) {
            return makeConditions(instance.conditions);
        }
    }
}
