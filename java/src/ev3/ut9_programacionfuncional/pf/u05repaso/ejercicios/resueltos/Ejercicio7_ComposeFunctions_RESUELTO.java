package ev3.ut9_programacionfuncional.pf.u05repaso.ejercicios.resueltos;

// Function<T,R> transforma un valor en otro; base para compose, andThen y pipelines.
import java.util.function.Function;

/**
 * Repaso 7: compose functions - SOLUCION.
 * 
 * Proposito del ejercicio:
 * compose(g) ejecuta g antes que f.
 * 
 * Que hace este codigo resuelto:
 * h.apply(3) = (3*2)+1 = 7 e imprime.
 * 
 * Conceptos que demuestra:
 *   - Function.compose orden inverso.
 *   - Contraste andThen vs compose.
 *   - Composicion funcional repaso.
 * 
 * Salida al ejecutar main:
 * 7
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio7_ComposeFunctions_RESUELTO {
    public static void main(String[] args) {
        // Function f incrementa; en compose se aplicara despues de g.
        Function<Integer, Integer> incrementar = valor -> valor + 1;
        // Function g multiplica por dos; compose(g) la ejecuta antes que f.
        Function<Integer, Integer> duplicar = valor -> valor * 2;
        // f.compose(g): apply(3) calcula g(3)=6 y luego f(6)=7 (orden inverso a andThen).
        Function<Integer, Integer> funcionCompuesta = incrementar.compose(duplicar);
        // Imprime 7 verificando compose: primero doble, despues suma uno.
        System.out.println(funcionCompuesta.apply(3));
    }
}
