package ev3.ut9.pf.u03optional.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Ejercicio universidad (TPP Hoja3 ej.7): Comparator nullsLast.
 * 
 * Proposito:
 * Ordenar cadenas por longitud con null al final.
 * 
 * Origen:
 *   TPP Hoja3 ej.7
 * 
 * Tu tarea:
 * Comparator.nullsLast(byLength).
 * 
 * Salida esperada al ejecutar main:
 * [pf, java, stream, null]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio13_UniComparatorNullsLast_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        palabras.add("stream"); palabras.add(null); palabras.add("java"); palabras.add("pf");
        // TODO: sort nullsLast comparing length
        // TODO: println
    }
}
