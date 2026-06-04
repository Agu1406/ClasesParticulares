package ev3.ut9.pf.streams.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;
// Collectors.joining concatena strings del stream con un delimitador, sin StringBuilder manual.
import java.util.stream.Collectors;

/**
 * Ejercicio 7 (Streams API): joining guiones - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Reduccion a String con delimitador custom.
 * 
 * Que hace este codigo resuelto:
 * Recolecta palabras en "uno-dos-tres" con joining("-") e imprime.
 * 
 * Conceptos que demuestra:
 *   - Collectors.joining delimitador.
 *   - Terminal que devuelve String, no List.
 *   - Sin StringBuilder manual.
 * 
 * Salida al ejecutar main:
 * uno-dos-tres
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio7_JoiningGuiones_RESUELTO {
    public static void main(String[] args) {
        // Fuente de tres strings que joining unira en una sola cadena con guiones.
        List<String> palabras = List.of("uno", "dos", "tres");
        // Collectors.joining("-") concatena con delimitador sin bucle ni StringBuilder.
        String texto = palabras.stream().collect(Collectors.joining("-"));
        // Muestra uno-dos-tres: resultado del joining sobre las tres palabras.
        System.out.println(texto);
    }
}
