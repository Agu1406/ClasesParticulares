package ev3.ut9.pf.u01lambda.teoria;

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
 * <p><b>Demo en este archivo (en orden):</b></p>
 * <ol>
 *   <li>Contar pares: bucle for vs {@code stream().filter().count()} (primera clase).</li>
 *   <li>Sumar pares * 10: bucle vs filter + map + reduce (PDF diapos 4-5).</li>
 *   <li>Ordenar palabras: clase anonima vs lambda en {@code Comparator} (PDF diapos 9).</li>
 * </ol>
 *
 * <p><b>Guion de clase:</b> en cada demo contrasta "yo controlo cada paso" frente a
 * "describo que quiero". Lee los bloques {@code /** ... *\/} en voz alta.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_LambdaIntro {

    public static void main(String[] args) {
        demostrarContarParesTradicionalVsFuncional();
        demostrarSumaParesPorDiezTradicionalVsFuncional();
        demostrarComparatorClaseAnonimaVsLambda();
    }

    /**
     * Primera introduccion: mismo resultado, distinto estilo.
     * Lista de ejemplo: (1, 3, 5, 7, 9, 2, 4, 6, 8) -> pares: (2, 4, 6, 8) -> total: 4.
     */
    private static void demostrarContarParesTradicionalVsFuncional() {
        List<Integer> listaNumeros = List.of(1, 3, 5, 7, 9, 2, 4, 6, 8);

        System.out.println("EJEMPLO: contar numeros pares");
        System.out.println("Enfoque tradicional:");

        int totalParesTradicional = 0;
        for (int posicion = 0; posicion < listaNumeros.size(); posicion++) {
            if (listaNumeros.get(posicion) % 2 == 0) {
                totalParesTradicional++;
            }
        }
        System.out.println("En la lista hay " + totalParesTradicional + " pares.\n");

        System.out.println("Enfoque funcional (lambda + stream):");

        /**
         * Flujo mental del stream:
         * (1, 3, 5, 7, 9, 2, 4, 6, 8) --filter par--> (2, 4, 6, 8) --count--> 4
         *
         * La lambda en filter solo pregunta: "es este numero par?".
         */
        long totalParesFuncional = listaNumeros.stream()
                .filter(numero -> numero % 2 == 0)
                .count();

        System.out.println("En la lista hay " + totalParesFuncional + " pares.\n");
    }

    /** PDF diapos 4-5: sumar pares * 10 con bucle vs stream. */
    private static void demostrarSumaParesPorDiezTradicionalVsFuncional() {
        List<Integer> listaNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println("EJEMPLO: sumar (pares * 10)");
        System.out.println("Enfoque tradicional:");

        int resultadoImperativo = 0;
        for (int indice = 0; indice < listaNumeros.size(); indice++) {
            if (listaNumeros.get(indice) % 2 == 0) {
                resultadoImperativo += listaNumeros.get(indice) * 10;
            }
        }
        System.out.println("Resultado: " + resultadoImperativo);

        System.out.println("Enfoque funcional:");

        /**
         * Misma idea que contar pares, pero encadenamos transformacion (map) y acumulacion (reduce).
         * filter  -> se quedan los pares
         * map     -> cada par pasa a par * 10
         * reduce  -> los suma (Integer::sum es referencia a metodo; se ve en U01_ReferenciasMetodoIntro)
         */
        int resultadoFuncional = listaNumeros.stream()
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 10)
                .reduce(0, Integer::sum);

        System.out.println("Resultado: " + resultadoFuncional + "\n");
    }

    /** PDF diapos 9: Comparator con clase anonima vs lambda. */
    private static void demostrarComparatorClaseAnonimaVsLambda() {
        List<String> palabras = new java.util.ArrayList<>(List.of("java", "lambda", "stream", "pf"));

        System.out.println("EJEMPLO: ordenar por longitud de palabra");

        /**
         * Tradicional: clase anonima solo para implementar compare().
         * Mucho codigo para una regla simple (longitud de String).
         */
        Collections.sort(palabras, new Comparator<String>() {
            @Override
            public int compare(String primeraPalabra, String segundaPalabra) {
                return primeraPalabra.length() - segundaPalabra.length();
            }
        });
        System.out.println("Orden con clase anonima: " + palabras);

        palabras = new java.util.ArrayList<>(List.of("java", "lambda", "stream", "pf"));

        /**
         * Lambda: misma regla de negocio, menos ceremonia.
         * El compilador entiende que esto implementa Comparator porque compare es el unico metodo abstracto (SAM).
         */
        Collections.sort(palabras, (primeraPalabra, segundaPalabra) ->
                primeraPalabra.length() - segundaPalabra.length());
        System.out.println("Orden con lambda: " + palabras);
    }
}
