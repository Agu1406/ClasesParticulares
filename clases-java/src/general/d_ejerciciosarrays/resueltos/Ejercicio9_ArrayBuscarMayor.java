package madrid.iescalderonbarca.d_ejerciciosarrays;

/**
 * Ejercicio 9: Buscar el mayor elemento en un array unidimensional
 * Crea un array de números enteros con 6 elementos y asígnales valores.
 * Crea una función llamada buscarMayor que reciba el array como parámetro,
 * use un bucle for y un if para encontrar el número mayor y retorne ese valor.
 * Llámala desde el main y muestra el resultado
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
public class Ejercicio9_ArrayBuscarMayor {
    
    /**
     * Función que busca el mayor elemento del array
     * @param array Array de enteros
     * @return El mayor valor encontrado
     */
    public static int buscarMayor(int[] array) {
        int mayor = array[0]; // Inicializar con el primer elemento
        for (int indice = 1; indice < array.length; indice++) {
            if (array[indice] > mayor) {
                mayor = array[indice];
            }
        }
        return mayor;
    }
    
    public static void main(String[] args) {
        // Crear array de 6 elementos y asignar valores
        int[] numeros = {4, 6, 5, 7, 2, 9};
        
        // Llamar a la función y mostrar el resultado
        int mayor = buscarMayor(numeros);
        System.out.println("El número mayor es: " + mayor);
    }
}

