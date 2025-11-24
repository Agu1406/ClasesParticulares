package madrid.iescalderonbarca.f_ejerciciosConocidos;

/**
 * Ejercicio 2: En el ejercicio anterior sumar sólo las posiciones impares.
 * Dado estos dos arrays: {1, 3, 5, 7, 8} y {1, 2, 3, 4, 5}
 * obtener el array resultado sumando solo las posiciones impares (índices 1, 3, 5, ...).
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio2_Arrays_SumarPosicionesImpares_RESUELTO {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 8};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] resultado = new int[array1.length];

        // Bucle que recorre todas las posiciones de los arrays
        for (int indice = 0; indice < array1.length; indice++) {
            // Si la posición es impar (índice 1, 3, 5, ...), sumar los elementos
            if (indice % 2 != 0) {
                resultado[indice] = array1[indice] + array2[indice];
            } else {
                // Si la posición es par, dejar el resultado en 0
                resultado[indice] = 0;
            }
        }

        System.out.print("Array 1: ");
        imprimirArray(array1);
        System.out.print("Array 2: ");
        imprimirArray(array2);
        System.out.print("Resultado (solo posiciones impares): ");
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

