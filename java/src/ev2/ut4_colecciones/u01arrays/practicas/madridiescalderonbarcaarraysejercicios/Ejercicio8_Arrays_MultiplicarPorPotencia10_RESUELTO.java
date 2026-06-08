package ev2.ut4_colecciones.u01arrays.practicas.madridiescalderonbarcaarraysejercicios;

/**
 * Ejercicio 8: A partir del siguiente array {2, 3, 4, 7, 8} obtener otro donde
 * la primera posicion se multiplique por 10, la segunda por 100, la tercera por 1000 etc...
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_Arrays_MultiplicarPorPotencia10_RESUELTO {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 7, 8};
        int[] resultado = new int[array.length];
        
        // Bucle que recorre el array para multiplicar cada elemento por una potencia de 10
        for (int indice = 0; indice < array.length; indice++) {
            // Calcular 10^(indice+1) para cada posicion (10, 100, 1000, ...)
            int multiplicador = (int) Math.pow(10, indice + 1);
            resultado[indice] = array[indice] * multiplicador;
        }

        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.print("Array multiplicado (10, 100, 1000, ...): ");
        imprimirArray(resultado);
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

