package general.arrays.dificil;

/**
 * Ejercicio 7 (difícil): Multiplicación de matrices (A × B)
 * 
 * Crea dos matrices CUADRADAS de enteros de 3x3 con valores cualesquiera.
 * 
 * Crea una función llamada multiplicarMatrices(int[][] A, int[][] B) que
 * devuelva la matriz resultante de multiplicar A por B (en ese orden).
 * 
 * Recuerda cómo funciona la multiplicación de matrices:
 *  - Si A tiene F filas y N columnas, y B tiene N filas y C columnas,
 *    el resultado tiene F filas y C columnas.
 *  - Para este ejercicio asumimos que ambas matrices son CUADRADAS y
 *    del mismo tamaño, así que el resultado también lo será.
 *  - El elemento resultado[fila][columna] se calcula así:
 *       resultado[fila][columna] = SUMA para k de 0 a N-1 de
 *                                  A[fila][k] * B[k][columna]
 *  - Es decir, necesitas TRES bucles for anidados:
 *       for fila in 0..F:
 *         for columna in 0..C:
 *           acumulador = 0
 *           for k in 0..N:
 *             acumulador += A[fila][k] * B[k][columna]
 *           resultado[fila][columna] = acumulador
 * 
 * También crea una función mostrar(int[][] matriz) que recorra la
 * matriz con dos bucles for anidados y muestre cada fila en una línea.
 * 
 * Desde el main, muestra A, B y A × B.
 * 
 * Ejemplo:
 * 
 * A =                B =                A × B =
 *  [1][2][3]          [1][0][0]          [1][2][3]
 *  [4][5][6]          [0][1][0]          [4][5][6]
 *  [7][8][9]          [0][0][1]          [7][8][9]
 * 
 * (Multiplicar por la matriz identidad devuelve la misma matriz, es
 * una buena forma de comprobar que la función está bien hecha).
 * 
 * Otro ejemplo:
 * 
 * A =                B =                A × B =
 *  [1][2]             [5][6]             [1*5+2*7][1*6+2*8]   =   [19][22]
 *  [3][4]             [7][8]             [3*5+4*7][3*6+4*8]       [43][50]
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_ArrayBidimensionalMultiplicarMatrices {
    public static void main(String[] args) {
        
    }
}
