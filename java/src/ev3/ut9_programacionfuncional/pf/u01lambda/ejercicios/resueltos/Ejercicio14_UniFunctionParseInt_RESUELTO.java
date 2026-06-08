package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.resueltos;

// Function parse
import java.util.function.Function;

/**
 * Ejercicio universidad (TPP Hoja2 ej.4): Function parseInt.
 * 
 * Proposito:
 * Integer::parseInt convierte String a Integer.
 * 
 * Origen:
 *   TPP Hoja2 ej.4
 * 
 * Tu tarea:
 * Ambas formas; "10" y "123".
 * 
 * Salida esperada al ejecutar main:
 * 10
123
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio14_UniFunctionParseInt_RESUELTO {
    public static void main(String[] args) {
        // estatico
        Function<String, Integer> ref = Integer::parseInt;
        // lambda
        Function<String, Integer> lam = s -> Integer.parseInt(s);
        // 10
        System.out.println(ref.apply("10"));
        // 123
        System.out.println(lam.apply("123"));
    }
}
