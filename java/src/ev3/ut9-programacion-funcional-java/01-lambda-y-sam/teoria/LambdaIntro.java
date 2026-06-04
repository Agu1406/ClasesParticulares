package ev3.ut9.pf.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Teoria: expresiones lambda (PDF diapos 7-9).
 *
 * <p><b>Que es una lambda?</b> Una funcion anonima: un trozo de comportamiento con
 * parametros y cuerpo, sin declarar una clase nueva. Sintaxis tipica:
 * {@code (param1, param2) -> expresion} o {@code param -> { bloque; }}.</p>
 *
 * <p><b>Por que se usa?</b> Porque muchas APIs de Java (Comparator, Runnable, streams)
 * piden "algo que haga X" una sola vez. Antes escribias una clase anonima entera; la
 * lambda dice lo mismo en una linea cuando la logica es corta.</p>
 *
 * <p><b>Por que puede ser mejor que el enfoque tradicional?</b></p>
 * <ul>
 *   <li>Menos codigo repetitivo: no hace falta {@code new Comparator<>() { ... }}.</li>
 *   <li>La intencion queda junta al sitio donde se usa (ordenar, filtrar, etc.).</li>
 *   <li>Facilita encadenar operaciones (filter, map) legibles de arriba abajo.</li>
 * </ul>
 *
 * <p><b>Cuando NO es obligatoria?</b> Si la logica es larga o reutilizable en muchos
 * sitios, un metodo con nombre propio o una clase suele ser mas claro que una lambda
 * enorme.</p>
 *
 * <p><b>Relacion con SAM:</b> la lambda solo compila si el tipo esperado es una interfaz
 * funcional (un solo metodo abstracto). Eso lo vemos en {@code InterfacesFuncionalesIntro}.</p>
 *
 * <p><b>Demo en este archivo:</b> (1) mismo calculo con bucle for vs stream+lambda;
 * (2) mismo Comparator con clase anonima vs lambda.</p>
 *
 * <p><b>Guion de clase:</b> define lambda en una frase, muestra la sintaxis, ejecuta
 * main y contrasta resultados iguales con codigo distinto.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class LambdaIntro {

    public static void main(String[] args) {
        // Primera parte: mismo resultado con bucle imperativo y con stream declarativo.
        demostrarSumaImperativoVsFuncional();
        // Segunda parte: mismo criterio de ordenacion, primero verboso y luego compacto.
        demostrarComparatorClaseAnonimaVsLambda();
    }

    /** PDF diapos 4-5: sumar pares * 10 con bucle vs stream. */
    private static void demostrarSumaImperativoVsFuncional() {
        List<Integer> listaNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // Enfoque tradicional: yo controlo indice, if y acumulador.
        int resultadoImperativo = 0;
        for (int indice = 0; indice < listaNumeros.size(); indice++) {
            if (listaNumeros.get(indice) % 2 == 0) {
                resultadoImperativo += listaNumeros.get(indice) * 10;
            }
        }

        // Enfoque funcional: describo que quiero (pares, *10, suma) con lambdas.
        int resultadoFuncional = listaNumeros.stream()
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 10)
                .reduce(0, Integer::sum);

        System.out.println("Imperativo: " + resultadoImperativo);
        System.out.println("Funcional (stream): " + resultadoFuncional);
    }

    /** PDF diapos 9: Comparator con clase anonima vs lambda. */
    private static void demostrarComparatorClaseAnonimaVsLambda() {
        List<String> palabras = new java.util.ArrayList<>(List.of("java", "lambda", "stream", "pf"));

        // Tradicional: clase anonima solo para implementar compare().
        Collections.sort(palabras, new Comparator<String>() {
            @Override
            public int compare(String primeraPalabra, String segundaPalabra) {
                return primeraPalabra.length() - segundaPalabra.length();
            }
        });
        System.out.println("Orden anonimo: " + palabras);

        palabras = new java.util.ArrayList<>(List.of("java", "lambda", "stream", "pf"));
        // Lambda: misma regla de negocio, menos ceremonia sintactica.
        Collections.sort(palabras, (primeraPalabra, segundaPalabra) -> primeraPalabra.length() - segundaPalabra.length());
        System.out.println("Orden lambda: " + palabras);
    }
}
