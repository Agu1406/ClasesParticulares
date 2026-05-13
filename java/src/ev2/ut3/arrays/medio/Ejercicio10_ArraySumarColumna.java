package general.arrays.medio;

/**
 * Ejercicio 10 (medio): Sumar una columna de una matriz
 * 
 * Crea un array bidimensional de enteros de 3 filas y 4 columnas y
 * asígnale valores a cada posición.
 * 
 * Crea una función llamada sumarColumna que reciba:
 *  - La matriz.
 *  - El número de columna a sumar.
 * 
 * La función debe recorrer SOLO esa columna en todas las filas y
 * devolver la suma de sus valores.
 * 
 * Pista: a diferencia de sumar una fila (donde el bucle recorría las
 * columnas dejando fija la fila), aquí se hace al revés:
 *  - La columna se queda fija (la que nos pasan).
 *  - El bucle for recorre las FILAS de 0 a matriz.length.
 *  - En cada vuelta sumamos matriz[fila][columna].
 * 
 * Desde el main, usa un bucle for para llamar a la función con todas
 * las columnas (0, 1, 2, 3) y mostrar la suma de cada una:
 *  - "Suma de la columna 0: ..."
 *  - "Suma de la columna 1: ..."
 *  - ...
 * 
 * Array bidimensional de 3x4:
 * 
 *          Columnas
 *          [0][1][2][3]
 * Fila [0] [ 1][ 2][ 3][ 4]
 * Fila [1] [ 5][ 6][ 7][ 8]
 * Fila [2] [ 9][10][11][12]
 * 
 * Suma columna 0: 1 + 5 + 9 = 15
 * Suma columna 1: 2 + 6 + 10 = 18
 * Suma columna 2: 3 + 7 + 11 = 21
 * Suma columna 3: 4 + 8 + 12 = 24
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio10_ArraySumarColumna {
    public static void main(String[] args) {
        
    }
}
