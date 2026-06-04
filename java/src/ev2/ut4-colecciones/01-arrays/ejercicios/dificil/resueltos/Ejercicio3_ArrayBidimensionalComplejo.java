package general.arrays.resueltos.dificil;

/**
 * Ejercicio 3: Array bidimensional complejo con funcion y condicionales
 * Crea un array bidimensional de numeros enteros de 4 filas y 4 columnas
 * y asignales valores. Crea una funcion llamada contarPares que reciba el array
 * como parametro, use bucles for anidados y un if para contar cuantos numeros
 * pares hay en todo el array y retorne ese numero. Llamala desde el main y muestra el resultado
 * 
 * Array bidimensional de 4x4:
 * 
 *          Columnas
 *          [0][1][2][3]
 * Fila [0] [ ][ ][ ][ ]
 * Fila [1] [ ][ ][ ][ ]
 * Fila [2] [ ][ ][ ][ ]
 * Fila [3] [ ][ ][ ][ ]
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
public class Ejercicio3_ArrayBidimensionalComplejo {
    
    /**
     * Funcion que cuenta cuantos numeros pares hay en el array bidimensional
     * @param tablaNumeros Array bidimensional de enteros
     * @return Numero total de elementos pares
     */
    public static int contarPares(int[][] tablaNumeros) {
        int contador = 0;
        for (int fila = 0; fila < tablaNumeros.length; fila++) {
            for (int columna = 0; columna < tablaNumeros[fila].length; columna++) {
                if (tablaNumeros[fila][columna] % 2 == 0) {
                    contador++;
                }
            }
        }
        return contador;
    }
    
    public static void main(String[] args) {
        // Crear array bidimensional de 4 filas y 4 columnas y asignar valores
        int[][] tablaNumeros = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        // Llamar a la funcion y mostrar el resultado
        int cantidadPares = contarPares(tablaNumeros);
        System.out.println("La cantidad de numeros pares es: " + cantidadPares);
    }
}

