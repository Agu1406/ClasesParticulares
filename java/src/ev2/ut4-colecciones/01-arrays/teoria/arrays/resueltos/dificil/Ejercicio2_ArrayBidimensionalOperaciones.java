package general.arrays.resueltos.dificil;

/**
 * Ejercicio 2 (difícil): Operaciones con matrices cuadradas (transpuesta,
 * diagonal y suma de matrices)
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
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_ArrayBidimensionalOperaciones {
    
    /**
     * Devuelve una nueva matriz que es la transpuesta de la recibida.
     * El elemento [fila][columna] pasa a estar en [columna][fila].
     * @param matriz Matriz cuadrada de entrada
     * @return Nueva matriz transpuesta
     */
    public static int[][] transpuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] resultado = new int[columnas][filas];
        
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                resultado[columna][fila] = matriz[fila][columna];
            }
        }
        
        return resultado;
    }
    
    /**
     * Suma los elementos de la diagonal principal (posiciones [i][i]).
     * @param matriz Matriz cuadrada de entrada
     * @return Suma de la diagonal principal
     */
    public static int sumaDiagonalPrincipal(int[][] matriz) {
        int suma = 0;
        for (int indice = 0; indice < matriz.length; indice++) {
            suma = suma + matriz[indice][indice];
        }
        return suma;
    }
    
    /**
     * Devuelve una nueva matriz cuyo contenido es la suma celda a celda
     * de matrizA y matrizB. Se asume que ambas tienen el mismo tamaño.
     * @param matrizA Primera matriz
     * @param matrizB Segunda matriz
     * @return Nueva matriz con la suma de ambas
     */
    public static int[][] sumarMatrices(int[][] matrizA, int[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        int[][] resultado = new int[filas][columnas];
        
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                resultado[fila][columna] = matrizA[fila][columna] + matrizB[fila][columna];
            }
        }
        
        return resultado;
    }
    
    /**
     * Muestra una matriz por pantalla, una fila por línea.
     * @param matriz Matriz a mostrar
     */
    public static void mostrar(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                System.out.print(matriz[fila][columna] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] matrizA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] matrizB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        
        System.out.println("Matriz A:");
        mostrar(matrizA);
        
        System.out.println("\nTranspuesta de A:");
        mostrar(transpuesta(matrizA));
        
        System.out.println("\nSuma de la diagonal principal de A: " + sumaDiagonalPrincipal(matrizA));
        
        System.out.println("\nMatriz A + Matriz B:");
        mostrar(sumarMatrices(matrizA, matrizB));
    }
}
