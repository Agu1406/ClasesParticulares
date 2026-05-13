package general.arrays.resueltos.medio;

/**
 * Ejercicio 10 (medio): Sumar una columna de una matriz
 * 
 * Suma los elementos de una columna concreta recorriendo todas las
 * filas y dejando la columna fija.
 * 
 *          Columnas
 *          [0][1][2][3]
 * Fila [0] [ 1][ 2][ 3][ 4]
 * Fila [1] [ 5][ 6][ 7][ 8]
 * Fila [2] [ 9][10][11][12]
 * 
 * Suma columna 0: 15  /  columna 1: 18  /  columna 2: 21  /  columna 3: 24
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio10_ArraySumarColumna {
    
    /**
     * Suma todos los elementos de una columna concreta de la matriz.
     * @param matriz Matriz a recorrer
     * @param columna Índice de la columna que queremos sumar
     * @return Suma de los elementos de esa columna
     */
    public static int sumarColumna(int[][] matriz, int columna) {
        int suma = 0;
        for (int fila = 0; fila < matriz.length; fila++) {
            suma = suma + matriz[fila][columna];
        }
        return suma;
    }
    
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        int numeroDeColumnas = matriz[0].length;
        for (int columna = 0; columna < numeroDeColumnas; columna++) {
            int suma = sumarColumna(matriz, columna);
            System.out.println("Suma de la columna " + columna + ": " + suma);
        }
    }
}
