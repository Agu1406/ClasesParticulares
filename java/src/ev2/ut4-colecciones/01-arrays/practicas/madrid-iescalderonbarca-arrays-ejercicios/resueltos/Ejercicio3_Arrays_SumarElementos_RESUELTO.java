package madrid.iescalderonbarca.ejercicios.arrays;

/**
 * Ejercicio 3: Obtener la suma de los elementos del siguiente array {1, 4, 6, 10, -3, 4, 6, -5}
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_Arrays_SumarElementos_RESUELTO {
    public static void main(String[] args) {
        int[] array = {1, 4, 6, 10, -3, 4, 6, -5};
        int suma = 0;

        // Bucle que recorre todos los elementos del array para sumarlos
        for (int indice = 0; indice < array.length; indice++) {
            suma += array[indice];
        }

        System.out.print("Array: ");
        imprimirArray(array);
        System.out.println("Suma de todos los elementos: " + suma);
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

