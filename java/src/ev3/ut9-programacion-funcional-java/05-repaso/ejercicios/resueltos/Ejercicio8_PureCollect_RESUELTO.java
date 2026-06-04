package ev3.ut9.pf.repaso.resueltos;

// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Repaso 8: pure collect - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Transformacion map*2 materializada en nueva lista.
 * 
 * Que hace este codigo resuelto:
 * Imprime [4,8]; orig sigue [2,4].
 * 
 * Conceptos que demuestra:
 *   - Inmutabilidad orig.
 *   - map numerico.
 *   - collect toList.
 * 
 * Salida al ejecutar main:
 * [4, 8]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_PureCollect_RESUELTO {
    public static void main(String[] args) {
        // Lista orig [2,4] permanece intacta; doble es copia transformada.
        List<Integer> orig = List.of(2, 4);
        // map(n->n*2)+collect crea [4,8] sin mutar orig.
        List<Integer> doble = orig.stream().map(numero -> numero * 2).collect(Collectors.toList());
        // Muestra [4, 8]: cada elemento de orig multiplicado por dos.
        System.out.println(doble);
    }
}
