package ev3.ut9.pf.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Teoria: crear streams (PDF diapos 19).
 *
 * <p><b>Que es la fuente de un stream?</b> Cualquier origen de datos de la que obtienes
 * un {@code Stream}: una coleccion ({@code list.stream()}), valores sueltos
 * ({@code Stream.of}), un array ({@code Arrays.stream}), o secuencias generadas
 * ({@code iterate}, {@code generate}).</p>
 *
 * <p><b>Por que importa?</b> Antes de filter/map necesitas abrir el pipeline. Elegir
 * la fuente correcta evita convertir todo a List intermedia.</p>
 *
 * <p><b>Tipos principales:</b></p>
 * <ul>
 *   <li>{@code Stream.of} - cantidad finita conocida de elementos.</li>
 *   <li>{@code Arrays.stream} - partir de array primitivo u objeto.</li>
 *   <li>{@code Stream.iterate} - secuencia por regla (ej. n, n+1, n+2...); suele ir con limit.</li>
 *   <li>{@code Stream.generate} - valores producidos bajo demanda (aleatorios, IDs); siempre con limit.</li>
 * </ul>
 *
 * <p><b>Frente al enfoque tradicional:</b> un for con contador manual para generar
 * numeros o aleatorios se sustituye por iterate/generate + limit, mas declarativo.</p>
 *
 * <p><b>Cuidado:</b> iterate y generate sin limit son infinitos; hay que cerrar con
 * limit o una operacion terminal que pare (findFirst, etc.).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class StreamsGeneracionIntro {

    public static void main(String[] args) {
        Stream<Integer> deValores = Stream.of(1, 2, 3, 4, 5);
        System.out.print("Stream.of: ");
        deValores.forEach(numero -> System.out.print(numero + " "));
        System.out.println();

        int[] numbers = {1, 2, 3, 4, 5};
        System.out.print("Arrays.stream: ");
        Arrays.stream(numbers).forEach(numero -> System.out.print(numero + " "));
        System.out.println();

        System.out.print("Stream.iterate (5 numeros): ");
        Stream.iterate(1, numero -> numero + 1).limit(5).forEach(numero -> System.out.print(numero + " "));
        System.out.println();

        System.out.print("Stream.generate (3 aleatorios): ");
        Stream.generate(Math::random).limit(3).forEach(r -> System.out.printf("%.3f ", r));
        System.out.println();
    }
}
