package ev3.ut9.pf.u01lambda.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ejercicio 9 (Lambda y SAM): orden descendente de enteros.
 * 
 * Proposito:
 * Invertir criterio de ordenacion en Comparator para enteros, reforzando que la lambda define la relacion de orden, no solo el orden natural.
 * 
 * Objetivos de aprendizaje:
 *   - Ordenar Integer en ArrayList mutable.
 *   - Lambda descendente (mayor primero).
 *   - Imprimir lista reordenada.
 * 
 * Tu tarea:
 * Ordena nums de mayor a menor con Collections.sort y lambda. Imprime el resultado.
 * 
 * Salida esperada al ejecutar main:
 * [10, 8, 3, 1]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio9_SortNumerosDescendente_SIN_RESOLVER {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(3, 10, 1, 8));
        // TODO: Collections.sort descendente (b.compareTo(a) o resta invertida)
        // TODO: imprimir numeros
    }
}
