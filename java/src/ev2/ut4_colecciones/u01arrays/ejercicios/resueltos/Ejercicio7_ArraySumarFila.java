package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 7: Sumar una fila de un array bidimensional con funcion
 * Crea un array bidimensional de numeros enteros de 3 filas y 3 columnas
 * y asignales valores. Crea una funcion llamada sumarFila que reciba el array
 * y un numero de fila como parametros, use un bucle for para sumar todos los
 * elementos de esa fila y retorne el resultado. Llamala desde el main para
 * sumar la primera fila (fila 0)
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
public class Ejercicio7_ArraySumarFila {
    
    /**
     * Funcion que suma todos los elementos de una fila especifica
     * @param tablaNumeros Array bidimensional de enteros
     * @param fila Numero de fila a sumar (0-indexed)
     * @return Suma de los elementos de la fila
     */
    public static int sumarFila(int[][] tablaNumeros, int fila) {
        int suma = 0;
        for (int columna = 0; columna < tablaNumeros[fila].length; columna++) {
            suma += tablaNumeros[fila][columna];
        }
        return suma;
    }
    
    public static void main(String[] args) {
        // Crear array bidimensional de 3 filas y 3 columnas y asignar valores
        int[][] tablaNumeros = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Llamar a la funcion para sumar la primera fila (fila 0)
        int sumaFila0 = sumarFila(tablaNumeros, 0);
        System.out.println("La suma de la fila 0 es: " + sumaFila0);
    }
}

