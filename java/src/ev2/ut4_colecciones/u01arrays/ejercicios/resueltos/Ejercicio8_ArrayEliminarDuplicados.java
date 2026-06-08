package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 8 (medio): Eliminar duplicados de un array unidimensional
 * 
 * Devuelve un nuevo array con cada valor una sola vez, en el orden
 * en que aparece por primera vez en el array original.
 * 
 * Original       = [4][6][5][4][2][6][8][5]
 * Sin duplicados = [4][6][5][2][8]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_ArrayEliminarDuplicados {
    
    /**
     * Comprueba si el valor ya esta dentro de las primeras 'hasta'
     * posiciones del array.
     * @param array Array donde buscar
     * @param hasta Hasta que posicion (exclusive) considerar
     * @param valor Valor a buscar
     * @return true si valor aparece en array[0..hasta-1], false en otro caso
     */
    public static boolean contiene(int[] array, int hasta, int valor) {
        for (int indice = 0; indice < hasta; indice++) {
            if (array[indice] == valor) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Devuelve un nuevo array con cada valor del original una sola vez,
     * manteniendo el orden de la primera aparicion.
     * @param array Array original (no se modifica)
     * @return Nuevo array sin duplicados
     */
    public static int[] eliminarDuplicados(int[] array) {
        int[] auxiliar = new int[array.length];
        int cantidadUnicos = 0;
        
        for (int indice = 0; indice < array.length; indice++) {
            if (!contiene(auxiliar, cantidadUnicos, array[indice])) {
                auxiliar[cantidadUnicos] = array[indice];
                cantidadUnicos++;
            }
        }
        
        int[] resultado = new int[cantidadUnicos];
        for (int indice = 0; indice < cantidadUnicos; indice++) {
            resultado[indice] = auxiliar[indice];
        }
        return resultado;
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
        int[] numeros = {4, 6, 5, 4, 2, 6, 8, 5};
        int[] sinDuplicados = eliminarDuplicados(numeros);
        
        System.out.print("Array original:       ");
        mostrar(numeros);
        
        System.out.print("Array sin duplicados: ");
        mostrar(sinDuplicados);
    }
}
