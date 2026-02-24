package corozal.item.custom;

import corozal.Corozal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class YucaItem extends Item
{
    public YucaItem()
    {
        super(
        new Item.Properties(
        )
        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "yuca")))
        );
    }
}
