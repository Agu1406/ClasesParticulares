package ev3.ut9.pf.repaso.resueltos;

// ArrayList mutable: permite sort in-place y reordenar elementos en memoria.
import java.util.ArrayList;
// Collections.sort ordena in-place; la lambda define el criterio de comparacion entre elementos.
import java.util.Collections;
// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;

/**
 * Repaso 2: lambda sort - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Sort ascendente clasico con lambda resta.
 * 
 * Que hace este codigo resuelto:
 * Ordena [5,1,9] e imprime [1,5,9].
 * 
 * Conceptos que demuestra:
 *   - Repaso lambda Comparator.
 *   - Orden numerico ascendente.
 *   - Collections.sort.
 * 
 * Salida al ejecutar main:
 * [1, 5, 9]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio2_LambdaSort_RESUELTO {
    public static void main(String[] args) {
        // ArrayList mutable con tres enteros desordenados lista para Collections.sort.
        List<Integer> numeros = new ArrayList<>(List.of(5, 1, 9));
        // Lambda (a,b) -> a-b ordena de menor a mayor usando resta aritmetica.
        Collections.sort(numeros, (menor, mayor) -> menor - mayor);
        // Muestra resultado transformado en consola (lista o valor segun el ejercicio).
        System.out.println(numeros);
    }
}
