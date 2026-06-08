package ev3.ut9_programacionfuncional.pf.u03optional.ejercicios.resueltos;

// mutable
import java.util.ArrayList;
// Comparator
import java.util.Comparator;
// List
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
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio13_UniComparatorNullsLast_RESUELTO {
    public static void main(String[] args) {
        // lista
        java.util.ArrayList<String> palabras = new java.util.ArrayList<>();
        // datos
        palabras.add("stream"); palabras.add(null); palabras.add("java"); palabras.add("pf");
        // by length
        java.util.Comparator<String> porLongitud = java.util.Comparator.comparing(s -> s.length());
        // nulls last
        palabras.sort(java.util.Comparator.nullsLast(porLongitud));
        // salida
        System.out.println(palabras);
    }
}
