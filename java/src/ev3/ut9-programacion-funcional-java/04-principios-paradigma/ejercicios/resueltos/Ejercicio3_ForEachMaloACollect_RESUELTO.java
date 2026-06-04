package ev3.ut9.pf.principios.resueltos;

// ArrayList mutable: permite sort in-place y reordenar elementos en memoria.
import java.util.ArrayList;
// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 3 (Principios): forEach malo a collect - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Reemplazo declarativo de mutacion incremental.
 * 
 * Que hace este codigo resuelto:
 * dst se obtiene directamente del pipeline map/collect e imprime [A, B].
 * 
 * Conceptos que demuestra:
 *   - forEach no debe construir colecciones.
 *   - map expresa transformacion elemento a elemento.
 *   - collect como unica materializacion.
 * 
 * Salida al ejecutar main:
 * [A, B]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_ForEachMaloACollect_RESUELTO {
    public static void main(String[] args) {
        // Lista src inmutable de dos caracteres; punto de partida del pipeline map/collect.
        List<String> src = List.of("a", "b");
        // Patron correcto: map+collect en lugar de forEach con add externo.
        List<String> dst = src.stream().map(String::toUpperCase).collect(Collectors.toList());
        // Muestra [A, B]: destino obtenido funcionalmente sin mutar listas auxiliares.
        System.out.println(dst);
    }
}
