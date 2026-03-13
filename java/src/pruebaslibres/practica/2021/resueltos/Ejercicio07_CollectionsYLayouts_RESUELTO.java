package pruebaslibres.practica.resueltos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio07_CollectionsYLayouts_RESUELTO {

    public static void main(String[] args) {
        ejemploSetSinRepetidos();
        ejemploArrayListAddSize();
        comentarLayoutsSwing();
    }

    private static void ejemploSetSinRepetidos() {
        Set<String> conjunto = new HashSet<>();
        conjunto.add("Coche");
        conjunto.add("Moto");
        conjunto.add("Coche"); // Repetido, no se añade de nuevo.

        System.out.println("Contenido del Set (sin repetidos): " + conjunto);
    }

    private static void ejemploArrayListAddSize() {
        List<String> concesionario = new ArrayList<>();
        concesionario.add("Coche1");
        concesionario.add("Coche2");

        String miVehiculo = "CocheNuevo";
        concesionario.add(concesionario.size(), miVehiculo);

        System.out.println("ArrayList tras add(size(), miVehiculo): " + concesionario);
    }

    private static void comentarLayoutsSwing() {
        /*
         * Supongamos una ventana Swing con:
         * - Una barra superior con botones: FlowLayout.
         * - Un área central con formulario: GridLayout (filas y columnas).
         * - Un panel lateral con una lista: BorderLayout.EAST en el contenedor principal.
         *
         * Para una aplicación JavaFX:
         * - La vista se define en un fichero .fxml.
         * - Los estilos se definen en un fichero .css.
         */
        System.out.println("Comentarios sobre layouts escritos en el código (ver método comentarLayoutsSwing).");
    }
}

