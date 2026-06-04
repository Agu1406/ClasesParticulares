package ev3.ut9.pf.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Teoria: imperativo vs Stream API (PDF diapos 16-18).
 *
 * <p><b>Que es un Stream?</b> Una secuencia de elementos sobre la que encadenas
 * operaciones (filtrar, transformar, ordenar...) sin escribir bucles explicitos. No
 * almacena datos como una List: es un pipeline que recorre la fuente bajo demanda.</p>
 *
 * <p><b>Por que se usa?</b> Para expresar transformaciones sobre colecciones de forma
 * declarativa: dices QUE quieres (nombres con J, ordenados, en mayusculas) en lugar
 * de COMO paso a paso (for, if, otra lista, otro for).</p>
 *
 * <p><b>Ventajas frente al enfoque tradicional:</b></p>
 * <ul>
 *   <li>Menos listas temporales y menos indices manuales.</li>
 *   <li>Cada operacion tiene nombre (filter, map, sorted): el codigo se lee como frase.</li>
 *   <li>Facilita reutilizar patrones y reducir errores off-by-one en bucles.</li>
 *   <li>Base para paralelismo ({@code parallelStream}) y operaciones agregadas del BOE.</li>
 * </ul>
 *
 * <p><b>Limitaciones:</b> curva de aprendizaje; depuracion menos lineal que un for;
 * abuso de streams complejos puede ser peor que un bucle claro. La fuente original
 * inmutable no se modifica: el resultado suele ser otra coleccion.</p>
 *
 * <p><b>Demo:</b> mismo ejercicio del PDF (nombres con J) en version imperativa y con
 * {@code filter -> sorted -> map -> collect}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class StreamsFundamentosIntro {

    public static void main(String[] args) {
        List<String> nombres = List.of("Alice", "Bob", "John", "Jane");

        System.out.println("--- Imperativo ---");
        System.out.println(filtrarImperativo(nombres));

        System.out.println("--- Stream ---");
        System.out.println(filtrarConStream(nombres));
    }

    private static List<String> filtrarImperativo(List<String> nombres) {
        List<String> nombresFiltrados = new ArrayList<>();
        for (String nombre : nombres) {
            if (nombre.startsWith("J")) {
                nombresFiltrados.add(nombre);
            }
        }
        Collections.sort(nombresFiltrados);
        List<String> listaResultado = new ArrayList<>();
        for (String nombreFiltrado : nombresFiltrados) {
            listaResultado.add(nombreFiltrado.toUpperCase());
        }
        return listaResultado;
    }

    private static List<String> filtrarConStream(List<String> nombres) {
        return nombres.stream()
                .filter(nombre -> nombre.startsWith("J"))
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
