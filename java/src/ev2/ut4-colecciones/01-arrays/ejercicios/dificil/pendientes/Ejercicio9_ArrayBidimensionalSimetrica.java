package general.arrays.dificil;

/**
 * Ejercicio 9 (dificil): Comprobar si una matriz cuadrada es simetrica
 * 
 * Crea un array bidimensional CUADRADO de enteros de 4x4 con valores.
 * 
 * Una matriz es SIMETRICA cuando coincide con su transpuesta, es decir,
 * cuando para todas las posiciones se cumple:
 *      matriz[fila][columna] == matriz[columna][fila]
 * 
 * En la practica: si "doblaramos" la matriz por la diagonal principal,
 * los dos triangulos coincidirian.
 * 
 * Crea una funcion llamada esSimetrica(int[][] matriz) que devuelva:
 *  - true si la matriz es simetrica.
 *  - false si encuentra cualquier posicion que rompa la simetria.
 * 
 * Pista:
 *  - Recorre la matriz con dos bucles for anidados.
 *  - En cuanto encuentres una posicion donde matriz[i][j] != matriz[j][i],
 *    puedes devolver false directamente (con return) y dejar de buscar.
 *  - Si los bucles terminan sin encontrar diferencias, devuelve true.
 *  - Truco para no comparar dos veces el mismo par: en el bucle interno
 *    empieza columna en (fila + 1), asi solo recorres el triangulo
 *    superior (por encima de la diagonal). Es mas eficiente.
 * 
 * Crea tambien una funcion mostrar(int[][] matriz) que muestre la
 * matriz por pantalla.
 * 
 * Desde el main, prueba con dos matrices: una simetrica y otra que no
 * lo sea. Muestralas y di si son simetricas o no.
 * 
 * Ejemplo de matriz SIMETRICA (la diagonal divide dos triangulos iguales):
 * 
 *  [1][2][3][4]
 *  [2][5][6][7]
 *  [3][6][8][9]
 *  [4][7][9][0]
 * 
 * Ejemplo de matriz NO simetrica:
 * 
 *  [1][2][3][4]
 *  [2][5][6][7]
 *  [9][6][8][9]    <- el 9 rompe la simetria (deberia ser un 3)
 *  [4][7][9][0]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_ArrayBidimensionalSimetrica {
    public static void main(String[] args) {
        
    }
}
