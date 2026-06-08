package ev3.ut6_pooavanzadaestructuras.u02coleccionesestructuras.ejercicios.pendientes;

import java.util.HashMap;
import java.util.Map;

/**
 * Ejercicio: conteo de frecuencias con mapas.
 *
 * <p>Objetivo: recorrer un array y acumular ocurrencias por clave.</p>
 */
public class Ejercicio1_FrecuenciasMap_SIN_RESOLVER {

    public static Map<String, Integer> contarFrecuencias(String[] datos) {
        Map<String, Integer> frecuencias = new HashMap<>();
        // TODO: completar el conteo de frecuencias usando getOrDefault o containsKey.
        return frecuencias;
    }

    public static void main(String[] args) {
        String[] palabras = {"java", "sql", "java", "poo", "sql", "java"};
        System.out.println(contarFrecuencias(palabras));
    }
}
