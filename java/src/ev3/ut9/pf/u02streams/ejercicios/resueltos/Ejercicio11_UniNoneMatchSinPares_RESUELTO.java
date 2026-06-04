package ev3.ut9.pf.u02streams.ejercicios.resueltos;

// asList
import java.util.Arrays;
// lista
import java.util.List;

/**
 * Ejercicio universidad (TPP Hoja2 bloque2 ej.3): noneMatch sin pares.
 * 
 * Proposito:
 * noneMatch sobre lista solo impares.
 * 
 * Origen:
 *   TPP Hoja2 bloque2 ej.3
 * 
 * Tu tarea:
 * Comprobar si ningun elemento es par.
 * 
 * Salida esperada al ejecutar main:
 * true
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio11_UniNoneMatchSinPares_RESUELTO {
    public static void main(String[] args) {
        // impares
        java.util.List<Integer> nums = java.util.Arrays.asList(1, 3, 5, 7);
        // noneMatch
        boolean noneEven = nums.stream().noneMatch(n -> n % 2 == 0);
        // lista
        System.out.println(nums);
        // true
        System.out.println(noneEven);
    }
}
