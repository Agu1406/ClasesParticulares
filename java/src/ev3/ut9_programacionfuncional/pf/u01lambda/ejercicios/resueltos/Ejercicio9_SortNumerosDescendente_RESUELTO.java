package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.resueltos;

// ArrayList importada porque removeIf y sort modifican la lista original, no una copia.
import java.util.ArrayList;
// Collections.sort ordena in-place; la lambda define el criterio de comparacion entre elementos.
import java.util.Collections;
// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 9 (Lambda y SAM): sort descendente - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Comparator numerico invertido con resta b - a.
 * 
 * Que hace este codigo resuelto:
 * Ordena cuatro enteros desordenados en descendente e imprime la lista.
 * 
 * Conceptos que demuestra:
 *   - Comparator<Integer> con lambda aritmetica.
 *   - Orden no natural (descendente).
 *   - Collections.sort in-place.
 * 
 * Salida al ejecutar main:
 * [10, 8, 3, 1]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio9_SortNumerosDescendente_RESUELTO {
    public static void main(String[] args) {
        // Cuatro numeros sin orden; la lambda del Comparator los pondra de mayor a menor.
        List<Integer> numeros = new ArrayList<>(List.of(3, 10, 1, 8));
        // Comparator (a,b) -> b - a invierte el orden natural numerico ascendente.
        Collections.sort(numeros, (segundo, primero) -> primero - segundo);
        // Muestra en consola la lista resultante completa para contrastar con la salida esperada.
        System.out.println(numeros);
    }
}
