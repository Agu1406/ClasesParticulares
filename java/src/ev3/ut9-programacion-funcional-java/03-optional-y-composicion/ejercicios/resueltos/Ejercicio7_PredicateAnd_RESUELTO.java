package ev3.ut9.pf.optional.resueltos;

// Predicate<T> devuelve boolean; se usa en filter, removeIf y composicion con and/or.
import java.util.function.Predicate;

/**
 * Ejercicio 7 (Optional): Predicate and - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Predicado compuesto par AND mayor que 10.
 * 
 * Que hace este codigo resuelto:
 * 12 cumple (true), 7 no (false); imprime ambos resultados de test.
 * 
 * Conceptos que demuestra:
 *   - Predicate.and composicion.
 *   - test evalua condicion.
 *   - Reutilizacion de predicados base.
 * 
 * Salida al ejecutar main:
 * true
false
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio7_PredicateAnd_RESUELTO {
    public static void main(String[] args) {
        // Lambda numero % 2 == 0 reutilizable como bloque de condicion par.
        Predicate<Integer> esPar = numero -> numero % 2 == 0;
        // Segundo Predicate independiente; se combinara con AND al anterior.
        Predicate<Integer> esGrande = numero -> numero > 10;
        // esPar.and(esGrande) exige cumplir ambas condiciones simultaneamente.
        Predicate<Integer> ambos = esPar.and(esGrande);
        // 12 es par y >10; test devuelve true e imprime confirmacion.
        System.out.println(ambos.test(12));
        // 7 es impar; aunque no supere 10, falla por par y test devuelve false.
        System.out.println(ambos.test(7));
    }
}
