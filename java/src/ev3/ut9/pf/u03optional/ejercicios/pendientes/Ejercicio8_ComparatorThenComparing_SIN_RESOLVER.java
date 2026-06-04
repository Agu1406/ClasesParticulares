package ev3.ut9.pf.u03optional.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Ejercicio 8 (Optional): Comparator thenComparing.
 * 
 * Proposito:
 * Orden lexicografico multi-criterio: primero por longitud, empate por orden alfabetico.
 * 
 * Objetivos de aprendizaje:
 *   - Comparator.comparing(String::length).
 *   - thenComparing criterio secundario.
 *   - sort in-place e impresion.
 * 
 * Tu tarea:
 * Ordena palabras primero por numero de letras y, a igual longitud, alfabeticamente. Imprime la lista ordenada.
 * 
 * Salida esperada al ejecutar main:
 * [a, b, aa, cc]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_ComparatorThenComparing_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>(List.of("aa", "b", "cc", "a"));
        // TODO: sort con comparing length thenComparing naturalOrder
    }
}
