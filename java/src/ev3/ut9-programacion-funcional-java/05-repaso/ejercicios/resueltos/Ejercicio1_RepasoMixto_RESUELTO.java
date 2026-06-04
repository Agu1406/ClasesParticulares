package ev3.ut9.pf.repaso.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Repaso 1: repaso mixto filter map reduce - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Pipeline numerico completo de repaso UT9.
 * 
 * Que hace este codigo resuelto:
 * Filtra >5, eleva al cuadrado, suma con reduce e imprime 181.
 * 
 * Conceptos que demuestra:
 *   - Combinacion filter map reduce.
 *   - Terminal reduce con Integer::sum.
 *   - Repaso bloque Streams.
 * 
 * Salida al ejecutar main:
 * 181
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_RepasoMixto_RESUELTO {
    public static void main(String[] args) {
        // Mezcla de valores; algunos superan 5 y seran contados por el filter.
        List<Integer> numeros = List.of(1, 3, 6, 8, 2, 9);
        // Pipeline completo: >5, cuadrado n*n, reduce suma en una sola expresion encadenada.
        int total = numeros.stream().filter(numero -> numero > 5).map(numero -> numero * numero).reduce(0, Integer::sum);
        // Muestra 181 = 6^2 + 8^2 + 9^2 tras filtrar numeros mayores que cinco.
        System.out.println(total);
    }
}
