package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * Arrays bidimensionales: declaracion, asignacion y lectura de valores.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_ArraysBidimensionales {

    public static void main(String[] args) {

        /*
         * Sintaxis: tipo[][] nombre = new tipo[filas][columnas];
         *
         *        col0  col1  col2
         * fil0 [  ][  ][  ]
         * fil1 [  ][  ][  ]
         */
        int[][] matriz = new int[2][3];

        /*
         * Asignar valores: matriz[fila][columna] = valor;
         *
         *        col0  col1  col2
         * fil0 [ 1 ][ 2 ][ 3 ]
         * fil1 [ 4 ][ 5 ][ 6 ]
         */
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;

        System.out.println("Valor en fila 1, columna 2: " + matriz[1][2]);

        /*
         * Crear matriz 2D con valores iniciales (como el array 1D con llaves).
         *
         *        col0  col1  col2
         * fil0 [ 0 ][ 1 ][ 0 ]
         * fil1 [ 1 ][ 0 ][ 1 ]
         * fil2 [ 0 ][ 1 ][ 0 ]
         */
        int[][] tablero = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        /*
         * En 2D: length = numero de filas; matriz[fila].length = columnas de esa fila.
         */
        System.out.println("Tablero: " + tablero.length + " filas y "
                + tablero[0].length + " columnas.");
    }
}
