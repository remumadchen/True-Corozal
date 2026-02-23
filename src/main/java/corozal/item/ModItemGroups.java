package corozal.item;

import corozal.Corozal;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import java.util.Random;

public class ModItemGroups {

    public static final CreativeModeTab COROZAL_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Corozal.MOD_ID, "corozal_items"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemgroup.corozal"))
                    // Usaremos la Arepa como icono (por ahora usamos un ítem genérico hasta que
                    // registremos la arepa)
                    .icon(() -> {
                        Random random = new Random();
                        if(random.nextInt(10) == 0)
                        {
                            return new ItemStack(ModItems.ICONO);
                        }
                        return new ItemStack(ModItems.getItems().get(random.nextInt( ModItems.getItems().size()))); 
                    })
                    .displayItems((displayParameters, output) -> {
                        // Aquí vamos a iterar sobre todos los ítems propios y añadirlos a la pestaña
                       output.acceptAll(ModItems.getItems().stream().map(v->new ItemStack(v)).toList());
                    })
                    .build());

    public static void registerItemGroups() {
        Corozal.LOGGER.info("Registrando Item Groups para " + Corozal.MOD_ID);
    }
}
