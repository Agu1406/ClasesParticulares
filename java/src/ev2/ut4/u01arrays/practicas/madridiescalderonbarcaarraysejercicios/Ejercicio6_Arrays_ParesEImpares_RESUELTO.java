package ev2.ut4.u01arrays.practicas.madridiescalderonbarcaarraysejercicios;

/**
 * Ejercicio 6: A partir del siguiente array {2, 3, 4, 7, 8, 10, 11} obtener dos mas,
 * uno que contenga solo los elementos pares y otro los impares.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_Arrays_ParesEImpares_RESUELTO {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 7, 8, 10, 11};
        
        // Contar cuantos elementos son pares e impares
        int pares = 0;
        int impares = 0;
        
        // Bucle que recorre el array para contar cuantos elementos son pares e impares
        for (int indice = 0; indice < array.length; indice++) {
            // Si el elemento es divisible entre 2, es par
            if (array[indice] % 2 == 0) {
                pares++;
            } else {
                // Si no es divisible entre 2, es impar
                impares++;
            }
        }

        // Crear los nuevos arrays con el tamano correcto
        int[] arrayPares = new int[pares];
        int[] arrayImpares = new int[impares];
        
        int indicePares = 0;
        int indiceImpares = 0;
        
        // Bucle que recorre el array original para llenar los nuevos arrays
        for (int indice = 0; indice < array.length; indice++) {
            // Si el elemento es par, agregarlo al array de pares
            if (array[indice] % 2 == 0) {
                arrayPares[indicePares] = array[indice];
                indicePares++;
            } else {
                // Si el elemento es impar, agregarlo al array de impares
                arrayImpares[indiceImpares] = array[indice];
                indiceImpares++;
            }
        }

        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.print("Elementos pares: ");
        imprimirArray(arrayPares);
        System.out.print("Elementos impares: ");
        imprimirArray(arrayImpares);
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

