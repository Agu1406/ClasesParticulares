package general.ejerciciosconocidos;

/**
 * Ejercicio 1: Dado estos dos arrays: {1, 3, 5, 7, 8} y {1, 2, 3, 4, 5}
 * obtener el array resultado de la suma de ambos (suma de elementos de la misma posición).
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_Arrays_SumarArrays_RESUELTO {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 8};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] resultado = new int[array1.length];

        // Bucle que recorre todas las posiciones de los arrays para sumar los elementos de la misma posición
        for (int indice = 0; indice < array1.length; indice++) {
            resultado[indice] = array1[indice] + array2[indice];
        }

        System.out.print("Array 1: ");
        imprimirArray(array1);
        System.out.print("Array 2: ");
        imprimirArray(array2);
        System.out.print("Resultado (suma): ");
        imprimirArray(resultado);
    }

    /**
     * Función que imprime un array de enteros en formato [elemento1, elemento2, ...]
     */
    private static void imprimirArray(int[] array) {
        System.out.print("[");
        // Bucle que recorre todos los elementos del array para imprimirlos
        for (int indice = 0; indice < array.length; indice++) {
            System.out.print(array[indice]);
            // Si no es el último elemento, imprimir una coma y un espacio
            if (indice < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

