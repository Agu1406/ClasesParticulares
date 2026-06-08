package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 4: Array bidimensional de caracteres - Verificar palindromos
 * 
 * Crea un array bidimensional de caracteres (char) de 4 filas y 4 columnas
 * que represente una matriz de letras. Asigna valores de letras a cada posicion.
 * 
 * Crea una funcion llamada esPalindromo que reciba un array de caracteres
 * y retorne true si forma un palindromo (se lee igual de izquierda a derecha
 * que de derecha a izquierda), o false en caso contrario.
 * 
 * Crea otra funcion llamada buscarPalindromos que reciba el array bidimensional
 * y use bucles for anidados para verificar si alguna fila o columna forma un palindromo.
 * Debe mostrar por pantalla que filas o columnas son palindromos.
 * 
 * Ejemplo de palindromo: "ANNA", "RADAR", "OSO"
 * 
 * Array bidimensional de 4x4:
 * 
 *          Columnas
 *          [0][1][2][3]
 * Fila [0] [A][N][N][A]  <- Esta fila es palindromo
 * Fila [1] [R][A][D][A]
 * Fila [2] [O][S][O][S]
 * Fila [3] [L][E][T][R]
 * 
 * Para acceder a una posicion: array[fila][columna]
 * Ejemplo: array[0][1] es la posicion fila 0, columna 1
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_ArrayBidimensionalCharPalindromo {
    
    /**
     * Funcion que verifica si un array de caracteres forma un palindromo
     * @param letras Array de caracteres
     * @return true si es palindromo, false en caso contrario
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
     * Funcion que busca palindromos en filas y columnas de la tabla
     * @param tablaLetras Array bidimensional de caracteres
     */
    public static void buscarPalindromos(char[][] tablaLetras) {
        // Verificar filas
        System.out.println("Buscando palindromos en filas:");
        for (int fila = 0; fila < tablaLetras.length; fila++) {
            if (esPalindromo(tablaLetras[fila])) {
                System.out.println("La fila " + fila + " es un palindromo");
            }
        }
        
        // Verificar columnas
        System.out.println("\nBuscando palindromos en columnas:");
        for (int columna = 0; columna < tablaLetras[0].length; columna++) {
            // Crear array temporal para la columna
            char[] columnaLetras = new char[tablaLetras.length];
            for (int fila = 0; fila < tablaLetras.length; fila++) {
                columnaLetras[fila] = tablaLetras[fila][columna];
            }
            
            if (esPalindromo(columnaLetras)) {
                System.out.println("La columna " + columna + " es un palindromo");
            }
        }
    }
    
    public static void main(String[] args) {
        // Crear array bidimensional de 4 filas y 4 columnas
        char[][] tablaLetras = {
            {'A', 'N', 'N', 'A'},
            {'R', 'A', 'D', 'A'},
            {'O', 'S', 'O', 'S'},
            {'L', 'E', 'T', 'R'}
        };
        
        // Llamar a la funcion buscarPalindromos
        buscarPalindromos(tablaLetras);
    }
}

