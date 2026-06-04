package ev3.ut9.pf.u03optional.ejercicios.resueltos;

// Clase Optional para encadenar map/filter/flatMap sin NullPointerException.
import java.util.Optional;

/**
 * Ejercicio 5 (Optional): ofNullable - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Creacion segura de Optional desde referencia nullable.
 * 
 * Que hace este codigo resuelto:
 * ofNullable(null).orElse("nulo") imprime "nulo" sin NPE.
 * 
 * Conceptos que demuestra:
 *   - ofNullable vs of (of no acepta null).
 *   - Manejo explicito de ausencia.
 *   - Patron defensivo frente a null.
 * 
 * Salida al ejecutar main:
 * nulo
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio5_OfNullable_RESUELTO {
    public static void main(String[] args) {
        // Variable String posible = null simula dato ausente de codigo legacy.
        String posible = null;
        // ofNullable(null) crea Optional vacio; of(null) lanzaria NullPointerException.
        String val = Optional.ofNullable(posible).orElse("nulo");
        // Muestra "nulo": texto por defecto cuando la referencia envuelta era null.
        System.out.println(val);
    }
}
