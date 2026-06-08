package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.resueltos;

// Predicate sobre Character
import java.util.function.Predicate;

/**
 * Ejercicio universidad (TPP Hoja2 ej.2): Predicate Character mayuscula.
 * 
 * Proposito:
 * Metodo estatico Character::isUpperCase como Predicate.
 * 
 * Origen:
 *   TPP Hoja2 ej.2
 * 
 * Tu tarea:
 * Referencia y lambda; probar 'A' y 'a'.
 * 
 * Salida esperada al ejecutar main:
 * true
false
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio12_UniPredicateCharacterMayus_RESUELTO {
    public static void main(String[] args) {
        // metodo estatico
        Predicate<Character> ref = Character::isUpperCase;
        // lambda
        Predicate<Character> lam = c -> Character.isUpperCase(c);
        // mayuscula
        System.out.println(ref.test('A'));
        // minuscula
        System.out.println(lam.test('a'));
    }
}
