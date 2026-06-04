package ev3.ut9.pf.lambda.resueltos;

// Supplier<T> es SAM sin parametros: get() produce un valor cuando se invoca.
import java.util.function.Supplier;

/**
 * Ejercicio 7 (Lambda y SAM): Supplier - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Fabricacion de valores bajo demanda con interfaz funcional.
 * 
 * Que hace este codigo resuelto:
 * Crea un Supplier lambda que produce un String fijo y lo imprime tras invocar get().
 * 
 * Conceptos que demuestra:
 *   - SAM Supplier: T get().
 *   - Lambda sin parametros.
 *   - Evaluacion al llamar get, no al declarar.
 * 
 * Salida al ejecutar main:
 * Programacion funcional
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio7_SupplierMensaje_RESUELTO {
    public static void main(String[] args) {
        // Supplier lambda sin parametros; el cuerpo devuelve el String al llamar get().
        Supplier<String> mensaje = () -> "Programacion funcional";
        // get() evalua la lambda y println muestra el texto producido por el Supplier.
        System.out.println(mensaje.get());
    }
}
