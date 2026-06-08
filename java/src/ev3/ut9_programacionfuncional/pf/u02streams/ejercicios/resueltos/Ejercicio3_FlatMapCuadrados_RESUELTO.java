package ev3.ut9_programacionfuncional.pf.u02streams.ejercicios.resueltos;

// List y Collectors: estructura de datos y utilidades para cerrar pipelines stream.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 3 (Streams API): flatMap cuadrados - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Aplanamiento y transformacion en pipeline anidado.
 * 
 * Que hace este codigo resuelto:
 * Convierte List<List<Integer>> en stream plano de cuadrados [1,4,9,16,25] e imprime.
 * 
 * Conceptos que demuestra:
 *   - flatMap vs map (uno aplana, otro no).
 *   - Referencia List::stream.
 *   - Transformacion map n -> n * n.
 * 
 * Salida al ejecutar main:
 * [1, 4, 9, 16, 25]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_FlatMapCuadrados_RESUELTO {
    public static void main(String[] args) {
        // Estructura anidada List<List<Integer>>; flatMap la aplanara a un solo nivel.
        List<List<Integer>> grupos = List.of(List.of(1, 2), List.of(3), List.of(4, 5));
        // Primer stream contiene sublistas; cada una se abrira con flatMap(List::stream).
        List<Integer> cuadrados = grupos.stream()
        // flatMap convierte stream de listas en stream plano de enteros 1..5.
        .flatMap(List::stream)
        // map(n -> n*n) transforma cada entero aplanado en su cuadrado.
        .map(numero -> numero * numero)
        // collect(toList()) guarda todos los cuadrados en una nueva lista ordenada por pipeline.
        .collect(Collectors.toList());
        // Muestra [1, 4, 9, 16, 25]: cuadrados de 1, 2, 3, 4 y 5.
        System.out.println(cuadrados);
    }
}
