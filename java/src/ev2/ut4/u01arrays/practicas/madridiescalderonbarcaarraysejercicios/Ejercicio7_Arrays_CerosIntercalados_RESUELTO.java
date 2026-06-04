package ev2.ut4.u01arrays.practicas.madridiescalderonbarcaarraysejercicios;

/**
 * Ejercicio 7: A partir del siguiente array {2, 3, 4, 7, 8, 10, 11} obtener otro
 * con ceros intercalados entre sus posiciones {2, 0, 3, 0, 4, 0, ...}
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_Arrays_CerosIntercalados_RESUELTO {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 7, 8, 10, 11};
        
        // El nuevo array tendra el doble de tamano menos 1 (porque no hay cero al final)
        int[] resultado = new int[array.length * 2 - 1];
        
        int indiceResultado = 0;
        // Bucle que recorre el array original para intercalar ceros entre los elementos
        for (int indice = 0; indice < array.length; indice++) {
            resultado[indiceResultado] = array[indice];
            indiceResultado++;
            // Si no es el ultimo elemento, agregar un cero despues
            if (indice < array.length - 1) {
                resultado[indiceResultado] = 0;
                indiceResultado++;
            }
        }

        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.print("Array con ceros intercalados: ");
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

