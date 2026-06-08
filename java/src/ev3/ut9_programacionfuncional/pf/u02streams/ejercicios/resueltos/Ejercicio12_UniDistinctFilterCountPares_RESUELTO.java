package ev3.ut9_programacionfuncional.pf.u02streams.ejercicios.resueltos;

// asList
import java.util.Arrays;
// lista
import java.util.List;

/**
 * Ejercicio universidad (TPP Hoja2 bloque2 ej.6): distinct filter count pares.
 * 
 * Proposito:
 * distinct + filter pares + count.
 * 
 * Origen:
 *   TPP Hoja2 bloque2 ej.6
 * 
 * Tu tarea:
 * Contar pares distintos en lista con repetidos.
 * 
 * Salida esperada al ejecutar main:
 * Cantidad de numeros pares distintos: 2
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio12_UniDistinctFilterCountPares_RESUELTO {
    public static void main(String[] args) {
        // datos
        java.util.List<Integer> values = java.util.Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        // pipeline
        long total = values.stream().distinct().filter(n -> n % 2 == 0).count();
        // salida
        System.out.println("Cantidad de numeros pares distintos: " + total);
    }
}
