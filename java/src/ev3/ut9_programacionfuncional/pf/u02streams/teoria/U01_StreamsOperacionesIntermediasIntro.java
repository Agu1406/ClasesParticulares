package ev3.ut9_programacionfuncional.pf.u02streams.teoria;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Teoria: operaciones intermedias (PDF diapos 20-23).
 *
 * <p><b>Que son?</b> Pasos del pipeline que transforman el stream pero no lo cierran:
 * devuelven otro Stream. Son lazy (perezosas): no hacen trabajo hasta una terminal.</p>
 *
 * <p><b>Las mas usadas:</b></p>
 * <ul>
 *   <li>{@code filter} - se queda con elementos que cumplen condicion.</li>
 *   <li>{@code map} - transforma cada elemento (uno a uno).</li>
 *   <li>{@code flatMap} - aplana estructuras anidadas (List de List -> stream plano).</li>
 *   <li>{@code distinct} - elimina duplicados (segun equals).</li>
 *   <li>{@code sorted} - ordena (natural o con Comparator).</li>
 *   <li>{@code limit} / {@code skip} - trocean la secuencia (paginacion simple).</li>
 * </ul>
 *
 * <p><b>Por que mejor que bucles encadenados?</b> Cada paso tiene nombre estandar;
 * no mezclas logica de filtrado, deduplicado y corte en un unico for confuso.</p>
 *
 * <p><b>map vs flatMap:</b> map convierte cada elemento; flatMap convierte cada elemento
 * en otro stream y los fusiona. Ejemplo: lista de listas de numeros -> un solo stream
 * de numeros.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_StreamsOperacionesIntermediasIntro {

    public static void main(String[] args) {
        List<String> nombres = List.of("Ana Lopez", "Bob", "Ana Garcia", "Carlos", "Ana");

        List<String> troceado = nombres.stream()
                .filter(texto -> texto.contains(" "))
                .distinct()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("filter + distinct + limit: " + troceado);

        List<Integer> longitudes = nombres.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("map length: " + longitudes);

        List<List<Integer>> anidadas = Arrays.asList(
                Arrays.asList(1, 5, 9),
                Arrays.asList(6, 8, 11));
        List<Integer> cuadrados = anidadas.stream()
                .flatMap(listaInterna -> listaInterna.stream())
                .map(numero -> numero * numero)
                .collect(Collectors.toList());
        System.out.println("flatMap + map cuadrado: " + cuadrados);
    }
}
