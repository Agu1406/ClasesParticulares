import java.util.Arrays;

/**
 * U2. Exame práctico. E3: o xogador con máis puntos.
 *
 * <p><b>OBJETIVO:</b> completar {@code topScorer} y su JavaDoc en
 * {@code U2E3_usuario.java}.</p>
 *
 * <p><b>SOLUCION:</b> recorrer el array guardando el índice del máximo; si hay
 * empate se queda el primero ({@code >}, no {@code >=}).</p>
 *
 * @author Agustin. A. Marquez. Pina
 */
class TopScorer {

    /**
     * Devolve a posición do xogador con máis puntos (desde 0).
     * Se o máximo se repite, devolve a primeira posición.
     *
     * @param points puntos de cada xogador (polo menos un elemento)
     * @return a posición do máximo, a primeira se hai empate
     */
    public static int topScorer(int[] points) {
        int posicionMaxima;
        int posicion;

        posicionMaxima = 0;
        for (posicion = 1; posicion < points.length; posicion++) {
            if (points[posicion] > points[posicionMaxima]) {
                posicionMaxima = posicion;
            }
        }
        return posicionMaxima;
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
