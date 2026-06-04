package ev3.ut9.pf.repaso.resueltos;

// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Repaso 5: distinct + sorted - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Deduplicacion y ordenacion encadenadas.
 * 
 * Que hace este codigo resuelto:
 * Produce [1,2,3] e imprime.
 * 
 * Conceptos que demuestra:
 *   - distinct + sorted.
 *   - Orden natural Integer.
 *   - Repaso streams intermedios.
 * 
 * Salida al ejecutar main:
 * [1, 2, 3]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio5_DistinctSorted_RESUELTO {
    public static void main(String[] args) {
        // Lista con duplicados 3,1,3,2,1; distinct los eliminara antes de sorted.
        List<Integer> numeros = List.of(3, 1, 3, 2, 1);
        // distinct + sorted + collect produce [1,2,3] sin repeticiones en orden creciente.
        List<Integer> resultadoNumeros = numeros.stream().distinct().sorted().collect(Collectors.toList());
        // Muestra resultado transformado en consola (lista o valor segun el ejercicio).
        System.out.println(resultadoNumeros);
    }
}
