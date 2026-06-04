package ev3.ut9.pf.optional.resueltos;

// Clase Optional para encadenar map/filter/flatMap sin NullPointerException.
import java.util.Optional;

/**
 * Ejercicio 10 (Optional): ifPresentOrElse - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Ramificacion funcional segun contenido del Optional.
 * 
 * Que hace este codigo resuelto:
 * Primera llamada imprime Valor: PF; segunda con empty imprime vacio.
 * 
 * Conceptos que demuestra:
 *   - ifPresentOrElse ramas simetricas.
 *   - Consumer para valor presente.
 *   - Runnable para caso vacio.
 * 
 * Salida al ejecutar main:
 * Valor: PF
vacio
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio10_IfPresentOrElse_RESUELTO {
    public static void main(String[] args) {
        // Optional.of("PF") tiene contenido; ifPresentOrElse ejecutara rama presente.
        Optional<String> dato = Optional.of("PF");
        // ifPresentOrElse: Consumer si hay valor, Runnable si Optional esta vacio.
        dato.ifPresentOrElse(v -> System.out.println("Valor: " + v), () -> System.out.println("vacio"));
        // Segunda llamada con Optional.empty() demuestra rama del mensaje vacio.
        Optional.<String>empty().ifPresentOrElse(v -> System.out.println(v), () -> System.out.println("vacio"));
    }
}
