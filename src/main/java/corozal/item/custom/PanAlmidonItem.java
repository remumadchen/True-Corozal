package corozal.item.custom;

import corozal.Corozal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class PanAlmidonItem extends Item {
    public PanAlmidonItem() {
        super(
        new Item.Properties()
        .food(new FoodProperties.Builder()
        .nutrition(3)
        .saturationModifier(0.2f)
        .build()
        )
        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "pan_almidon")))
        );
    }
}
