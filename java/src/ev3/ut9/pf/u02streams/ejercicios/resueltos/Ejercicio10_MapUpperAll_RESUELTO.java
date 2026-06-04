package ev3.ut9.pf.u02streams.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 10 (Streams API): map upper all - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Map masivo con referencia a metodo de instancia.
 * 
 * Que hace este codigo resuelto:
 * Transforma [ana,bob,cara] a mayusculas funcionalmente e imprime.
 * 
 * Conceptos que demuestra:
 *   - map con method reference.
 *   - Lista fuente inmutable intacta.
 *   - collect materializa transformacion.
 * 
 * Salida al ejecutar main:
 * [ANA, BOB, CARA]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio10_MapUpperAll_RESUELTO {
    public static void main(String[] args) {
        // Tres nombres en minusculas; map toUpperCase los transformara todos.
        List<String> nombres = List.of("ana", "bob", "cara");
        // map(String::toUpperCase) aplica transformacion uniforme a cada elemento del stream.
        List<String> upper = nombres.stream().map(String::toUpperCase).collect(Collectors.toList());
        // Muestra en consola la lista resultante completa para contrastar con la salida esperada.
        System.out.println(upper);
    }
}
