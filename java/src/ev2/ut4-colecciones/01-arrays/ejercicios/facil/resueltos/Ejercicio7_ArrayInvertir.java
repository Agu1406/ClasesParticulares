package general.arrays.resueltos.facil;

/**
 * Ejercicio 7: Invertir un array unidimensional
 * 
 * Crea un array de números enteros con 5 elementos y asígnales valores.
 * 
 * Crea una función llamada invertir que reciba el array como parámetro
 * y devuelva un NUEVO array con los elementos en orden inverso.
 * El array original NO se debe modificar.
 * 
 * int[] ejemplo = {4, 6, 5, 7, 2}
 * 
 * Original  = [4][6][5][7][2]
 * Invertido = [2][7][5][6][4]
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_ArrayInvertir {
    
    /**
     * Devuelve un nuevo array con los elementos en orden inverso.
     * @param array Array de enteros original
     * @return Nuevo array invertido (el original no se modifica)
     */
    public static int[] invertir(int[] array) {
        int[] invertido = new int[array.length];
        for (int indice = 0; indice < array.length; indice++) {
            invertido[array.length - 1 - indice] = array[indice];
        }
        return invertido;
    }
    
    /**
     * Muestra los elementos del array separados por espacios.
     * @param array Array a mostrar
     */
    public static void mostrar(int[] array) {
        for (int indice = 0; indice < array.length; indice++) {
            System.out.print(array[indice] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] numeros = {4, 6, 5, 7, 2};
        int[] invertido = invertir(numeros);
        
        System.out.print("Array original:  ");
        mostrar(numeros);
        
        System.out.print("Array invertido: ");
        mostrar(invertido);
    }
}
