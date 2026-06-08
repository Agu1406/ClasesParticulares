package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 2 (medio): Ordenar un array por el metodo de la burbuja
 * 
 * Ordena un array de menor a mayor usando dos bucles for anidados
 * y comparando elementos contiguos.
 * 
 * int[] ejemplo = {5, 2, 8, 1, 9, 3}
 * 
 * Antes:    [5][2][8][1][9][3]
 * Despues:  [1][2][3][5][8][9]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_ArrayOrdenarBurbuja {
    
    /**
     * Ordena el array de menor a mayor in-place usando burbuja.
     * @param array Array a ordenar (se modifica)
     */
    public static void ordenarBurbuja(int[] array) {
        for (int pasada = 0; pasada < array.length - 1; pasada++) {
            for (int indice = 0; indice < array.length - 1 - pasada; indice++) {
                if (array[indice] > array[indice + 1]) {
                    int auxiliar = array[indice];
                    array[indice] = array[indice + 1];
                    array[indice + 1] = auxiliar;
                }
            }
        }
    }
    
    /**
     * Muestra los elementos del array separados por espacios.
     * @param array Array a mostrar
     */
    public static void mostrar(int[] array) {
        for (int indice = 0; indice < array.length; indice++) {
            System.out.print(array[indice] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] numeros = {5, 2, 8, 1, 9, 3};
        
        System.out.print("Array antes:    ");
        mostrar(numeros);
        
        ordenarBurbuja(numeros);
        
        System.out.print("Array ordenado: ");
        mostrar(numeros);
    }
}
