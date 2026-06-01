package general.arrays.resueltos.dificil;

/**
 * Ejercicio 8 (difícil): Rotar una matriz cuadrada 90° a la derecha
 * 
 * El elemento [fila][columna] del original pasa a estar en la
 * posición [columna][N - 1 - fila] de la matriz rotada.
 * 
 * Original:                Rotada 90° a la derecha:
 *  [ 1][ 2][ 3][ 4]          [13][ 9][ 5][ 1]
 *  [ 5][ 6][ 7][ 8]          [14][10][ 6][ 2]
 *  [ 9][10][11][12]          [15][11][ 7][ 3]
 *  [13][14][15][16]          [16][12][ 8][ 4]
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_ArrayBidimensionalRotar90 {
    
    /**
     * Devuelve una nueva matriz con el contenido rotado 90° a la derecha.
     * @param matriz Matriz cuadrada a rotar
     * @return Nueva matriz rotada
     */
    public static int[][] rotar90Derecha(int[][] matriz) {
        int tamano = matriz.length;
        int[][] rotada = new int[tamano][tamano];
        
        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                rotada[columna][tamano - 1 - fila] = matriz[fila][columna];
            }
        }
        
        return rotada;
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
        int[][] matriz = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        System.out.println("Matriz original:");
        mostrar(matriz);
        
        System.out.println("\nMatriz rotada 90° a la derecha:");
        mostrar(rotar90Derecha(matriz));
    }
}
