package ev3.ut9.pf.lambda.resueltos;

// ArrayList importada porque removeIf y sort modifican la lista original, no una copia.
import java.util.ArrayList;
// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 4 (Lambda y SAM): removeIf - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Filtrado destructivo sobre coleccion mutable con Predicate lambda.
 * 
 * Que hace este codigo resuelto:
 * Parte de cuatro palabras, elimina las que empiezan por x (case insensitive) con removeIf y muestra la lista reducida.
 * 
 * Conceptos que demuestra:
 *   - Predicate<String> como lambda.
 *   - removeIf modifica la lista in-place.
 *   - toLowerCase y startsWith para comparacion flexible.
 * 
 * Salida al ejecutar main:
 * [casa, sol]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio4_RemoveIfPredicate_RESUELTO {
    public static void main(String[] args) {
        // Cuatro palabras de prueba; algunas empiezan por x en distintas capitalizaciones.
        List<String> palabras = new ArrayList<>(List.of("xilofono", "casa", "Xeno", "sol"));
        // removeIf con Predicate lambda elimina in-place las cadenas cuyo prefijo es x (ignore case).
        palabras.removeIf(texto -> texto.toLowerCase().startsWith("x"));
        // Imprime la lista tras removeIf; solo deben quedar elementos que no empiezan por x.
        System.out.println(palabras);
    }
}
