package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 7 (dificil): Multiplicacion de matrices (A ? B)
 * 
 * Suponemos que ambas matrices son cuadradas y del mismo tamano.
 * El elemento resultado[fila][columna] se calcula como la suma de
 * A[fila][k] * B[k][columna] para k de 0 a N-1.
 * 
 * A =                B =                A ? B =
 *  [1][2][3]          [1][0][0]          [1][2][3]
 *  [4][5][6]          [0][1][0]          [4][5][6]
 *  [7][8][9]          [0][0][1]          [7][8][9]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_ArrayBidimensionalMultiplicarMatrices {
    
    /**
     * Devuelve la matriz resultado de multiplicar A por B.
     * Se asume que ambas son cuadradas y del mismo tamano.
     * @param matrizA Primera matriz
     * @param matrizB Segunda matriz
     * @return Nueva matriz con el producto A ? B
     */
    public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int tamano = matrizA.length;
        int[][] resultado = new int[tamano][tamano];
        
        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                int acumulador = 0;
                for (int k = 0; k < tamano; k++) {
                    acumulador = acumulador + matrizA[fila][k] * matrizB[k][columna];
                }
                resultado[fila][columna] = acumulador;
            }
        }
        
        return resultado;
    }
    
    /**
     * Muestra una matriz por pantalla, una fila por linea.
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
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        
        System.out.println("Matriz A:");
        mostrar(matrizA);
        
        System.out.println("\nMatriz B (identidad):");
        mostrar(matrizB);
        
        System.out.println("\nA ? B:");
        mostrar(multiplicarMatrices(matrizA, matrizB));
    }
}
