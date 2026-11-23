package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * <p><b>OBJETIVO:</b> sumar dos arrays de la misma longitud posicion a posicion
 * y guardar el resultado en un tercer array.</p>
 *
 * <p>Practica en {@code E10_ArraySumarArrays}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_SumarArrays {

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5};
        int[] arrayB = {10, 20, 30, 40, 50};
        int[] suma;
        int indice;

        /*
         * Misma longitud. En cada indice i:
         * suma[i] = arrayA[i] + arrayB[i]
         *
         * A    => [1 ][2 ][3 ][4 ][5 ]
         * B    => [10][20][30][40][50]
         * suma => [11][22][33][44][55]
         */
        suma = new int[arrayA.length];
        for (indice = 0; indice < arrayA.length; indice++) {
            suma[indice] = arrayA[indice] + arrayB[indice];
        }

        System.out.print("Suma A+B: ");
        for (indice = 0; indice < suma.length; indice++) {
            System.out.print(suma[indice] + " ");
        }
        System.out.println();
    }
}
