package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 9 (dificil): Comprobar si una matriz cuadrada es simetrica
 * 
 * Una matriz es simetrica si matriz[i][j] == matriz[j][i] para todas
 * las posiciones. Basta con recorrer el triangulo superior y comparar
 * con su reflejo en el triangulo inferior.
 * 
 * Simetrica:                       No simetrica:
 *  [1][2][3][4]                     [1][2][3][4]
 *  [2][5][6][7]                     [2][5][6][7]
 *  [3][6][8][9]                     [9][6][8][9]
 *  [4][7][9][0]                     [4][7][9][0]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_ArrayBidimensionalSimetrica {
    
    /**
     * Comprueba si una matriz cuadrada es simetrica respecto a su
     * diagonal principal.
     * @param matriz Matriz cuadrada de entrada
     * @return true si es simetrica, false en otro caso
     */
    public static boolean esSimetrica(int[][] matriz) {
        int tamano = matriz.length;
        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = fila + 1; columna < tamano; columna++) {
                if (matriz[fila][columna] != matriz[columna][fila]) {
                    return false;
                }
            }
        }
        return true;
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
        int[][] matrizSimetrica = {
            {1, 2, 3, 4},
            {2, 5, 6, 7},
            {3, 6, 8, 9},
            {4, 7, 9, 0}
        };
        
        int[][] matrizNoSimetrica = {
            {1, 2, 3, 4},
            {2, 5, 6, 7},
            {9, 6, 8, 9},
            {4, 7, 9, 0}
        };
        
        System.out.println("Matriz 1:");
        mostrar(matrizSimetrica);
        System.out.println("?Es simetrica? " + esSimetrica(matrizSimetrica));
        
        System.out.println("\nMatriz 2:");
        mostrar(matrizNoSimetrica);
        System.out.println("?Es simetrica? " + esSimetrica(matrizNoSimetrica));
    }
}
