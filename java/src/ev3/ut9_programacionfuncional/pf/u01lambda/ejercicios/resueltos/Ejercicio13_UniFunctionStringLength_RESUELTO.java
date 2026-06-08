package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.resueltos;

// Function String a Integer
import java.util.function.Function;

/**
 * Ejercicio universidad (TPP Hoja2 ej.3): Function String length.
 * 
 * Proposito:
 * String::length como Function<String,Integer>.
 * 
 * Origen:
 *   TPP Hoja2 ej.3
 * 
 * Tu tarea:
 * Ambas formas; apply a dos cadenas.
 * 
 * Salida esperada al ejecutar main:
 * 4
10
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio13_UniFunctionStringLength_RESUELTO {
    public static void main(String[] args) {
        // referencia
        Function<String, Integer> ref = String::length;
        // lambda
        Function<String, Integer> lam = t -> t.length();
        // java
        System.out.println(ref.apply("java"));
        // functional
        System.out.println(lam.apply("functional"));
    }
}
