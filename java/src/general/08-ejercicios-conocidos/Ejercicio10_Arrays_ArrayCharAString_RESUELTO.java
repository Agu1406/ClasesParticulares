package madrid.iescalderonbarca.g_ejerciciosConocidos;

/**
 * Ejercicio 10: Dado el siguiente array de caracteres {'P', 'a', 'l', 'a', 'b', 'r', 'a'}
 * convertirlo en un String.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio10_Arrays_ArrayCharAString_RESUELTO {
    public static void main(String[] args) {
        char[] array = {'P', 'a', 'l', 'a', 'b', 'r', 'a'};
        
        // Método 1: Usando el constructor de String
        String palabra = new String(array);

        System.out.print("Array de caracteres: ");
        imprimirArrayChar(array);
        System.out.println("String resultante: " + palabra);
    }

    /**
     * Función que imprime un array de caracteres en formato ['c', 'a', 'r', ...]
     */
    private static void imprimirArrayChar(char[] array) {
        System.out.print("[");
        // Bucle que recorre todos los caracteres del array para imprimirlos
        for (int indice = 0; indice < array.length; indice++) {
            System.out.print("'" + array[indice] + "'");
            // Si no es el último elemento, imprimir una coma y un espacio
            if (indice < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

