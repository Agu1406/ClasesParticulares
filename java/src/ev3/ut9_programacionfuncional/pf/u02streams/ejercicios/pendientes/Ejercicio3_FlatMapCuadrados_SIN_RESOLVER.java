package ev3.ut9_programacionfuncional.pf.u02streams.ejercicios.pendientes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio 3 (Streams API): flatMap de listas anidadas a cuadrados.
 * 
 * Proposito:
 * Aplanar estructuras anidadas (List<List<Integer>>) en un stream plano antes de transformar, concepto clave de flatMap frente a map.
 * 
 * Objetivos de aprendizaje:
 *   - stream sobre lista de listas.
 *   - flatMap(List::stream) para aplanar.
 *   - map n*n y collect.
 * 
 * Tu tarea:
 * A partir de grupos (listas anidadas), aplana todos los enteros, eleva cada uno al cuadrado y recolecta en lista que debes imprimir.
 * 
 * Salida esperada al ejecutar main:
 * [1, 4, 9, 16, 25]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_FlatMapCuadrados_SIN_RESOLVER {
    public static void main(String[] args) {
        List<List<Integer>> grupos = List.of(List.of(1, 2), List.of(3), List.of(4, 5));
        // TODO: flatMap a stream de enteros, map numero*numero, collect
    }
}
