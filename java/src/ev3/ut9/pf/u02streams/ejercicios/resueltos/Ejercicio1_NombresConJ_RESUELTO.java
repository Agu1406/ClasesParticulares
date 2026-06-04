package ev3.ut9.pf.u02streams.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 1 (Streams API): nombres con J - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Pipeline declarativo filter -> sorted -> map -> collect.
 * 
 * Que hace este codigo resuelto:
 * Filtra nombres con J, ordena, convierte a mayusculas, recolecta en nueva lista e imprime.
 * 
 * Conceptos que demuestra:
 *   - Operaciones intermedias encadenadas.
 *   - filter, sorted, map, collect.
 *   - Nueva lista sin modificar la fuente inmutable.
 * 
 * Salida al ejecutar main:
 * [JACK, JANE, JOHN]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_NombresConJ_RESUELTO {
    public static void main(String[] args) {
        // Cinco nombres; tres empiezan por J y seran los unicos que pasen el filter.
        List<String> nombres = List.of("Alice", "Bob", "John", "Jane", "Jack");
        // stream() convierte la List en pipeline lazy de operaciones encadenables.
        List<String> listaResultado = nombres.stream()
        // filter conserva elementos que cumplen startsWith("J"); descarta el resto.
        .filter(nombre -> nombre.startsWith("J"))
        // sorted() aplica orden natural de String sobre los elementos que quedaron en el stream.
        .sorted()
        // map(String::toUpperCase) transforma cada nombre filtrado sin bucle explicito.
        .map(String::toUpperCase)
        // collect(toList()) materializa el pipeline en ArrayList; la fuente no cambia.
        .collect(Collectors.toList());
        // Salida final en consola para contrastar con la respuesta esperada del ejercicio.
        System.out.println(listaResultado);
    }
}
