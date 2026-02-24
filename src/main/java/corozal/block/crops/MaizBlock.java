package corozal.block.crops;

import corozal.Corozal;
import corozal.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class MaizBlock extends CropBlock {
    public static final int FIRST_STAGE_MAX_AGE = 3;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 5);

    /**
     * Las colisiones de los cultivos
     * Dependen de la cantidad de estados que tiene tu cultivo!
     */
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
    Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
    };

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (serverLevel.getRawBrightness(blockPos, 0) < 9) {
            return;
        }

        int currentAge = this.getAge(blockState);
        int nextAge = currentAge + 1;

        if(currentAge == FIRST_STAGE_MAX_AGE + 1 || currentAge == getMaxAge()) {
            return;
        }

        if (serverLevel.isEmptyBlock(blockPos.above()) && nextAge == FIRST_STAGE_MAX_AGE) { // nueva logica
            serverLevel.setBlock(blockPos, getStateForAge(FIRST_STAGE_MAX_AGE + 1), 2);
            serverLevel.setBlock(blockPos.above(), getStateForAge(FIRST_STAGE_MAX_AGE + 2), 2);
            return;
        }

        serverLevel.setBlock(blockPos, getStateForAge(nextAge), 2);
    }

    // inicio crecimiento por bonemeal
    @Override
    public void growCrops(Level level, BlockPos blockPos, BlockState blockState) {
        int nextAge = Math.min(this.getMaxAge(), this.getAge(blockState) + this.getBonemealAgeIncrease(level));

        if (nextAge == FIRST_STAGE_MAX_AGE) {
            level.setBlock(blockPos.above(), getStateForAge(nextAge), 2);
        } else {
            level.setBlock(blockPos, this.getStateForAge(nextAge - 1), 2);
        }

        level.setBlock(blockPos, this.getStateForAge(nextAge), 3);
    }
    // final crecimiento por bonemeal

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return super.mayPlaceOn(blockState, blockGetter, blockPos) ||
        (
        blockState.is(this) &&
        blockState.getValue(AGE) == FIRST_STAGE_MAX_AGE + 1
        );
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if( level.getBlockState(blockPos.below()).is(this) ) {
            level.destroyBlock(blockPos.below(), true, player);
        }

        return super.playerWillDestroy(level, blockPos, blockState, player);
    }

    @Override
    public int getMaxAge() {
        return FIRST_STAGE_MAX_AGE + 2;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.MAIZ_SEMILLA;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }

    public MaizBlock() {
        super(
        BlockBehaviour.Properties.of()
        .mapColor(MapColor.PLANT)
        .randomTicks()
        .instabreak()
        .sound(SoundType.CROP)
        .pushReaction(PushReaction.DESTROY)
        .noCollision()
        .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "maiz")))
        );
    }
}