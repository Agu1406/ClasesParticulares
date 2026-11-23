package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * <p><b>OBJETIVO:</b> localizar la primera posicion del minimo y la ultima del
 * maximo, y calcular una media saltando esas dos posiciones (estilo U2A9).</p>
 *
 * <p>Practica en {@code E32_ArrayPrimeraMinUltimaMax} y en la practica
 * Galicia CIFP JudgesScore (U2A9).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U07_IndicesExtremos {

    public static void main(String[] args) {
        int[] notas = {8, 6, 9, 7, 10};
        int indiceMin;
        int indiceMax;
        int indice;
        int total;
        double media;

        /*
         * Primera nota mas baja: comparamos con <
         * (si hay empate, nos quedamos con la primera).
         *
         * notas => [8][6][9][7][10]
         *               ^
         *            indice 1
         */
        indiceMin = 0;
        for (indice = 1; indice < notas.length; indice++) {
            if (notas[indice] < notas[indiceMin]) {
                indiceMin = indice;
            }
        }

        /*
         * Ultima nota mas alta: comparamos con >=
         * (si hay empate, avanzamos y nos quedamos con la ultima).
         *
         * notas => [8][6][9][7][10]
         *                         ^
         *                      indice 4
         */
        indiceMax = 0;
        for (indice = 1; indice < notas.length; indice++) {
            if (notas[indice] >= notas[indiceMax]) {
                indiceMax = indice;
            }
        }

        /*
         * Media sin esas dos posiciones (aunque el valor se repita).
         * Aqui: sin 6 y sin 10 -> (8+9+7)/3 = 8.0
         */
        total = 0;
        for (indice = 0; indice < notas.length; indice++) {
            if (indice != indiceMin && indice != indiceMax) {
                total = total + notas[indice];
            }
        }
        media = (double) total / (notas.length - 2);

        System.out.println("Primera minima en posicion: " + indiceMin
                + " (valor " + notas[indiceMin] + ")");
        System.out.println("Ultima maxima en posicion: " + indiceMax
                + " (valor " + notas[indiceMax] + ")");
        System.out.println("Media sin extremos: " + media);
    }
}
