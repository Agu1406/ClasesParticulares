package general.arrays.medio;

/**
 * Ejercicio 8 (medio): Eliminar duplicados de un array unidimensional
 * 
 * Crea un array de números enteros con 8 elementos donde haya valores
 * repetidos a propósito.
 * 
 * Crea una función llamada eliminarDuplicados que reciba el array como
 * parámetro y devuelva un NUEVO array que contenga cada valor solo una
 * vez (en el orden en el que aparecen por primera vez).
 * El array original NO se debe modificar.
 * 
 * Idea para resolverlo SIN usar estructuras avanzadas:
 *  1) Crea un array auxiliar del mismo tamaño que el original
 *     (en el peor caso no hay duplicados y caben todos).
 *  2) Lleva un contador de cuántos valores únicos has guardado hasta ahora.
 *  3) Para cada elemento del array original, recorre el array auxiliar
 *     desde 0 hasta el contador y comprueba si ya está dentro.
 *     - Si NO está, lo añades en la posición [contador] y aumentas
 *       el contador en 1.
 *     - Si ya está, no haces nada.
 *  4) Al final, crea un array definitivo del tamaño exacto del
 *     contador y copia solo esas posiciones.
 * 
 * Pista: te puede ayudar tener una función auxiliar contiene(int[] array,
 * int hasta, int valor) que devuelva true si el valor aparece en las
 * primeras 'hasta' posiciones del array auxiliar.
 * 
 * Desde el main, muestra el array original y el array sin duplicados.
 * 
 * int[] ejemplo = {4, 6, 5, 4, 2, 6, 8, 5}
 * 
 * Original     = [4][6][5][4][2][6][8][5]
 * Sin duplicados = [4][6][5][2][8]
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio8_ArrayEliminarDuplicados {
    public static void main(String[] args) {
        
    }
}
