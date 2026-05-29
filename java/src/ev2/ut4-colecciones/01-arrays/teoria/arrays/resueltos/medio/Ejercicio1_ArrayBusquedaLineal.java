package general.arrays.resueltos.medio;

/**
 * Ejercicio 1 (medio): Búsqueda lineal y contar ocurrencias
 * 
 * Crea un array de números enteros con 8 elementos y asígnales valores
 * (puede haber valores repetidos a propósito).
 * 
 * Funciones:
 *  - buscarPosicion: devuelve el índice de la primera aparición, o -1.
 *  - contarOcurrencias: devuelve cuántas veces aparece el valor.
 * 
 * int[] ejemplo = {4, 6, 5, 7, 2, 6, 8, 6}
 * 
 * Búsqueda del 6: posición 1
 * Ocurrencias del 6: 3
 * Búsqueda del 99: -1
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio1_ArrayBusquedaLineal {
    
    /**
     * Devuelve la posición de la primera aparición de valor, o -1 si no está.
     * @param array Array donde buscar
     * @param valor Valor a buscar
     * @return Índice de la primera aparición, o -1 si no se encuentra
     */
    public static int buscarPosicion(int[] array, int valor) {
        for (int indice = 0; indice < array.length; indice++) {
            if (array[indice] == valor) {
                return indice;
            }
        }
        return -1;
    }
    
    /**
     * Cuenta cuántas veces aparece el valor en el array.
     * @param array Array donde contar
     * @param valor Valor cuya frecuencia queremos saber
     * @return Número de ocurrencias del valor
     */
    public static int contarOcurrencias(int[] array, int valor) {
        int contador = 0;
        for (int indice = 0; indice < array.length; indice++) {
            if (array[indice] == valor) {
                contador++;
            }
        }
        return contador;
    }
    
    public static void main(String[] args) {
        int[] numeros = {4, 6, 5, 7, 2, 6, 8, 6};
        
        int buscado = 6;
        int posicion = buscarPosicion(numeros, buscado);
        int ocurrencias = contarOcurrencias(numeros, buscado);
        
        System.out.println("El valor " + buscado + " está en la posición: " + posicion);
        System.out.println("El valor " + buscado + " aparece " + ocurrencias + " veces");
        
        int inexistente = 99;
        int posicionInexistente = buscarPosicion(numeros, inexistente);
        System.out.println("El valor " + inexistente + " está en la posición: " + posicionInexistente);
    }
}
