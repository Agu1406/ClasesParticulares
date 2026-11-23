import java.util.Arrays;

/**
 * U2. Exame práctico. E3: o xogador con máis puntos.
 *
 * @author usuario
 */
class TopScorer {

    /**
     * Provisional: substitúe este comentario polo de topScorer.
     */
    public static int topScorer(int[] points) {
        // Provisional: substitúe esta liña polo teu código
        return -1;
    }

    /**
     * Amosa a posición do xogador con máis puntos e se coincide coa
     * esperada.
     *
     * @param points   puntos que se proban
     * @param expected resultado que debería devolver topScorer
     */
    public static void check(int[] points, int expected) {
        int result = topScorer(points);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("topScorer " + Arrays.toString(points)
                + " -> " + result + " [" + verdict + "]");
    }

    public static void main(String[] args) {
        check(new int[] {12, 25, 8}, 1);
        check(new int[] {30, 5, 30}, 0);
        check(new int[] {7}, 0);
    }
}
