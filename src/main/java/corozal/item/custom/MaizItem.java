package corozal.item.custom;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
import corozal.Corozal;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;


public class MaizItem extends Item {
     public MaizItem() {
        super(
            new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationModifier(0.2f)
                .build()
                )
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "maiz")))
        );
    }
}