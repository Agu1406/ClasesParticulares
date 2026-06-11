package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * Recorridos de arrays con bucles anidados (2D) y for-each (1D).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_RecorridosArrays {

    public static void main(String[] args) {

        int[] notas = {10, 20, 30, 40};

        int[][] tablero = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        /*
         * Recorrer matriz 2D con bucles anidados.
         */
        System.out.println("Tablero completo:");
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }

        /*
         * for-each en 1D: recorre cada elemento sin usar el indice.
         */
        System.out.print("Notas con for-each: ");
        for (int nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println();
    }
}
