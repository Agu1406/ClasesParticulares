package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 6 (Lambda y SAM): forEach con Consumer - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Recorrido declarativo con efecto lateral de impresion.
 * 
 * Que hace este codigo resuelto:
 * Aplica forEach con lambda que antepone "N=" a cada entero de la lista y escribe una linea por elemento en consola.
 * 
 * Conceptos que demuestra:
 *   - Consumer implicito en forEach.
 *   - Iteracion sin indice manual.
 *   - Efecto lateral acotado a System.out.
 * 
 * Salida al ejecutar main:
 * N=3
N=1
N=4
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_ForEachConsumer_RESUELTO {
    public static void main(String[] args) {
        // Tres enteros de ejemplo sobre los que forEach ejecutara la accion de impresion.
        List<Integer> numeros = List.of(3, 1, 4);
        // forEach aplica Consumer lambda: efecto lateral controlado (println) por elemento.
        numeros.forEach(numero -> System.out.println("N=" + numero));
    }
}
