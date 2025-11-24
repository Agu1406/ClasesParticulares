package madrid.iescalderonbarca.d_ejerciciosarrays;

/**
 * Ejercicio 11: Array bidimensional de caracteres - Verificar palíndromos
 * 
 * Crea un array bidimensional de caracteres (char) de 4 filas y 4 columnas
 * que represente una matriz de letras. Asigna valores de letras a cada
 * posición.
 * 
 * Crea una función llamada esPalindromo que reciba un array de caracteres
 * y retorne true si forma un palíndromo (se lee igual de izquierda a derecha
 * que de derecha a izquierda), o false en caso contrario.
 * 
 * Crea otra función llamada buscarPalindromos que reciba el array bidimensional
 * y use bucles for anidados para verificar si alguna fila o columna forma un
 * palíndromo.
 * Debe mostrar por pantalla qué filas o columnas son palíndromos.
 * 
 * Ejemplo de palíndromo: "ANNA", "RADAR", "OSO"
 * 
 * Array bidimensional de 4x4:
 * 
 * Columnas
 * [0][1][2][3]
 * Fila [0] [A][N][N][A] <- Esta fila es palíndromo
 * Fila [1] [R][A][D][A]
 * Fila [2] [O][S][O][S]
 * Fila [3] [L][E][T][R]
 * 
 * Para acceder a una posición: array[fila][columna]
 * Ejemplo: array[0][1] es la posición fila 0, columna 1
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio
 *      GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio11_ArrayBidimensionalCharPalindromo {
    public static void main(String[] args) {
        // Nos creamos un array bidimensional del tipo "char".
        char[][] arrayLetras = {
                /* Columnas => 0 1 2 3 */
                /* Fila => 0 */ { 'R', 'A', 'D', 'A' },
                /* Fila => 1 */ { 'O', 'S', 'O', 'S' },
                /* Fila => 2 */ { 'A', 'G', 'U', 'S' },
                /* Fila => 3 */ { 'A', 'N', 'N', 'A' }

        };

        // Función que recibe un Array bidimensional de letrás y busca palindromos.
        buscarPalindromos(arrayLetras);
    }

    public static void buscarPalindromos(char[][] arrayLetras) {
        int posicionA;
        int posicionB;
        boolean esPalindromo;

        System.out.println("¡Buscando palindromos en las columnas del Array!");

        // Bucle que recorre una por una todas las filas buscando palindromos.
        for (int fila = 0; fila < arrayLetras.length; fila++) {
            esPalindromo = true;
            posicionA = 0;
            posicionB = arrayLetras.length - 1;

            /* Fila 0 => {'R', 'A', 'D', 'A'} */
            while (posicionA < posicionB) {

                // Revisamos la letra en el posicionA con su posición opuesta en el posicionB.
                if (arrayLetras[fila][posicionA] != arrayLetras[fila][posicionB]) {
                    esPalindromo = false;
                }

                // Actualizamos los indices de comporación.
                posicionA++;
                posicionB--;
            }

            // Si es palindromo (true) o no (false) imprimo un mensaje y la palabra.
            if (esPalindromo) {
                System.out.println("En la fila " + fila + " hay un palindromo, la palabra es: ");
                // Función que imprime la "X" fila del Array que necesito mostrar.
                imprimirFilaArray(arrayLetras, fila);
            } else {
                System.out.println("En la fila " + fila + " no hay un palindromo, la palabra es: ");
                // Función que imprime la "X" fila del Array que necesito mostrar.
                imprimirFilaArray(arrayLetras, fila);
            }

        }

        // Bucle que revisa unr por una todas las columnas buscando palindromos.s
        for (int columna = 0; columna < arrayLetras.length; columna++) {
            esPalindromo = true;
            posicionA = 0;
            posicionB = arrayLetras.length - 1;

            // Bucle que revisa una por una las letras de "X" columna.
            while (posicionA < posicionB) {
                // Si en la misma columna detecta dos letras opuestas no iguales devuelve false.
                if (arrayLetras[posicionA][columna] != arrayLetras[posicionB][columna]) {
                    esPalindromo = false;
                }

                // Actualizamos los indices de comprobación.
                posicionA++;
                posicionB--;
            }

            // Si es palindromo (true) o no (false) imprimo un mensaje y la palabra.
            if (esPalindromo) {
                System.out.println("En la columna " + columna + " hay un palindromo, la palabra es: ");
                // Función que imprime la "X" columnas del Array que necesito mostrar.
                imprimirColumnaArray(arrayLetras, columna);
            } else {
                System.out.println("En la columna " + columna + " no hay un palindromo, la palabra es: ");
                // Función que imprime la "X" columnas del Array que necesito mostrar.
                imprimirColumnaArray(arrayLetras, columna);
            }

        }
    }

    /**
     * Función encargada de imprimir "X" fila de un Array de letrás
     * imprimiendo una por una las letras de esa fila.
     * 
     * @param arrayLetras (char[][]) Array bidimensional de letrás.
     * @param fila        (int) la fila especifica que se quiere imprimir.
     */
    public static void imprimirFilaArray(char[][] arrayLetras, int fila) {
        // Bucle que imprime una fila del Array.
        for (int posicion = 0; posicion < arrayLetras.length; posicion++) {
            System.out.print("[" + arrayLetras[fila][posicion] + "]");
        }

        // Salto de linea después de imprimir todo el palindromo encontrado.
        System.out.println();
    }

    /**
     * Función encargada de imprimir "X" columna de un Array de letrás
     * imprimiendo una por una las letras de esa columna.
     * 
     * @param arrayLetras (char[][]) Array bidimensional de letrás.
     * @param columna     (int) la columna especifica que se quiere imprimir.
     */
    public static void imprimirColumnaArray(char[][] arrayLetras, int columna) {
        // Bucle que imprima una columna del Array.
        for (int fila = 0; fila < arrayLetras.length; fila++) {
            System.out.print("[" + arrayLetras[fila][columna] + "]");
        }

        // Salto de linea después de imprimir todo el palindromo encontrado.
        System.out.println();

    }
}