package ev3.ut9.pf.optional.pendientes;

import java.util.Optional;

/**
 * Ejercicio 3 (Optional): map para longitud de texto.
 * 
 * Proposito:
 * Transformar valor presente dentro de Optional sin extraerlo manualmente; si vacio, cadena de map no ejecuta.
 * 
 * Objetivos de aprendizaje:
 *   - Optional.of con String.
 *   - map(String::length).
 *   - orElse(0) si no hay valor.
 * 
 * Tu tarea:
 * Dado Optional con "Java", obtiene longitud con map u orElse 0 e imprime.
 * 
 * Salida esperada al ejecutar main:
 * 4
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_MapOptionalLength_SIN_RESOLVER {
    public static void main(String[] args) {
        Optional<String> nombre = Optional.of("Java");
        // TODO: map String::length orElse 0 e imprimir
    }
}
