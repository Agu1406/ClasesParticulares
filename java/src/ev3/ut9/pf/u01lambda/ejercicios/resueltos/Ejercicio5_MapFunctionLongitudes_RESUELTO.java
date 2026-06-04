package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 5 (Lambda y SAM): map a longitudes - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Pipeline stream minimo: fuente -> transformacion -> coleccion destino.
 * 
 * Que hace este codigo resuelto:
 * Toma tres palabras, obtiene la longitud de cada una con map(String::length) y recolecta en una nueva List<Integer> que imprime.
 * 
 * Conceptos que demuestra:
 *   - Stream intermedio map.
 *   - Referencia a metodo String::length.
 *   - Terminal collect toList.
 * 
 * Salida al ejecutar main:
 * [3, 12, 2]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio5_MapFunctionLongitudes_RESUELTO {
    public static void main(String[] args) {
        // Lista inmutable de tres palabras; el stream las transformara sin modificar la fuente.
        List<String> palabras = List.of("sol", "programacion", "pf");
        // map(String::length) convierte cada String en su numero de caracteres (Integer).
        List<Integer> longitudes = palabras.stream().map(String::length).collect(Collectors.toList());
        // Muestra [3, 12, 2]: longitud de sol, programacion y pf respectivamente.
        System.out.println(longitudes);
    }
}
