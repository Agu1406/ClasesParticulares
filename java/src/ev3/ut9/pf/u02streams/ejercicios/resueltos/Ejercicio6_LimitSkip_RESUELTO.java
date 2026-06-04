package ev3.ut9.pf.u02streams.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 6 (Streams API): limit + skip - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Ventana sobre stream con skip y limit.
 * 
 * Que hace este codigo resuelto:
 * Tras skip(2).limit(3) sobre [10..60] imprime [30, 40, 50].
 * 
 * Conceptos que demuestra:
 *   - skip descarta cabecera.
 *   - limit acota tamano del stream.
 *   - Orden de operaciones importa.
 * 
 * Salida al ejecutar main:
 * [30, 40, 50]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_LimitSkip_RESUELTO {
    public static void main(String[] args) {
        // Lista 10..60; skip y limit extraeran un trozo central del stream.
        List<Integer> numeros = List.of(10, 20, 30, 40, 50, 60);
        // skip(2) ignora 10 y 20; limit(3) conserva 30, 40 y 50.
        List<Integer> trozo = numeros.stream().skip(2).limit(3).collect(Collectors.toList());
        // Muestra [30, 40, 50]: ventana del stream tras skip(2).limit(3).
        System.out.println(trozo);
    }
}
