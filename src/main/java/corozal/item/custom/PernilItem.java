package corozal.item.custom;

import corozal.Corozal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class PernilItem extends Item {
    public PernilItem() {
        super(
        new Item.Properties()
        .food(new FoodProperties.Builder()
        .nutrition(6)
        .saturationModifier(0.8f)
        .build()
        )
        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "pernil")))
        );
    }
}
