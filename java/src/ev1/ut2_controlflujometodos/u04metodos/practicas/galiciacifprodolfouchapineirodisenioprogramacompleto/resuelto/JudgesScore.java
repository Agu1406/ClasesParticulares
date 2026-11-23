package ev1.ut2_controlflujometodos.u04metodos.practicas.galiciacifprodolfouchapineirodisenioprogramacompleto.resuelto;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2A9 (diseno de un programa completo): implementar
 * {@code firstMinIndex}, {@code lastMaxIndex} y {@code finalScore}; el resto
 * ({@code readInt}, lectura/escritura y pruebas) ya esta.</p>
 *
 * <p><b>SOLUCION:</b> primera minima con {@code <}; ultima maxima con {@code >=};
 * media sin esas dos posiciones (una de cada extremo aunque se repita).</p>
 *
 * <p>Enunciado: {@code galicia-cifprodolfouchapineiro-diseno-programa-completo.pdf}
 * (castellano) y {@code galicia-cifprodolfouchapineiro-diseno-programa-completo-gl.pdf}
 * (gallego), en la carpeta de la practica.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 15/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class JudgesScore {

    private static final int MIN_JUDGES = 3;
    private static final int MAX_JUDGES = 7;
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 10;

    /**
     * Busca la nota mas baja.
     *
     * @param scores notas, al menos una
     * @return la posicion de la primera nota mas baja
     */
    public static int firstMinIndex(int[] scores) {
        int index = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[index]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Busca la nota mas alta.
     *
     * @param scores notas, al menos dos
     * @return la posicion de la ultima nota mas alta. Si todas son
     *         iguales, es la ultima, distinta de la de firstMinIndex
     */
    public static int lastMaxIndex(int[] scores) {
        int index = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] >= scores[index]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Calcula la nota del ejercicio.
     *
     * @param scores notas, al menos tres
     * @return la media de las notas sin las de las posiciones que devuelven
     *         firstMinIndex y lastMaxIndex
     */
    public static double finalScore(int[] scores) {
        // se descarta una nota de cada extremo, aunque se repita
        int low = firstMinIndex(scores);
        int high = lastMaxIndex(scores);
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            if (i != low && i != high) {
                total += scores[i];
            }
        }
        return (double) total / (scores.length - 2);
    }

    /**
     * Lee un entero de un intervalo y repite la pregunta hasta obtenerlo.
     *
     * @param teclado lector del teclado
     * @param prompt  pregunta que se muestra antes de cada lectura
     * @param min     valor minimo admitido
     * @param max     valor maximo admitido
     * @return el primer entero leido que esta entre min y max
     */
    public static int readInt(Scanner teclado, String prompt,
                              int min, int max) {
        int value = 0;
        boolean valid;
        do {
            System.out.print(prompt);
            valid = teclado.hasNextInt();
            if (valid) {
                value = teclado.nextInt();
                valid = value >= min && value <= max;
            }
            teclado.nextLine(); // descarta el resto de la linea
            if (!valid) {
                System.out.println("Escribe un entero de " + min
                        + " a " + max);
            }
        } while (!valid);
        return value;
    }

    /**
     * Lee la nota de cada juez.
     *
     * @param teclado lector del teclado
     * @param judges  numero de jueces
     * @return un array nuevo con las notas, en el orden de los jueces
     */
    public static int[] readScores(Scanner teclado, int judges) {
        int[] scores = new int[judges];
        for (int i = 0; i < scores.length; i++) {
            String prompt = "Nota del juez " + (i + 1) + ": ";
            scores[i] = readInt(teclado, prompt, MIN_SCORE, MAX_SCORE);
        }
        return scores;
    }

    /**
     * Escribe una tabla con el numero y la nota de cada juez. Las dos
     * notas que no cuentan llevan la palabra descartada.
     *
     * @param scores notas, al menos dos
     */
    public static void printScores(int[] scores) {
        int low = firstMinIndex(scores);
        int high = lastMaxIndex(scores);
        System.out.printf("%4s %4s%n", "Juez", "Nota");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%4d %4d", i + 1, scores[i]);
            if (i == low || i == high) {
                System.out.print(" descartada");
            }
            System.out.println();
        }
    }

    /**
     * Muestra las posiciones de las notas descartadas y si coinciden con las
     * esperadas.
     *
     * @param scores       notas que se prueban
     * @param expectedLow  posicion que deberia devolver firstMinIndex
     * @param expectedHigh posicion que deberia devolver lastMaxIndex
     */
    public static void checkDiscarded(int[] scores, int expectedLow,
                                      int expectedHigh) {
        int low = firstMinIndex(scores);
        int high = lastMaxIndex(scores);
        boolean ok = low == expectedLow && high == expectedHigh;
        String verdict = ok ? "OK" : "ERROR";
        System.out.println("min/max " + Arrays.toString(scores)
                + " -> " + low + " " + high + " [" + verdict + "]");
    }

    /**
     * Muestra la nota de un ejercicio y si coincide con la esperada.
     *
     * @param scores   notas que se prueban
     * @param expected resultado que deberia devolver finalScore
     */
    public static void checkScore(int[] scores, double expected) {
        double result = finalScore(scores);
        String verdict = result == expected ? "OK" : "ERROR";
        System.out.println("finalScore " + Arrays.toString(scores)
                + " -> " + result + " [" + verdict + "]");
    }

    public static void main(String[] args) {
        checkDiscarded(new int[]{8, 6, 9, 7, 10}, 1, 4);
        checkDiscarded(new int[]{9, 6, 4}, 2, 0);
        checkDiscarded(new int[]{3, 8, 3, 6}, 0, 1);
        checkDiscarded(new int[]{9, 4, 9, 6}, 1, 2);
        checkDiscarded(new int[]{7, 7, 7, 7}, 0, 3);
        checkDiscarded(new int[]{10, 0, 10, 0, 6, 7, 8}, 1, 2);

        checkScore(new int[]{8, 6, 9, 7, 10}, 8.0);
        checkScore(new int[]{9, 6, 4}, 6.0);
        checkScore(new int[]{3, 8, 3, 6}, 4.5);
        checkScore(new int[]{9, 4, 9, 6}, 7.5);
        checkScore(new int[]{7, 7, 7, 7}, 7.0);
        checkScore(new int[]{10, 0, 10, 0, 6, 7, 8}, 6.2);

        Scanner teclado = new Scanner(System.in);
        int judges = readInt(teclado, "Numero de jueces: ",
                MIN_JUDGES, MAX_JUDGES);
        int[] scores = readScores(teclado, judges);
        teclado.close();

        System.out.println();
        printScores(scores);
        System.out.printf("Nota del ejercicio: %.2f%n",
                finalScore(scores));
    }
}
