package corozal.item.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;

import corozal.block.ModBlocks;
import corozal.Corozal;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;

public class SemillaMaizItem extends BlockItem {
    public SemillaMaizItem() {
        super(
            ModBlocks.MAIZ,
            new Item.Properties().setId(
                ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "semilla_maiz"))
            ).useBlockDescriptionPrefix()
        );
    }

    @Override
    protected boolean canPlace(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        if( blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().below()).is(ModBlocks.MAIZ) ) {
            return false;
        }
        return super.canPlace(blockPlaceContext, blockState);
    }
}