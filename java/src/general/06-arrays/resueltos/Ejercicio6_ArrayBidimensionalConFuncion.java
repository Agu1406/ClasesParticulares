package madrid.iescalderonbarca.e_ejerciciosarrays;

/**
 * Ejercicio 6: Array bidimensional con función
 * Crea un array bidimensional de números enteros de 3 filas y 3 columnas
 * y asígnales valores. Crea una función llamada mostrarArrayBidimensional
 * que reciba el array como parámetro y muestre todos sus valores usando
 * bucles for anidados. Llámala desde el main
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
public class Ejercicio6_ArrayBidimensionalConFuncion {
    
    /**
     * Función que muestra todos los valores del array bidimensional
     * @param tablaNumeros Array bidimensional de enteros a mostrar
     */
    public static void mostrarArrayBidimensional(int[][] tablaNumeros) {
        System.out.println("Matriz 3x3:");
        for (int fila = 0; fila < tablaNumeros.length; fila++) {
            for (int columna = 0; columna < tablaNumeros[fila].length; columna++) {
                System.out.print(tablaNumeros[fila][columna] + " ");
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }
    
    public static void main(String[] args) {
        // Crear array bidimensional de 3 filas y 3 columnas y asignar valores
        int[][] tablaNumeros = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Llamar a la función mostrarArrayBidimensional
        mostrarArrayBidimensional(tablaNumeros);
    }
}

