package madrid.iescanaveral.ejercicios;

/**
 * Ejercicio 15: Indicar cuál es la salida por consola cuando se ejecuta el siguiente programa.
 * 
 * Analiza el paso de parámetros por valor y por referencia en Java.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio15_PasoParametros {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        call_array(arr[0], arr);
        System.out.println(arr[0] + "," + arr[1]);
    }
    
    static void call_array(int i, int arr[]) {
        arr[i] = 6;
        i = 5;
    }
}
