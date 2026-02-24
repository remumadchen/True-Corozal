/*package corozal;

import corozal.block.ModBlocks;
import corozal.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;

public class CorozalModelProvider extends FabricModelProvider {
    public CorozalModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createCropBlock(ModBlocks.MAIZ, CropBlock.AGE, 0, 1, 2, 3, 4, 5);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.MAIZ, ModelTemplates.FLAT_ITEM);
    }
}
 */