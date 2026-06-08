package ev2.ut4_colecciones.u01arrays.ejercicios.pendientes;

/**
 * Ejercicio 8 (medio): Eliminar duplicados de un array unidimensional
 * 
 * Crea un array de numeros enteros con 8 elementos donde haya valores
 * repetidos a proposito.
 * 
 * Crea una funcion llamada eliminarDuplicados que reciba el array como
 * parametro y devuelva un NUEVO array que contenga cada valor solo una
 * vez (en el orden en el que aparecen por primera vez).
 * El array original NO se debe modificar.
 * 
 * Idea para resolverlo SIN usar estructuras avanzadas:
 *  1) Crea un array auxiliar del mismo tamano que el original
 *     (en el peor caso no hay duplicados y caben todos).
 *  2) Lleva un contador de cuantos valores unicos has guardado hasta ahora.
 *  3) Para cada elemento del array original, recorre el array auxiliar
 *     desde 0 hasta el contador y comprueba si ya esta dentro.
 *     - Si NO esta, lo anades en la posicion [contador] y aumentas
 *       el contador en 1.
 *     - Si ya esta, no haces nada.
 *  4) Al final, crea un array definitivo del tamano exacto del
 *     contador y copia solo esas posiciones.
 * 
 * Pista: te puede ayudar tener una funcion auxiliar contiene(int[] array,
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
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_ArrayEliminarDuplicados {
    public static void main(String[] args) {
        
    }
}
