package general.arrays.resueltos.medio;

/**
 * Ejercicio 5: Array bidimensional con funcion
 * Crea un array bidimensional de numeros enteros de 3 filas y 3 columnas
 * y asignales valores. Crea una funcion llamada mostrarArrayBidimensional
 * que reciba el array como parametro y muestre todos sus valores usando
 * bucles for anidados. Llamala desde el main
 * 
 * Array bidimensional de 3x3:
 * 
 *          Columnas
 *          [0][1][2]
 * Fila [0] [ ][ ][ ]
 * Fila [1] [ ][ ][ ]
 * Fila [2] [ ][ ][ ]
 * 
 * Para acceder a una posicion: array[fila][columna]
 * Ejemplo: array[0][1] es la posicion fila 0, columna 1
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_ArrayBidimensionalConFuncion {
    
    /**
     * Funcion que muestra todos los valores del array bidimensional
     * @param tablaNumeros Array bidimensional de enteros a mostrar
     */
    public static void mostrarArrayBidimensional(int[][] tablaNumeros) {
        System.out.println("Matriz 3x3:");
        for (int fila = 0; fila < tablaNumeros.length; fila++) {
            for (int columna = 0; columna < tablaNumeros[fila].length; columna++) {
                System.out.print(tablaNumeros[fila][columna] + " ");
            }
            System.out.println(); // Salto de linea despues de cada fila
        }
    }
    
    public static void main(String[] args) {
        // Crear array bidimensional de 3 filas y 3 columnas y asignar valores
        int[][] tablaNumeros = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Llamar a la funcion mostrarArrayBidimensional
        mostrarArrayBidimensional(tablaNumeros);
    }
}

