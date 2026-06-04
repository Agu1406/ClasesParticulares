package ev3.ut9.pf.lambda.pendientes;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 4 (Lambda y SAM): removeIf con Predicate.
 * 
 * Proposito:
 * Aprender a eliminar elementos de una lista de forma declarativa usando removeIf, que acepta un Predicate (funcion que devuelve boolean).
 * 
 * Objetivos de aprendizaje:
 *   - Usar removeIf sobre ArrayList mutable.
 *   - Escribir lambda que compruebe prefijo ignorando mayusculas/minusculas.
 *   - Observar que la lista original queda modificada.
 * 
 * Tu tarea:
 * Elimina de palabras todas las cadenas que empiecen por "x" (sin distinguir mayusculas). Usa removeIf con lambda e imprime lo que queda.
 * 
 * Salida esperada al ejecutar main:
 * [casa, sol]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio4_RemoveIfPredicate_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>(List.of("xilofono", "casa", "Xeno", "sol"));
        // TODO: palabras.removeIf con lambda (empieza por x)
        // TODO: imprimir palabras
    }
}
