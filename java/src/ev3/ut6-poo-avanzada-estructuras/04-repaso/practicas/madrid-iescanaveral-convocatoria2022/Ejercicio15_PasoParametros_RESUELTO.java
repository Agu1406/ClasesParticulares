package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 15: Indicar cuál es la salida por consola - RESUELTO
 * 
 * RESPUESTA: 1, 6
 * 
 * Explicación:
 * - arr = {1, 2, 3, 4}
 * - Se llama call_array(arr[0], arr) = call_array(1, arr)
 * - En call_array: i = 1 (copia del valor), arr es referencia al array original
 * - arr[i] = arr[1] = 6, modifica el array original: {1, 6, 3, 4}
 * - i = 5 solo modifica la copia local, no afecta arr[0]
 * - arr[0] sigue siendo 1, arr[1] ahora es 6
 * - Salida: "1,6"
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio15_PasoParametros_RESUELTO {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        call_array(arr[0], arr);  // Pasa el valor 1 y la referencia al array
        System.out.println(arr[0] + "," + arr[1]);  // Imprime: 1,6
    }
    
    static void call_array(int i, int arr[]) {
        // i es una copia del valor (1), arr es una referencia al array original
        arr[i] = 6;  // Modifica arr[1] = 6 en el array original
        i = 5;  // Solo modifica la copia local, no afecta arr[0]
    }
    
    // En Java:
    // - Tipos primitivos se pasan por valor (copia)
    // - Arrays y objetos se pasan por referencia (mismo objeto)
}
