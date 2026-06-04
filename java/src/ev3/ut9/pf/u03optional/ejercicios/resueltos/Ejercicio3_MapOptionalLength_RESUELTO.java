package ev3.ut9.pf.u03optional.ejercicios.resueltos;

// Clase Optional para encadenar map/filter/flatMap sin NullPointerException.
import java.util.Optional;

/**
 * Ejercicio 3 (Optional): map optional length - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Transformacion functorial sobre valor opcional.
 * 
 * Que hace este codigo resuelto:
 * map convierte "Java" a longitud 4; orElse 0 solo actua si vacio.
 * 
 * Conceptos que demuestra:
 *   - map en Optional (no confundir con stream map).
 *   - Optional<Integer> intermedio implicito.
 *   - orElse tras transformacion.
 * 
 * Salida al ejecutar main:
 * 4
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_MapOptionalLength_RESUELTO {
    public static void main(String[] args) {
        // Optional.of("Java") contiene valor presente; map operara sobre el String interno.
        Optional<String> nombre = Optional.of("Java");
        // map(String::length) convierte a Integer; orElse(0) solo actua si vacio.
        int len = nombre.map(String::length).orElse(0);
        // Muestra 4: numero de letras de "Java" obtenido via map en Optional.
        System.out.println(len);
    }
}
