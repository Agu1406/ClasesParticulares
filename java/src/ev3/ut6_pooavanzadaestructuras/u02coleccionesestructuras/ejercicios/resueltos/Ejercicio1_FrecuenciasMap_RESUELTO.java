package ev3.ut6_pooavanzadaestructuras.u02coleccionesestructuras.ejercicios.resueltos;

import java.util.HashMap;
import java.util.Map;

/**
 * Ejercicio resuelto: conteo de frecuencias con mapas.
 */
public class Ejercicio1_FrecuenciasMap_RESUELTO {

    public static Map<String, Integer> contarFrecuencias(String[] datos) {
        Map<String, Integer> frecuencias = new HashMap<>();
        for (String dato : datos) {
            frecuencias.put(dato, frecuencias.getOrDefault(dato, 0) + 1);
        }
        return frecuencias;
    }

    public static void main(String[] args) {
        String[] palabras = {"java", "sql", "java", "poo", "sql", "java"};
        System.out.println(contarFrecuencias(palabras));
    }
}
