package general.arrays.resueltos.dificil;

/**
 * Ejercicio 10 (difícil): Recorrer una matriz en espiral
 * 
 * Recorre los elementos de la matriz desde fuera hacia dentro, capa a
 * capa, usando cuatro variables para delimitar el rectángulo pendiente.
 * 
 *  [ 1][ 2][ 3][ 4]
 *  [ 5][ 6][ 7][ 8]
 *  [ 9][10][11][12]
 *  [13][14][15][16]
 * 
 * Recorrido en espiral:
 *   1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_ArrayBidimensionalEspiral {
    
    /**
     * Recorre la matriz en espiral desde fuera hacia dentro e imprime
     * cada elemento separado por espacios.
     * @param matriz Matriz a recorrer
     */
    public static void recorrerEnEspiral(int[][] matriz) {
        int filaArriba = 0;
        int filaAbajo = matriz.length - 1;
        int columnaIzquierda = 0;
        int columnaDerecha = matriz[0].length - 1;
        
        while (filaArriba <= filaAbajo && columnaIzquierda <= columnaDerecha) {
            for (int columna = columnaIzquierda; columna <= columnaDerecha; columna++) {
                System.out.print(matriz[filaArriba][columna] + " ");
            }
            filaArriba++;
            
            for (int fila = filaArriba; fila <= filaAbajo; fila++) {
                System.out.print(matriz[fila][columnaDerecha] + " ");
            }
            columnaDerecha--;
            
            if (filaArriba <= filaAbajo) {
                for (int columna = columnaDerecha; columna >= columnaIzquierda; columna--) {
                    System.out.print(matriz[filaAbajo][columna] + " ");
                }
                filaAbajo--;
            }
            
            if (columnaIzquierda <= columnaDerecha) {
                for (int fila = filaAbajo; fila >= filaArriba; fila--) {
                    System.out.print(matriz[fila][columnaIzquierda] + " ");
                }
                columnaIzquierda++;
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        System.out.print("Recorrido en espiral: ");
        recorrerEnEspiral(matriz);
    }
}
