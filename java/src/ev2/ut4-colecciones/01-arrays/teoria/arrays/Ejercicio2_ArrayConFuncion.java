package ev2.ut3.arrays;
/**
 * Ejercicio 2: Array unidimensional con función
 * Crea un array de números enteros con 5 elementos y asígnales valores.
 * Crea una función llamada mostrarArray que reciba el array como parámetro
 * y muestre todos sus valores usando un bucle for. Llámala desde el main
 *
 * int[] ejemplo = new int{4, 6, 5, 7, 2}
 *
 * Eso significa que el Array
 * tiene 5 cajitas, una cosa es el
 * valor dentro de las cajitas y
 * otra la posición que tienen
 * las cajitas, ejemplo
 *
 * Valores = [4][6][5][7][2]
 * Posiciones = [0][1][2][3][4]
 *
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_ArrayConFuncion {
    /**
     * Función principal de nuestro programa, se llama "main"
     * porque significa "principal" en inglés, es como el
     * director de la orquesta.
     */
    static void main() {
        /*
         * Valores      => [2][3][4][5][6]
         * Posiciones   => [0][1][2][3][4]
         */
        int [] arrayNumeros = {2, 3, 4, 5, 6};

        /*
         * Introduzco / paso / meto el array de números en
         * la función para que puede ser utilizado por la
         * misma.
         */
        mostrarArrays(arrayNumeros);

    }

    /**
     * Función encargada de imprimir/mostrar los valores de un
     * array de números enteros.
     */
    static void mostrarArrays(int [] arrayNumeros) {
        System.out.println("¡Imprimiendo los valores del array!");
        for (int posicion = 0 ; posicion < arrayNumeros.length; posicion++) {
            System.out.println("Estos son los valores: "  + arrayNumeros[posicion]);
        }

    }
}
