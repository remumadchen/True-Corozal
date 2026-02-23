package corozal.item.custom;

import corozal.Corozal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;

public class IconoItem extends Item {
    public IconoItem() {
        super(
            new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "icono")))
        );
    }
}
