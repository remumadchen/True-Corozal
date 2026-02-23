package corozal.item.custom;


import corozal.Corozal;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class CucaDoradaItem extends Item {
    public static final Consumable REGENERATION_FOOD_CONSUMABLE_COMPONENT = Consumables.defaultFood()
    // The duration is in ticks, 20 ticks = 1 second
    .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 3 * 20, 4), 1.0f))
    .build();

    public static final FoodProperties REGENERATION_FOOD_COMPONENT = new FoodProperties.Builder()
    .nutrition(8)
    .saturationModifier(0.8f)
    .build();



    public CucaDoradaItem() {
        super(
            new Item.Properties().food(
                REGENERATION_FOOD_COMPONENT,
                REGENERATION_FOOD_CONSUMABLE_COMPONENT
            )
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "cuca_dorada")))
        );
    }
}
