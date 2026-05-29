package general.arrays.dificil;

/**
 * Ejercicio 9 (difícil): Comprobar si una matriz cuadrada es simétrica
 * 
 * Crea un array bidimensional CUADRADO de enteros de 4x4 con valores.
 * 
 * Una matriz es SIMÉTRICA cuando coincide con su transpuesta, es decir,
 * cuando para todas las posiciones se cumple:
 *      matriz[fila][columna] == matriz[columna][fila]
 * 
 * En la práctica: si "dobláramos" la matriz por la diagonal principal,
 * los dos triángulos coincidirían.
 * 
 * Crea una función llamada esSimetrica(int[][] matriz) que devuelva:
 *  - true si la matriz es simétrica.
 *  - false si encuentra cualquier posición que rompa la simetría.
 * 
 * Pista:
 *  - Recorre la matriz con dos bucles for anidados.
 *  - En cuanto encuentres una posición donde matriz[i][j] != matriz[j][i],
 *    puedes devolver false directamente (con return) y dejar de buscar.
 *  - Si los bucles terminan sin encontrar diferencias, devuelve true.
 *  - Truco para no comparar dos veces el mismo par: en el bucle interno
 *    empieza columna en (fila + 1), así solo recorres el triángulo
 *    superior (por encima de la diagonal). Es más eficiente.
 * 
 * Crea también una función mostrar(int[][] matriz) que muestre la
 * matriz por pantalla.
 * 
 * Desde el main, prueba con dos matrices: una simétrica y otra que no
 * lo sea. Muéstralas y di si son simétricas o no.
 * 
 * Ejemplo de matriz SIMÉTRICA (la diagonal divide dos triángulos iguales):
 * 
 *  [1][2][3][4]
 *  [2][5][6][7]
 *  [3][6][8][9]
 *  [4][7][9][0]
 * 
 * Ejemplo de matriz NO simétrica:
 * 
 *  [1][2][3][4]
 *  [2][5][6][7]
 *  [9][6][8][9]    ← el 9 rompe la simetría (debería ser un 3)
 *  [4][7][9][0]
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_ArrayBidimensionalSimetrica {
    public static void main(String[] args) {
        
    }
}
