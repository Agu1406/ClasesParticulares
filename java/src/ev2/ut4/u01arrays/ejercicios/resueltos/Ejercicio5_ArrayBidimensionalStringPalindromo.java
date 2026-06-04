package ev2.ut4.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 5: Array bidimensional de Strings - Contar palabras que empiezan con vocal
 * 
 * Crea un array bidimensional de Strings de 3 filas y 3 columnas que represente
 * una matriz de palabras. Asigna valores de palabras a cada posicion.
 * 
 * Crea una funcion llamada empiezaConVocal que reciba un String y retorne true
 * si la palabra empieza con vocal (a, e, i, o, u), o false en caso contrario.
 * La funcion debe ignorar mayusculas y minusculas.
 * 
 * Crea otra funcion llamada contarPalabrasConVocal que reciba el array bidimensional
 * y use bucles for anidados para contar cuantas palabras en la matriz empiezan con vocal.
 * Debe retornar el numero total de palabras que empiezan con vocal.
 * 
 * Ejemplo de palabras que empiezan con vocal: "ANNA", "ELEFANTE", "IGUAL", "OSO", "UNO"
 * 
 * Array bidimensional de 3x3:
 * 
 *          Columnas
 *          [0]        [1]        [2]
 * Fila [0] [ANNA]     [CASA]     [RADAR]    <- ANNA empieza con vocal
 * Fila [1] [ELEFANTE] [MESA]     [SOLO]     <- ELEFANTE empieza con vocal
 * Fila [2] [LAPIZ]    [ROTOR]    [IGUAL]    <- IGUAL empieza con vocal
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
public class Ejercicio5_ArrayBidimensionalStringPalindromo {
    
    /**
     * Funcion que verifica si una palabra empieza con vocal
     * @param palabra String a verificar
     * @return true si empieza con vocal, false en caso contrario
     */
    public static boolean empiezaConVocal(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return false;
        }
        
        // Convertir a minusculas para comparar
        char primeraLetra = Character.toLowerCase(palabra.charAt(0));
        
        return primeraLetra == 'a' || primeraLetra == 'e' || 
               primeraLetra == 'i' || primeraLetra == 'o' || 
               primeraLetra == 'u';
    }
    
    /**
     * Funcion que cuenta cuantas palabras empiezan con vocal
     * @param tablaPalabras Array bidimensional de Strings
     * @return Numero total de palabras que empiezan con vocal
     */
    public static int contarPalabrasConVocal(String[][] tablaPalabras) {
        int contador = 0;
        for (int fila = 0; fila < tablaPalabras.length; fila++) {
            for (int columna = 0; columna < tablaPalabras[fila].length; columna++) {
                if (empiezaConVocal(tablaPalabras[fila][columna])) {
                    contador++;
                }
            }
        }
        return contador;
    }
    
    public static void main(String[] args) {
        // Crear array bidimensional de 3 filas y 3 columnas
        String[][] palabras = {
            {"ANNA", "CASA", "RADAR"},
            {"ELEFANTE", "MESA", "SOLO"},
            {"LAPIZ", "ROTOR", "IGUAL"}
        };
        
        // Llamar a la funcion y mostrar el resultado
        int cantidad = contarPalabrasConVocal(palabras);
        System.out.println("La cantidad de palabras que empiezan con vocal es: " + cantidad);
    }
}

