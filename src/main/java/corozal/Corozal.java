package corozal;

import corozal.block.ModBlocks;
import corozal.item.ModItemGroups;
import corozal.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Corozal implements ModInitializer {
	public static final String MOD_ID = "corozal";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Inicializando Corozal - ¡Sabor Latino en Fabric!");

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			// chekeate ete sixseven (id de la loottable como variable sacada del builtin del mc)
			boolean villageRelated = key.identifier().getPath().contains("village");
			if (villageRelated) {
				LootPool.Builder poolBuilder = LootPool.lootPool().add(LootItem.lootTableItem(ModItems.MAIZ_SEMILLA).setWeight(10));

				tableBuilder.withPool(poolBuilder);
				tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.YUCA_SEMILLA).setWeight(10)));
			}
		});
	}
}