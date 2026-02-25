package corozal.item.custom;

import corozal.Corozal;
import corozal.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;

public class SemillaPlatanoItem extends BlockItem {
    public SemillaPlatanoItem() {
        super(ModBlocks.PLATANO,
        new Item.Properties().setId(
        ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "semilla_platano"))
        ).useBlockDescriptionPrefix()
        );
    }
        @Override
        protected boolean canPlace(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        if( blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().below()).is(ModBlocks.PLATANO) ) {
            return false;
        }
        return super.canPlace(blockPlaceContext, blockState);
    }
}
