package madrid.iescalderonbarca.ejercicios.arrays;

/**
 * Ejercicio 5: A partir del siguiente array {2, 3, 4, 7, 8, 10, 11} obtener dos más,
 * uno que contenga solo los elementos menores de 6 y otro los mayores de 6.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_Arrays_MenoresYMayoresDe6_RESUELTO {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 7, 8, 10, 11};
        
        // Contar cuántos elementos son menores y mayores de 6
        int menores = 0;
        int mayores = 0;
        
        // Bucle que recorre el array para contar cuántos elementos son menores y mayores de 6
        for (int indice = 0; indice < array.length; indice++) {
            // Si el elemento es menor que 6, incrementar el contador de menores
            if (array[indice] < 6) {
                menores++;
            } else if (array[indice] > 6) {
                // Si el elemento es mayor que 6, incrementar el contador de mayores
                mayores++;
            }
        }

        // Crear los nuevos arrays con el tamaño correcto
        int[] menoresDe6 = new int[menores];
        int[] mayoresDe6 = new int[mayores];
        
        int indiceMenores = 0;
        int indiceMayores = 0;
        
        // Bucle que recorre el array original para llenar los nuevos arrays
        for (int indice = 0; indice < array.length; indice++) {
            // Si el elemento es menor que 6, agregarlo al array de menores
            if (array[indice] < 6) {
                menoresDe6[indiceMenores] = array[indice];
                indiceMenores++;
            } else if (array[indice] > 6) {
                // Si el elemento es mayor que 6, agregarlo al array de mayores
                mayoresDe6[indiceMayores] = array[indice];
                indiceMayores++;
            }
        }

        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.print("Elementos menores de 6: ");
        imprimirArray(menoresDe6);
        System.out.print("Elementos mayores de 6: ");
        imprimirArray(mayoresDe6);
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

