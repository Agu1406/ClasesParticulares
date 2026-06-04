package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// Supplier Double
import java.util.function.Supplier;

/**
 * Ejercicio universidad (TPP Hoja2 ej.7): Supplier Math random.
 * 
 * Proposito:
 * Math::random como Supplier<Double>.
 * 
 * Origen:
 *   TPP Hoja2 ej.7
 * 
 * Tu tarea:
 * Tres llamadas a get.
 * 
 * Salida esperada al ejecutar main:
 * (tres doubles)
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio17_UniSupplierMathRandom_RESUELTO {
    public static void main(String[] args) {
        // referencia
        java.util.function.Supplier<Double> ref = Math::random;
        // 1
        System.out.println(ref.get());
        // 2
        System.out.println(ref.get());
        // 3
        System.out.println(ref.get());
    }
}
