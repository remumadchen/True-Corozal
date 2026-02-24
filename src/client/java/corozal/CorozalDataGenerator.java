package corozal;

import corozal.block.crops.MaizBlock;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.concurrent.CompletableFuture;

public class CorozalDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CorozalModBlockLootTableProvider::new);

    }

    public static class CorozalModBlockLootTableProvider extends FabricBlockLootTableProvider {
        public CorozalModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(dataOutput, registryLookup);
        }


        @Override
        public void generate() {
            LootItemCondition.Builder isGrown = LootItemBlockStatePropertyCondition.hasBlockStateProperties(corozal.block.ModBlocks.MAIZ)
                .setProperties(net.minecraft.advancements.criterion.StatePropertiesPredicate.Builder.properties()
                .hasProperty(MaizBlock.AGE, 5));

            this.add(corozal.block.ModBlocks.MAIZ, this.createCropDrops(
                corozal.block.ModBlocks.MAIZ,           // vloke
                corozal.item.ModItems.MAIZ,             // produkto
                corozal.item.ModItems.MAIZ_SEMILLA,     // cemiya
                isGrown                                 // kondision
            ));
        }
    }
}