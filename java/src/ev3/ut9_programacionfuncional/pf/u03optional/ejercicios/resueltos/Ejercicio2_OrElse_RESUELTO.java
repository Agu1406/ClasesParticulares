package ev3.ut9_programacionfuncional.pf.u03optional.ejercicios.resueltos;

// Clase Optional para encadenar map/filter/flatMap sin NullPointerException.
import java.util.Optional;

/**
 * Ejercicio 2 (Optional): orElse - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Valor sustituto cuando Optional no contiene dato.
 * 
 * Que hace este codigo resuelto:
 * Optional.empty().orElse("defecto") produce e imprime "defecto".
 * 
 * Conceptos que demuestra:
 *   - Optional vacio.
 *   - orElse evalua siempre el argumento (diferencia con orElseGet).
 *   - Desenvoltura segura.
 * 
 * Salida al ejecutar main:
 * defecto
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio2_OrElse_RESUELTO {
    public static void main(String[] args) {
        // Optional.empty() modela contenedor vacio: no hay String presente.
        Optional<String> vacio = Optional.empty();
        // orElse("defecto") desenvuelve o devuelve literal cuando no hay valor.
        String texto = vacio.orElse("defecto");
        // Muestra "defecto" porque el Optional estaba vacio desde el inicio.
        System.out.println(texto);
    }
}
