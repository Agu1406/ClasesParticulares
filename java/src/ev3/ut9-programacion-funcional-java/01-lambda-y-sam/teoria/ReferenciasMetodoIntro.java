package ev3.ut9.pf.lambda;

import java.util.List;

/**
 * Teoria: referencias a metodos (PDF diapos 12).
 *
 * <p><b>Que es?</b> Sintaxis {@code Clase::metodo} o {@code objeto::metodo}. Es un
 * atajo cuando la lambda solo delega en un metodo ya existente sin anadir logica extra.</p>
 *
 * <p><b>Ejemplo mental:</b> {@code nombre -> System.out.println(nombre)} es equivalente
 * a {@code System.out::println} porque el cuerpo de la lambda solo llama a ese metodo.</p>
 *
 * <p><b>Por que se usa?</b> Reduce ruido visual y deja claro "uso el metodo println tal
 * cual". Muy comun con {@code String::length}, {@code Integer::sum}, {@code List::stream}.</p>
 *
 * <p><b>Ventaja frente a lambda explicita:</b> menos parametros repetidos y codigo mas
 * legible cuando no hay transformacion intermedia. No es "mejor" en rendimiento; es
 * estilo y claridad.</p>
 *
 * <p><b>Cuando preferir lambda:</b> si necesitas manipular el parametro antes de llamar
 * al metodo ({@code x -> System.out.println(">> " + x)} no se puede reducir a ::).</p>
 *
 * <p><b>Demo:</b> mismo forEach con {@code System.out::println} y con lambda equivalente.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class ReferenciasMetodoIntro {

    public static void main(String[] args) {
        List<String> nombres = List.of("Alice", "Bob", "John");

        System.out.println("Con referencia a metodo:");
        nombres.forEach(System.out::println);

        System.out.println("Equivalente con lambda:");
        nombres.forEach(nombre -> System.out.println(nombre));
    }
}
