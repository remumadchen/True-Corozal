package corozal.item.custom;

import corozal.Corozal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ChocloMayoItem extends Item {
    public ChocloMayoItem() {
        super(
        new Item.Properties()
        .food(new FoodProperties.Builder()
        .nutrition(5)
        .saturationModifier(0.5f)
        .build()
        )
        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "choclo_mayo")))
        );
    }
}
