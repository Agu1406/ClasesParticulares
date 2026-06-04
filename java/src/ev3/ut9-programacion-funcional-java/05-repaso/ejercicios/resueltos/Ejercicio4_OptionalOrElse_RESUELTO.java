package ev3.ut9.pf.repaso.resueltos;

// Clase Optional para encadenar map/filter/flatMap sin NullPointerException.
import java.util.Optional;

/**
 * Repaso 4: optional orElse - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Valor por defecto NA cuando referencia es null.
 * 
 * Que hace este codigo resuelto:
 * Imprime NA.
 * 
 * Conceptos que demuestra:
 *   - Repaso Optional.
 *   - ofNullable + orElse.
 *   - Evitar null en salida.
 * 
 * Salida al ejecutar main:
 * NA
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio4_OptionalOrElse_RESUELTO {
    public static void main(String[] args) {
        // ofNullable(null).orElse("NA") sustituye ausencia de referencia por NA.
        String r = Optional.<String>ofNullable(null).orElse("NA");
        // Muestra NA: valor por defecto cuando no hay String presente en el Optional.
        System.out.println(r);
    }
}
