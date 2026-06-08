package ev2.ut4_colecciones.u01arrays.practicas.madridiescalderonbarcaarraysejercicios;

/**
 * Ejercicio 4: Imprimir en pantalla los elementos del siguiente array {2, 3, 4, 7, 8, 10, 11}
 * indicando para cada uno de ellos si es par o impar.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_Arrays_ParOImpar_RESUELTO {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 7, 8, 10, 11};

        System.out.print("Array: ");
        imprimirArray(array);
        System.out.println("Analisis de elementos:");

        // Bucle que recorre todos los elementos del array para analizarlos
        for (int indice = 0; indice < array.length; indice++) {
            // Si el numero es divisible entre 2, es par
            if (array[indice] % 2 == 0) {
                System.out.println("  " + array[indice] + " es PAR");
            } else {
                // Si no es divisible entre 2, es impar
                System.out.println("  " + array[indice] + " es IMPAR");
            }
        }
    }

    /**
     * Funcion que imprime un array de enteros en formato [elemento1, elemento2, ...]
     */
    private static void imprimirArray(int[] array) {
        System.out.print("[");
        // Bucle que recorre todos los elementos del array para imprimirlos
        for (int indice = 0; indice < array.length; indice++) {
            System.out.print(array[indice]);
            // Si no es el ultimo elemento, imprimir una coma y un espacio
            if (indice < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

