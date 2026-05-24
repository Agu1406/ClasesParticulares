package general.ejerciciosconocidos;

/**
 * Ejercicio 9: Dados estos dos arrays: {1, 3, 5, 7, 9} y {6, 4, 2, 1, 3}
 * multiplicar un array por otro (posición a posición) y dividir el resultado entre 10 (todas las posiciones).
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio9_Arrays_MultiplicarYDividir_RESUELTO {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {6, 4, 2, 1, 3};
        int[] resultado = new int[array1.length];

        // Bucle que recorre ambos arrays para multiplicar posición a posición y dividir entre 10
        for (int indice = 0; indice < array1.length; indice++) {
            resultado[indice] = (array1[indice] * array2[indice]) / 10;
        }

        System.out.print("Array 1: ");
        imprimirArray(array1);
        System.out.print("Array 2: ");
        imprimirArray(array2);
        System.out.print("Resultado ((array1 * array2) / 10): ");
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

