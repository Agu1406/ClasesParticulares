package madrid.iescalderonbarca.d_ejerciciosarrays;

/**
 * Ejercicio 11: Array bidimensional de caracteres - Verificar palíndromos
 * 
 * Crea un array bidimensional de caracteres (char) de 4 filas y 4 columnas
 * que represente una matriz de letras. Asigna valores de letras a cada posición.
 * 
 * Crea una función llamada esPalindromo que reciba un array de caracteres
 * y retorne true si forma un palíndromo (se lee igual de izquierda a derecha
 * que de derecha a izquierda), o false en caso contrario.
 * 
 * Crea otra función llamada buscarPalindromos que reciba el array bidimensional
 * y use bucles for anidados para verificar si alguna fila o columna forma un palíndromo.
 * Debe mostrar por pantalla qué filas o columnas son palíndromos.
 * 
 * Ejemplo de palíndromo: "ANNA", "RADAR", "OSO"
 * 
 * Array bidimensional de 4x4:
 * 
 *          Columnas
 *          [0][1][2][3]
 * Fila [0] [A][N][N][A]  <- Esta fila es palíndromo
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
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio11_ArrayBidimensionalCharPalindromo {
    
    /**
     * Función que verifica si un array de caracteres forma un palíndromo
     * @param letras Array de caracteres
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(char[] letras) {
        int inicio = 0;
        int fin = letras.length - 1;
        
        while (inicio < fin) {
            if (letras[inicio] != letras[fin]) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }
    
    /**
     * Función que busca palíndromos en filas y columnas de la matriz
     * @param matriz Array bidimensional de caracteres
     */
    public static void buscarPalindromos(char[][] matriz) {
        // Verificar filas
        System.out.println("Buscando palíndromos en filas:");
        for (int i = 0; i < matriz.length; i++) {
            if (esPalindromo(matriz[i])) {
                System.out.println("La fila " + i + " es un palíndromo");
            }
        }
        
        // Verificar columnas
        System.out.println("\nBuscando palíndromos en columnas:");
        for (int j = 0; j < matriz[0].length; j++) {
            // Crear array temporal para la columna
            char[] columna = new char[matriz.length];
            for (int i = 0; i < matriz.length; i++) {
                columna[i] = matriz[i][j];
            }
            
            if (esPalindromo(columna)) {
                System.out.println("La columna " + j + " es un palíndromo");
            }
        }
    }
    
    public static void main(String[] args) {
        // Crear array bidimensional de 4 filas y 4 columnas
        char[][] matriz = {
            {'A', 'N', 'N', 'A'},
            {'R', 'A', 'D', 'A'},
            {'O', 'S', 'O', 'S'},
            {'L', 'E', 'T', 'R'}
        };
        
        // Llamar a la función buscarPalindromos
        buscarPalindromos(matriz);
    }
}

