package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// interfaz SAM booleana
import java.util.function.Predicate;

/**
 * Ejercicio universidad (TPP Hoja2 ej.1): Predicate String isEmpty.
 * 
 * Proposito:
 * Elegir referencia compatible con Predicate y contrastar con lambda.
 * 
 * Origen:
 *   TPP Hoja2 ej.1
 * 
 * Tu tarea:
 * Declara Predicate con String::isEmpty y lambda; test con cadena vacia y no vacia.
 * 
 * Salida esperada al ejecutar main:
 * false
true
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio11_UniPredicateStringIsEmpty_RESUELTO {
    public static void main(String[] args) {
        // referencia a metodo de instancia
        Predicate<String> conReferencia = String::isEmpty;
        // lambda equivalente
        Predicate<String> conLambda = texto -> texto.isEmpty();
        // cadena vacia
        System.out.println(conReferencia.test(""));
        // cadena no vacia
        System.out.println(conLambda.test("java"));
    }
}
