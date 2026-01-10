package madrid.iescalderonbarca.e_ejerciciosarrays;

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
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio2_ArrayConFuncion {
    
    /**
     * Función que muestra todos los valores del array
     * @param array Array de enteros a mostrar
     */
    public static void mostrarArray(int[] array) {
        System.out.println("Valores del array:");
        for (int indice = 0; indice < array.length; indice++) {
            System.out.println("Posición " + indice + ": " + array[indice]);
        }
    }
    
    public static void main(String[] args) {
        // Crear array de 5 elementos y asignar valores
        int[] numeros = {4, 6, 5, 7, 2};
        
        // Llamar a la función mostrarArray
        mostrarArray(numeros);
    }
}

