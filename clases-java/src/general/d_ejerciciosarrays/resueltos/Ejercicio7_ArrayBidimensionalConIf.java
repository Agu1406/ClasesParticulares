package madrid.iescalderonbarca.d_ejerciciosarrays;

/**
 * Ejercicio 7: Array bidimensional con condicional if
 * Crea un array bidimensional de números enteros de 3 filas y 3 columnas
 * y asígnales valores. Usa bucles for anidados para recorrer el array y
 * un if para mostrar solo los números mayores que 5
 * 
 * Array bidimensional de 3x3:
 * 
 *          Columnas
 *          [0][1][2]
 * Fila [0] [ ][ ][ ]
 * Fila [1] [ ][ ][ ]
 * Fila [2] [ ][ ][ ]
 * 
 * Para acceder a una posición: array[fila][columna]
 * Ejemplo: array[0][1] es la posición fila 0, columna 1
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio7_ArrayBidimensionalConIf {
    public static void main(String[] args) {
        // Crear array bidimensional de 3 filas y 3 columnas y asignar valores
        int[][] matriz = {
            {2, 8, 3},
            {6, 1, 9},
            {4, 7, 5}
        };
        
        // Recorrer el array y mostrar solo los números mayores que 5
        System.out.println("Números mayores que 5:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 5) {
                    System.out.println("Fila " + i + ", Columna " + j + ": " + matriz[i][j]);
                }
            }
        }
    }
}

