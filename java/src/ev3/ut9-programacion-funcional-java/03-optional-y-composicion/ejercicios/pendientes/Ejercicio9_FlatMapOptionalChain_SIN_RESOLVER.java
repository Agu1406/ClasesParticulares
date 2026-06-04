package ev3.ut9.pf.optional.pendientes;

import java.util.Optional;

/**
 * Ejercicio 9 (Optional): cadena flatMap usuario -> email -> dominio.
 * 
 * Proposito:
 * Encadenar operaciones que devuelven Optional sin anidamiento manual; flatMap aplana Optional<Optional<T>>.
 * 
 * Objetivos de aprendizaje:
 *   - obtenerEmail devuelve Optional<String>.
 *   - dominioDe extrae parte tras @.
 *   - flatMap encadena pasos en main.
 * 
 * Tu tarea:
 * Implementa obtenerEmail y dominioDe. En main obtiene dominio de "ana" (test.com) y de usuario inexistente ("?").
 * 
 * Salida esperada al ejecutar main:
 * test.com
?
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio9_FlatMapOptionalChain_SIN_RESOLVER {
    static Optional<String> obtenerEmail(String u) { return Optional.empty(); }
    static Optional<String> dominioDe(String email) { return Optional.empty(); }

    public static void main(String[] args) {
        // TODO: metodos obtenerEmail y dominioDe; flatMap en main
    }
}
