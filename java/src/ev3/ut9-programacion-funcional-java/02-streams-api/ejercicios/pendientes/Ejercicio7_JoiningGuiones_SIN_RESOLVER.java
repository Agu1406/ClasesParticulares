package ev3.ut9.pf.streams.pendientes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio 7 (Streams API): joining con guiones.
 * 
 * Proposito:
 * Agregar strings en una sola cadena con Collectors.joining, alternativa funcional a concatenacion manual en bucle.
 * 
 * Objetivos de aprendizaje:
 *   - stream de List<String>.
 *   - collect(Collectors.joining("-")).
 *   - Imprimir cadena resultante.
 * 
 * Tu tarea:
 * Une las tres palabras con guion como separador e imprime la cadena (ej. uno-dos-tres).
 * 
 * Salida esperada al ejecutar main:
 * uno-dos-tres
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio7_JoiningGuiones_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> palabras = List.of("uno", "dos", "tres");
        // TODO: stream collect joining("-")
    }
}
