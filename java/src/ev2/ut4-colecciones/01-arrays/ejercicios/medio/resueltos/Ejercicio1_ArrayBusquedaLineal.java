package general.arrays.resueltos.medio;

/**
 * Ejercicio 1 (medio): Busqueda lineal y contar ocurrencias
 * 
 * Crea un array de numeros enteros con 8 elementos y asignales valores
 * (puede haber valores repetidos a proposito).
 * 
 * Funciones:
 *  - buscarPosicion: devuelve el indice de la primera aparicion, o -1.
 *  - contarOcurrencias: devuelve cuantas veces aparece el valor.
 * 
 * int[] ejemplo = {4, 6, 5, 7, 2, 6, 8, 6}
 * 
 * Busqueda del 6: posicion 1
 * Ocurrencias del 6: 3
 * Busqueda del 99: -1
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_ArrayBusquedaLineal {
    
    /**
     * Devuelve la posicion de la primera aparicion de valor, o -1 si no esta.
     * @param array Array donde buscar
     * @param valor Valor a buscar
     * @return Indice de la primera aparicion, o -1 si no se encuentra
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
     * Cuenta cuantas veces aparece el valor en el array.
     * @param array Array donde contar
     * @param valor Valor cuya frecuencia queremos saber
     * @return Numero de ocurrencias del valor
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
        
        System.out.println("El valor " + buscado + " esta en la posicion: " + posicion);
        System.out.println("El valor " + buscado + " aparece " + ocurrencias + " veces");
        
        int inexistente = 99;
        int posicionInexistente = buscarPosicion(numeros, inexistente);
        System.out.println("El valor " + inexistente + " esta en la posicion: " + posicionInexistente);
    }
}
