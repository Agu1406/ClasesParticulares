package ev2.ut4.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 4: Array bidimensional basico
 * Crea un array bidimensional de numeros enteros de 3 filas y 3 columnas,
 * asignales valores y muestra todos los valores usando bucles for anidados
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
public class Ejercicio4_ArrayBidimensional {
    public static void main(String[] args) {
        // Crear array bidimensional de 3 filas y 3 columnas
        int[][] tablaNumeros = new int[3][3];
        
        // Asignar valores
        tablaNumeros[0][0] = 1;
        tablaNumeros[0][1] = 2;
        tablaNumeros[0][2] = 3;
        tablaNumeros[1][0] = 4;
        tablaNumeros[1][1] = 5;
        tablaNumeros[1][2] = 6;
        tablaNumeros[2][0] = 7;
        tablaNumeros[2][1] = 8;
        tablaNumeros[2][2] = 9;
        
        // Mostrar todos los valores usando bucles for anidados
        System.out.println("Matriz 3x3:");
        for (int fila = 0; fila < tablaNumeros.length; fila++) {
            for (int columna = 0; columna < tablaNumeros[fila].length; columna++) {
                System.out.print(tablaNumeros[fila][columna] + " ");
            }
            System.out.println(); // Salto de linea despues de cada fila
        }
    }
}

