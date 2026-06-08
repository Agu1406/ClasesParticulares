package ev3.ut9_programacionfuncional.pf.u02streams.teoria;

import java.util.List;

/**
 * Teoria: parallelStream (puente UT6).
 *
 * <p><b>Que es?</b> Un stream que puede procesar trozos de datos en paralelo usando
 * el ForkJoinPool interno de Java. La API es casi identica a {@code stream()}.</p>
 *
 * <p><b>Por que se usa?</b> Para acelerar operaciones pesadas sobre colecciones
 * grandes cuando map/reduce son puros (sin efectos secundarios) y asociativos.</p>
 *
 * <p><b>Ventaja teorica:</b> mejor uso de multicore sin escribir Threads manualmente.</p>
 *
 * <p><b>Limitaciones importantes:</b></p>
 * <ul>
 *   <li>En listas pequenas el coste de coordinar hilos puede hacerlo mas lento.</li>
 *   <li>Si map/reduce mutan estado compartido, hay condiciones de carrera.</li>
 *   <li>El orden puede no ser determinista si dependes de side effects.</li>
 * </ul>
 *
 * <p><b>Demo:</b> misma suma de cuadrados secuencial y paralela; el resultado debe coincidir.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see ut6 03-concurrencia-multihilo
 */
public class U01_StreamsParalelosIntro {

    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumaSecuencial = numeros.stream()
                .map(numero -> numero * numero)
                .reduce(0, Integer::sum);

        int sumaParalela = numeros.parallelStream()
                .map(numero -> numero * numero)
                .reduce(0, Integer::sum);

        System.out.println("Secuencial: " + sumaSecuencial);
        System.out.println("Paralelo:   " + sumaParalela);
    }
}
