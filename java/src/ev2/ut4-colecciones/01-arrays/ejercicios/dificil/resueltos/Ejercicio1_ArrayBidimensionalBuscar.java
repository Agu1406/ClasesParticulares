package general.arrays.resueltos.dificil;

/**
 * Ejercicio 1 (dificil): Buscar un valor en una matriz 2D y devolver su posicion
 * 
 * Devuelve [fila, columna] de la primera aparicion o {-1, -1} si no esta.
 * Ademas cuenta cuantas veces aparece el valor en toda la matriz.
 * 
 *          Columnas
 *          [0][1][2][3]
 * Fila [0] [ 4][ 6][ 5][ 7]
 * Fila [1] [ 2][ 6][ 8][ 6]
 * Fila [2] [ 1][ 9][ 3][ 6]
 * 
 * Buscar el 6 -> fila 0, columna 1 / Ocurrencias: 4
 * Buscar el 99 -> no encontrado
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_ArrayBidimensionalBuscar {
    
    /**
     * Busca la primera aparicion de valor en la matriz.
     * @param matriz Matriz donde buscar
     * @param valor Valor a buscar
     * @return Array con [fila, columna] de la primera aparicion, o {-1, -1}
     */
    public static int[] buscarPosicion(int[][] matriz, int valor) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == valor) {
                    return new int[]{fila, columna};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    /**
     * Cuenta cuantas veces aparece el valor en toda la matriz.
     * @param matriz Matriz donde contar
     * @param valor Valor cuya frecuencia queremos saber
     * @return Numero de apariciones del valor en la matriz
     */
    public static int contarOcurrencias(int[][] matriz, int valor) {
        int contador = 0;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == valor) {
                    contador++;
                }
            }
        }
        return contador;
    }
    
    public static void main(String[] args) {
        int[][] matriz = {
            {4, 6, 5, 7},
            {2, 6, 8, 6},
            {1, 9, 3, 6}
        };
        
        int buscado = 6;
        int[] posicion = buscarPosicion(matriz, buscado);
        int ocurrencias = contarOcurrencias(matriz, buscado);
        
        if (posicion[0] == -1) {
            System.out.println("Valor " + buscado + " no encontrado en la matriz");
        } else {
            System.out.println("Valor " + buscado + " encontrado en fila " + posicion[0] + ", columna " + posicion[1]);
        }
        System.out.println("Aparece " + ocurrencias + " veces en la matriz");
        
        int inexistente = 99;
        int[] posicionInexistente = buscarPosicion(matriz, inexistente);
        if (posicionInexistente[0] == -1) {
            System.out.println("Valor " + inexistente + " no encontrado en la matriz");
        } else {
            System.out.println("Valor " + inexistente + " encontrado en fila " + posicionInexistente[0] + ", columna " + posicionInexistente[1]);
        }
    }
}
