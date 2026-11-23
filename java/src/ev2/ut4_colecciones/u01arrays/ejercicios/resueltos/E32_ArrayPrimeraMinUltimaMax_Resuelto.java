package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> con un array de al menos 3 enteros, escribe
 * {@code primeraMinima}, {@code ultimaMaxima} y {@code mediaSinExtremos}.
 * Ejemplo {@code {8, 6, 9, 7, 10}}: minima en 1, maxima en 4, media 8.0
 * (sin la 6 ni la 10).</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> minima con {@code <} (primera); maxima con {@code >=}
 * (ultima); media sumando todas las posiciones distintas de esas dos.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E32_ArrayPrimeraMinUltimaMax_Resuelto {

    /**
     * Posicion de la primera nota mas baja.
     *
     * @param valores array con al menos un elemento
     * @return indice de la primera minima
     */
    public static int primeraMinima(int[] valores) {
        int indiceMin;
        int indice;

        indiceMin = 0;
        for (indice = 1; indice < valores.length; indice++) {
            if (valores[indice] < valores[indiceMin]) {
                indiceMin = indice;
            }
        }
        return indiceMin;
    }

    /**
     * Posicion de la ultima nota mas alta.
     *
     * @param valores array con al menos dos elementos
     * @return indice de la ultima maxima
     */
    public static int ultimaMaxima(int[] valores) {
        int indiceMax;
        int indice;

        indiceMax = 0;
        for (indice = 1; indice < valores.length; indice++) {
            if (valores[indice] >= valores[indiceMax]) {
                indiceMax = indice;
            }
        }
        return indiceMax;
    }

    /**
     * Media sin la primera minima ni la ultima maxima.
     *
     * @param valores array con al menos tres elementos
     * @return media de las notas que quedan
     */
    public static double mediaSinExtremos(int[] valores) {
        int indiceMin;
        int indiceMax;
        int total;
        int indice;

        indiceMin = primeraMinima(valores);
        indiceMax = ultimaMaxima(valores);
        total = 0;

        for (indice = 0; indice < valores.length; indice++) {
            if (indice != indiceMin && indice != indiceMax) {
                total = total + valores[indice];
            }
        }

        return (double) total / (valores.length - 2);
    }

    public static void main(String[] args) {
        int[] notas = {8, 6, 9, 7, 10};
        int indiceMin;
        int indiceMax;
        double media;

        indiceMin = primeraMinima(notas);
        indiceMax = ultimaMaxima(notas);
        media = mediaSinExtremos(notas);

        System.out.println("Primera minima: posicion " + indiceMin
                + " valor " + notas[indiceMin]);
        System.out.println("Ultima maxima: posicion " + indiceMax
                + " valor " + notas[indiceMax]);
        System.out.println("Media sin extremos: " + media);
    }
}
