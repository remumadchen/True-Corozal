package corozal.item.custom;

import corozal.Corozal;
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

public class CucaItem extends Item{

    public static final Consumable REGENERATION_FOOD_CONSUMABLE_COMPONENT = Consumables.defaultFood()
		// The duration is in ticks, 20 ticks = 1 second
	    .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 2 * 20, 0), 0.3f))
		.build();
    
    public static final FoodProperties REGENERATION_FOOD_COMPONENT = new FoodProperties.Builder()
		.nutrition(3)
        .saturationModifier(0.3f)
		.build();

    public CucaItem() {
        super(
            new Item.Properties()
            .food( REGENERATION_FOOD_COMPONENT, REGENERATION_FOOD_CONSUMABLE_COMPONENT )
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "cuca")))
        );
    }
}
