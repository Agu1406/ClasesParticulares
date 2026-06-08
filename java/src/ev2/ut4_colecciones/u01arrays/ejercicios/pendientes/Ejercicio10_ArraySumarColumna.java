package ev2.ut4_colecciones.u01arrays.ejercicios.pendientes;

/**
 * Ejercicio 10 (medio): Sumar una columna de una matriz
 * 
 * Crea un array bidimensional de enteros de 3 filas y 4 columnas y
 * asignale valores a cada posicion.
 * 
 * Crea una funcion llamada sumarColumna que reciba:
 *  - La matriz.
 *  - El numero de columna a sumar.
 * 
 * La funcion debe recorrer SOLO esa columna en todas las filas y
 * devolver la suma de sus valores.
 * 
 * Pista: a diferencia de sumar una fila (donde el bucle recorria las
 * columnas dejando fija la fila), aqui se hace al reves:
 *  - La columna se queda fija (la que nos pasan).
 *  - El bucle for recorre las FILAS de 0 a matriz.length.
 *  - En cada vuelta sumamos matriz[fila][columna].
 * 
 * Desde el main, usa un bucle for para llamar a la funcion con todas
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
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_ArraySumarColumna {
    public static void main(String[] args) {
        
    }
}
