package ev3.ut9.pf.lambda.resueltos;

// ArrayList: coleccion que permite cambiar tamano y orden; necesaria para sort in-place.
import java.util.ArrayList;
// Collections.sort ordena in-place; la lambda define el criterio de comparacion entre elementos.
import java.util.Collections;
// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 2 (Lambda y SAM): orden alfabetico - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Demostrar orden lexicografico con lambda y compareTo.
 * 
 * Que hace este codigo resuelto:
 * Toma cuatro nombres desordenados, los ordena con (nombreA, nombreB) -> nombreA.compareTo(nombreB) e imprime la secuencia ordenada.
 * 
 * Conceptos que demuestra:
 *   - Comparator basado en compareTo.
 *   - Orden natural de String (Unicode).
 *   - Sort in-place sobre ArrayList.
 * 
 * Salida al ejecutar main:
 * [Ana, Luis, Marta, Zoe]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio2_OrdenAlfabetico_RESUELTO {
    public static void main(String[] args) {
        // Cuatro nombres en orden aleatorio; la lambda los reordenara alfabeticamente.
        List<String> nombres = new ArrayList<>(List.of("Zoe", "Ana", "Luis", "Marta"));
        // compareTo implementa orden lexicografico Unicode entre dos String.
        Collections.sort(nombres, (nombreA, nombreB) -> nombreA.compareTo(nombreB));
        // Salida final en consola para contrastar con la respuesta esperada del ejercicio.
        System.out.println(nombres);
    }
}
