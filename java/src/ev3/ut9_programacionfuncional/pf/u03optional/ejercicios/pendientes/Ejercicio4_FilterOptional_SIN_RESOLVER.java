package ev3.ut9_programacionfuncional.pf.u03optional.ejercicios.pendientes;

import java.util.Optional;

/**
 * Ejercicio 4 (Optional): filter en Optional.
 * 
 * Proposito:
 * Descartar valor presente que no cumple predicado, quedando empty equivalente para downstream.
 * 
 * Objetivos de aprendizaje:
 *   - Optional.of palabra corta.
 *   - filter longitud > 3.
 *   - orElse mensaje alternativo.
 * 
 * Tu tarea:
 * Si la palabra tiene mas de 3 letras devuelvela; si no, imprime "corta" usando filter y orElse.
 * 
 * Salida esperada al ejecutar main:
 * corta
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio4_FilterOptional_SIN_RESOLVER {
    public static void main(String[] args) {
        Optional<String> palabra = Optional.of("sol");
        // TODO: filter longitud>3 map mismo valor orElse "corta"
    }
}
