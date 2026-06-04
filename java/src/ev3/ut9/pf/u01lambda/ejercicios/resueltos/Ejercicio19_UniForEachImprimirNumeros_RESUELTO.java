package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// List.of
import java.util.List;

/**
 * Ejercicio universidad (sesion1 ej.1): forEach imprimir numeros.
 * 
 * Proposito:
 * Lambda en forEach sobre List.
 * 
 * Origen:
 *   sesion1 ej.1
 * 
 * Tu tarea:
 * Imprimir cada numero en linea distinta.
 * 
 * Salida esperada al ejecutar main:
 * 3
1
4
1
5
9
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio19_UniForEachImprimirNumeros_RESUELTO {
    public static void main(String[] args) {
        // lista
        java.util.List<Integer> nums = java.util.List.of(3, 1, 4, 1, 5, 9);
        // forEach lambda
        nums.forEach(n -> System.out.println(n));
    }
}
