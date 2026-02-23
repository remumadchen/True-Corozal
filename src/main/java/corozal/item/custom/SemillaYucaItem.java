package corozal.item.custom;

import corozal.Corozal;
import corozal.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class SemillaYucaItem extends BlockItem {
    public SemillaYucaItem() {
        super(
            ModBlocks.YUCA,
        new Item.Properties().setId(
        ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "semilla_yuca"))
                    ).useBlockDescriptionPrefix()
            );
    }
}
