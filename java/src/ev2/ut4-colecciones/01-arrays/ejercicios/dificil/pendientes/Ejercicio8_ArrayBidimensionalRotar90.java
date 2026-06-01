package general.arrays.dificil;

/**
 * Ejercicio 8 (difícil): Rotar una matriz cuadrada 90° a la derecha
 * 
 * Crea un array bidimensional CUADRADO de enteros de 4x4 con valores.
 * 
 * Crea una función llamada rotar90Derecha(int[][] matriz) que devuelva
 * una NUEVA matriz del mismo tamaño con la matriz original rotada
 * 90 grados en el sentido de las agujas del reloj.
 * El array original NO se debe modificar.
 * 
 * La clave es saber a qué posición va a parar cada elemento al rotar:
 *  - Si el original tiene tamaño N, el elemento que estaba en la
 *    posición [fila][columna] del original va a parar a la posición
 *    [columna][N - 1 - fila] de la nueva matriz.
 * 
 * Otra forma equivalente de verlo: la nueva matriz es la transpuesta
 * de la original pero con sus columnas en orden inverso.
 * 
 * También crea una función mostrar(int[][] matriz) que recorra la
 * matriz con dos bucles for anidados y muestre cada fila en una línea.
 * 
 * Desde el main, muestra la matriz original y la rotada 90°.
 * 
 * Ejemplo:
 * 
 * Original:                Rotada 90° a la derecha:
 *  [ 1][ 2][ 3][ 4]          [13][ 9][ 5][ 1]
 *  [ 5][ 6][ 7][ 8]          [14][10][ 6][ 2]
 *  [ 9][10][11][12]          [15][11][ 7][ 3]
 *  [13][14][15][16]          [16][12][ 8][ 4]
 * 
 * Fíjate cómo lo que era la primera COLUMNA del original ahora es la
 * primera FILA de la rotada (pero de abajo a arriba).
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_ArrayBidimensionalRotar90 {
    public static void main(String[] args) {
        
    }
}
