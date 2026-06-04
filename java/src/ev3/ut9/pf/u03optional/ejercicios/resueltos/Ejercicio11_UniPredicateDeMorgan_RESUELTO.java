package ev3.ut9.pf.u03optional.ejercicios.resueltos;

// Predicate
import java.util.function.Predicate;

/**
 * Ejercicio universidad (TPP Hoja3 ej.3): Predicate De Morgan.
 * 
 * Proposito:
 * Comprobar leyes De Morgan con Predicate.
 * 
 * Origen:
 *   TPP Hoja3 ej.3
 * 
 * Tu tarea:
 * p: x>5, q: par; mostrar equivalencias para varios x.
 * 
 * Salida esperada al ejecutar main:
 * (tabla booleana)
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio11_UniPredicateDeMorgan_RESUELTO {
    public static void main(String[] args) {
        // p
        java.util.function.Predicate<Integer> p = x -> x > 5;
        // q
        java.util.function.Predicate<Integer> q = x -> x % 2 == 0;
        // casos
        int[] valores = {3, 4, 6, 9, 10};
        // bucle
        for (int x : valores) {
        // ley1
            System.out.println("x=" + x + " !(p&&q)= " + p.and(q).negate().test(x) + " !p||!q= " + (p.negate().or(q.negate()).test(x)));
        // ley2
            System.out.println("x=" + x + " !(p||q)= " + p.or(q).negate().test(x) + " !p&&!q= " + (p.negate().and(q.negate()).test(x)));
        // fin bucle
        }
    }
}
