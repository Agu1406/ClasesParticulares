package general.arrays.dificil;

/**
 * Ejercicio 1 (difícil): Buscar un valor en una matriz 2D y devolver su posición
 * 
 * Crea un array bidimensional de enteros de 3 filas y 4 columnas.
 * Asígnale valores a cada posición (puede haber repetidos).
 * 
 * Crea una función llamada buscarPosicion que reciba la matriz y un valor
 * y que devuelva un array de dos elementos con [fila, columna] de la PRIMERA
 * aparición del valor en la matriz. Si el valor no está en la matriz, debe
 * devolver el array {-1, -1}.
 * 
 * Pista:
 *  - Recorre la matriz con dos bucles for anidados:
 *      for (int fila = 0; fila < matriz.length; fila++)
 *          for (int columna = 0; columna < matriz[fila].length; columna++)
 *  - En cuanto encuentres el valor, devuelve new int[]{fila, columna}
 *    para parar la búsqueda (return sale de la función).
 *  - Si los bucles terminan sin encontrarlo, devuelve {-1, -1}.
 * 
 * Después, también cuenta cuántas veces aparece ese valor en TODA la matriz
 * con otra función llamada contarOcurrencias.
 * 
 * Desde el main, prueba con un valor existente y otro inexistente y muestra:
 *  - "Valor X encontrado en fila F, columna C"
 *    o "Valor X no encontrado en la matriz"
 *  - "Aparece N veces en la matriz"
 * 
 * Array bidimensional de 3x4:
 * 
 *          Columnas
 *          [0][1][2][3]
 * Fila [0] [ 4][ 6][ 5][ 7]
 * Fila [1] [ 2][ 6][ 8][ 6]
 * Fila [2] [ 1][ 9][ 3][ 6]
 * 
 * Buscar el 6 → primera aparición: fila 0, columna 1
 * Ocurrencias del 6: 4
 * Buscar el 99 → no encontrado, {-1, -1}
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_ArrayBidimensionalBuscar {
    public static void main(String[] args) {
        
    }
}
