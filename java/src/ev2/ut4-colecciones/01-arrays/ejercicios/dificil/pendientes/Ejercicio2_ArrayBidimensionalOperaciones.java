package general.arrays.dificil;

/**
 * Ejercicio 2 (dificil): Operaciones con matrices cuadradas (transpuesta,
 * diagonal y suma de matrices)
 * 
 * Crea dos arrays bidimensionales de enteros, ambos CUADRADOS de 3x3.
 * Asignales valores a cada posicion.
 * 
 * Crea tres funciones:
 * 
 *  1) transpuesta(int[][] matriz)
 *     - Devuelve una nueva matriz que es la transpuesta de la original.
 *     - La transpuesta intercambia filas por columnas: el elemento que
 *       estaba en [fila][columna] pasa a estar en [columna][fila].
 * 
 *  2) sumaDiagonalPrincipal(int[][] matriz)
 *     - Devuelve la suma de los elementos de la diagonal principal.
 *     - La diagonal principal son las posiciones donde fila == columna,
 *       es decir matriz[0][0], matriz[1][1], matriz[2][2]...
 * 
 *  3) sumarMatrices(int[][] matrizA, int[][] matrizB)
 *     - Devuelve una nueva matriz del mismo tamano donde cada celda
 *       es la suma de la celda equivalente en A y en B:
 *       resultado[fila][columna] = matrizA[fila][columna] + matrizB[fila][columna]
 *     - Para este ejercicio asumimos que ambas matrices son del mismo tamano.
 * 
 * Tambien crea una funcion mostrar(int[][] matriz) que recorra la matriz
 * con dos bucles for anidados y muestre cada fila en una linea con los
 * valores separados por espacios o tabuladores.
 * 
 * Desde el main, muestra la matrizA, su transpuesta, la suma de su
 * diagonal principal, y el resultado de matrizA + matrizB.
 * 
 * Ejemplo:
 * 
 * matrizA =          transpuesta(matrizA) =      
 *  [1][2][3]          [1][4][7]                  
 *  [4][5][6]          [2][5][8]                  
 *  [7][8][9]          [3][6][9]                  
 * 
 * Diagonal principal de matrizA: 1 + 5 + 9 = 15
 * 
 * matrizB =          matrizA + matrizB =
 *  [9][8][7]          [10][10][10]
 *  [6][5][4]          [10][10][10]
 *  [3][2][1]          [10][10][10]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_ArrayBidimensionalOperaciones {
    public static void main(String[] args) {
        
    }
}
