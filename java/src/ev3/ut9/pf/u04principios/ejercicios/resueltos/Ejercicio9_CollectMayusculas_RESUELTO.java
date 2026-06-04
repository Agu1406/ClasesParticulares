package ev3.ut9.pf.u04principios.ejercicios.resueltos;

// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 9 (Principios): collect mayusculas - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Transformacion map/collect sobre lista de etiquetas.
 * 
 * Que hace este codigo resuelto:
 * Produce e imprime [JAVA, PF] sin alterar tags.
 * 
 * Conceptos que demuestra:
 *   - Pipeline transformacional.
 *   - Nueva coleccion resultado.
 *   - Estilo declarativo.
 * 
 * Salida al ejecutar main:
 * [JAVA, PF]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio9_CollectMayusculas_RESUELTO {
    public static void main(String[] args) {
        // Dos tags en minusculas; fuente inmutable para pipeline de mayusculas.
        List<String> tags = List.of("java", "pf");
        // map toUpperCase + collect genera nueva lista up sin tocar tags.
        List<String> up = tags.stream().map(String::toUpperCase).collect(Collectors.toList());
        // Muestra resultado transformado en consola (lista o valor segun el ejercicio).
        System.out.println(up);
    }
}
