package ev3.ut9_programacionfuncional.pf.u03optional.ejercicios.resueltos;

// ArrayList mutable: permite sort in-place y reordenar elementos en memoria.
import java.util.ArrayList;
// Comparator define reglas de orden; comparing y thenComparing construyen criterios compuestos.
import java.util.Comparator;
// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;

/**
 * Ejercicio 8 (Optional): thenComparing - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Orden estable multi-nivel con comparing + thenComparing.
 * 
 * Que hace este codigo resuelto:
 * Ordena [aa,b,cc,a] en [a,b,aa,cc] e imprime.
 * 
 * Conceptos que demuestra:
 *   - comparing clave primaria.
 *   - thenComparing desempate.
 *   - List.sort con Comparator.
 * 
 * Salida al ejecutar main:
 * [a, b, aa, cc]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_ComparatorThenComparing_RESUELTO {
    public static void main(String[] args) {
        // Cuatro palabras de distinta longitud; sort usara longitud y luego texto.
        List<String> palabras = new ArrayList<>(List.of("aa", "b", "cc", "a"));
        // comparing(length).thenComparing(s->s) desempata alfabeticamente a igual longitud.
        palabras.sort(Comparator.comparing(String::length).thenComparing(texto -> texto));
        // Muestra [a, b, aa, cc]: primero cortas, luego largas, desempate lexicografico.
        System.out.println(palabras);
    }
}
