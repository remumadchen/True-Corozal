package corozal.item;

import com.google.common.collect.ImmutableList;
import corozal.Corozal;
import corozal.item.custom.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;

import java.util.List;

public class ModItems {

    private static final ImmutableList.Builder<Item> entriesBuilder = ImmutableList.builder();
    private static List<Item> entries;
    //ICONO
    public static final Item ICONO = registerItem("icono", new IconoItem(), false);

    // COMIDAS
    public static final Item AREPA = registerItem("arepa", new ArepaItem());
    public static final Item BOLON = registerItem("bolon", new BolonItem());
    public static final Item MAIZ = registerItem("maiz", new MaizItem());
    public static final Item CUCA_DORADA = registerItem("cuca_dorada", new CucaDoradaItem());
    public static final Item CUCA = registerItem("cuca", new CucaItem());
    public static final Item CACHAPA = registerItem("cachapa", new CachapaItem());
    public static final Item YUCA_FRITA = registerItem("yuca_frita", new YucaFritaItem());
    public static final Item SALCHIPAPA = registerItem("salchipapa", new SalchipapaItem());
    public static final Item PASTELITO = registerItem("pastelito", new PastelitoItem());
    public static final Item EMPANADA = registerItem("empanada", new EmpanadaItem());
    public static final Item HALLACA = registerItem("hallaca", new HallacaItem());
    public static final Item PAN_ALMIDON = registerItem("pan_almidon", new PanAlmidonItem());
    public static final Item PERNIL = registerItem("pernil", new PernilItem());
    public static final Item TEQUENO = registerItem("tequeno", new TequenoItem());
    public static final Item ENCEBOLLADO = registerItem("encebollado", new EncebolladoItem());
    public static final Item PEPITO = registerItem("pepito", new PepitoItem());
    public static final Item MONDONGO = registerItem("mondongo", new MondongoItem());
    public static final Item PAPA_RELLENA = registerItem("papa_rellena", new PapaRellenaItem());
    public static final Item PAPA_RELLENA_2 = registerItem("papa_rellena_2", new PapaRellena2Item());
    public static final Item CHOCLO_MAYO = registerItem("choclo_mayo", new ChocloMayoItem());

    /*
    Pociones / Bebidas
     */

    /**
     * Las maltas
     */
    public static final Item MALTA = registerItem("malta", new MaltaItem());

    // COMIDAS NO COMESTIBLES
    public static final Item PANELA = registerItem("panela", new PanelaItem());
    public static final Item YUCA = registerItem("yuca", new YucaItem());
    public static final Item HARINA_TRIGO = registerItem("harina_trigo", new HarinaTrigoItem());
    public static final Item HARINA_PAN = registerItem("harina_pan", new HarinaPanItem());
    public static final Item ACEITE_MAZEITE = registerItem("aceite_mazeite", new AceiteMazeiteItem());
    public static final Item PEDAZO_PEPITO = registerItem("pedazo_pepito", new PedazoPepitoItem());
    public static final Item PLATANO = registerItem("platano", new PlatanoItem());
    // SEMILLAS
    public static final Item MAIZ_SEMILLA = registerItem("semilla_maiz", new SemillaMaizItem());
    public static final Item YUCA_SEMILLA = registerItem("semilla_yuca", new SemillaYucaItem());
    public static final Item PLATANO_SEMILLA = registerItem("semilla_platano", new SemillaPlatanoItem());

    /**
     * Registra un item en el juego y lo ingresa a la tab de creativo
     * @return El item registrado
     */
    private static Item registerItem(String name, Item item) {
        return registerItem(name, item, true);
    }
    /**
     * Registra un item en el juego, y en la tab de creativo si addToEntries es true
     * @return El item registrado
     */
    private static Item registerItem(String name, Item item, boolean addToEntries) {
        Item itemRegister = Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Corozal.MOD_ID, name), item);

        if (addToEntries) {
            entriesBuilder.add(itemRegister);
        }
        return itemRegister;
    }


    /**
     * Registra los Items de los mods
     */
    public static void registerModItems() {
        Corozal.LOGGER.info("Registrando Mod Items para " + Corozal.MOD_ID);

        entries = entriesBuilder.build();
    }

    public static List<Item> getItems() {
        return entries;
    }
}