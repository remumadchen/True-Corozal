package corozal.block.crops;

import corozal.Corozal;
import corozal.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class YucaBlock extends CropBlock {

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
    Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
    };

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.YUCA_SEMILLA;
    }

    @Override
    public IntegerProperty getAgeProperty() { return AGE; }

    @Override
    public int getAge(BlockState state) { return state.getValue(AGE); }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return SHAPE_BY_AGE[this.getAge(state)]; }

    @Override
    public int getMaxAge() { return MAX_AGE; }

    public YucaBlock() {
        super(BlockBehaviour.Properties.of()
        .mapColor(MapColor.PLANT)
        .randomTicks()
        .instabreak()
        .sound(SoundType.CROP)
        .pushReaction(PushReaction.DESTROY)
        .noCollision()
        .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "yuca")))
        );
    }
}