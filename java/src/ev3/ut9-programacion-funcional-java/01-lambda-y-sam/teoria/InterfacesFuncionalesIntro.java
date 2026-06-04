package ev3.ut9.pf.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Teoria: interfaces funcionales SAM (PDF diapos 10-11).
 *
 * <p><b>Que es SAM?</b> Single Abstract Method: una interfaz con exactamente un metodo
 * abstracto (mas default/static opcionales). Ese contrato es el "molde" que rellena
 * una expresion lambda.</p>
 *
 * <p><b>Que es una interfaz funcional?</b> Una interfaz SAM anotada con
 * {@code @FunctionalInterface}. El compilador comprueba que solo hay un metodo abstracto
 * y que la lambda encaja en el.</p>
 *
 * <p><b>Por que existen en java.util.function?</b> Java define tipos estandar para casos
 * habituales, asi no inventas una interfaz nueva para cada filtro o transformacion:</p>
 * <ul>
 *   <li>{@link Predicate} - pregunta booleana sobre un valor (filter, removeIf).</li>
 *   <li>{@link Function} - transforma T en R (map).</li>
 *   <li>{@link Consumer} - recibe T y no devuelve nada (forEach).</li>
 *   <li>{@link Supplier} - no recibe nada y produce T (fabrica, lazy).</li>
 * </ul>
 *
 * <p><b>Ventaja frente al enfoque tradicional:</b> antes creabas {@code MiFiltro},
 * {@code MiTransformador}, etc. Ahora reutilizas tipos genericos y pasas lambdas
 * concretas en el momento del uso.</p>
 *
 * <p><b>Demo en este archivo:</b> cuatro interfaces del JDK + una {@code Calculadora}
 * propia para demostrar que cualquier SAM valida acepta lambda.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class InterfacesFuncionalesIntro {

    @FunctionalInterface
    interface Calculadora {
        int sumar(int sumandoA, int sumandoB);
    }

    public static void main(String[] args) {
        Predicate<String> esLarga = texto -> texto.length() > 5;
        Function<String, Integer> longitud = String::length;
        Consumer<String> imprimir = texto -> System.out.println(">> " + texto);
        Supplier<Double> aleatorio = Math::random;

        System.out.println("esLarga('lambda'): " + esLarga.test("lambda"));
        System.out.println("longitud('stream'): " + longitud.apply("stream"));
        imprimir.accept("Consumer de ejemplo");
        System.out.println("aleatorio: " + aleatorio.get());

        Calculadora calculadora = (sumandoA, sumandoB) -> sumandoA + sumandoB;
        System.out.println("Calculadora personalizada: " + calculadora.sumar(3, 4));
    }
}
