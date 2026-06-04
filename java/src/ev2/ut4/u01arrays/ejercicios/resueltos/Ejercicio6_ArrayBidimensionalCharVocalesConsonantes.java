package ev2.ut4.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 6: Array bidimensional de caracteres - Contar vocales y consonantes
 * 
 * Crea un array bidimensional de caracteres (char) de 4 filas y 4 columnas
 * que represente una matriz de letras. Asigna valores de letras a cada posicion.
 * 
 * Crea una funcion llamada esVocal que reciba un caracter y retorne true
 * si es una vocal (a, e, i, o, u), o false en caso contrario.
 * La funcion debe considerar tanto mayusculas como minusculas.
 * 
 * Crea otra funcion llamada contarVocalesYConsonantes que reciba el array bidimensional
 * y use bucles for anidados para contar cuantas vocales y cuantas consonantes hay
 * en total en la matriz. Debe mostrar por pantalla ambos contadores.
 * 
 * Ejemplo de vocales: 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'
 * Ejemplo de consonantes: 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', etc.
 * 
 * Array bidimensional de 4x4:
 * 
 *          Columnas
 *          [0][1][2][3]
 * Fila [0] [A][N][N][A]  <- 2 vocales (A, A), 2 consonantes (N, N)
 * Fila [1] [R][A][D][A]  <- 2 vocales (A, A), 2 consonantes (R, D)
 * Fila [2] [O][S][O][S]  <- 2 vocales (O, O), 2 consonantes (S, S)
 * Fila [3] [L][E][T][R]  <- 1 vocal (E), 3 consonantes (L, T, R)
 * 
 * Total: 7 vocales, 9 consonantes
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
public class Ejercicio6_ArrayBidimensionalCharVocalesConsonantes {
    
    /**
     * Funcion que verifica si un caracter es una vocal
     * @param letra Caracter a verificar
     * @return true si es vocal, false en caso contrario
     */
    public static boolean esVocal(char letra) {
        char letraMinuscula = Character.toLowerCase(letra);
        return letraMinuscula == 'a' || letraMinuscula == 'e' || 
               letraMinuscula == 'i' || letraMinuscula == 'o' || 
               letraMinuscula == 'u';
    }
    
    /**
     * Funcion que cuenta vocales y consonantes en la tabla
     * @param tablaLetras Array bidimensional de caracteres
     */
    public static void contarVocalesYConsonantes(char[][] tablaLetras) {
        int contadorVocales = 0;
        int contadorConsonantes = 0;
        
        for (int fila = 0; fila < tablaLetras.length; fila++) {
            for (int columna = 0; columna < tablaLetras[fila].length; columna++) {
                char letra = tablaLetras[fila][columna];
                // Verificar que sea una letra
                if (Character.isLetter(letra)) {
                    if (esVocal(letra)) {
                        contadorVocales++;
                    } else {
                        contadorConsonantes++;
                    }
                }
            }
        }
        
        System.out.println("Total de vocales: " + contadorVocales);
        System.out.println("Total de consonantes: " + contadorConsonantes);
    }
    
    public static void main(String[] args) {
        // Crear array bidimensional de 4 filas y 4 columnas
        char[][] tablaLetras = {
            {'A', 'N', 'N', 'A'},
            {'R', 'A', 'D', 'A'},
            {'O', 'S', 'O', 'S'},
            {'L', 'E', 'T', 'R'}
        };
        
        // Llamar a la funcion contarVocalesYConsonantes
        contarVocalesYConsonantes(tablaLetras);
    }
}

