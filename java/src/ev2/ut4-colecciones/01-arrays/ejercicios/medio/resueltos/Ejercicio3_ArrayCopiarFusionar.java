package general.arrays.resueltos.medio;

/**
 * Ejercicio 3 (medio): Copiar y fusionar dos arrays
 * 
 * int[] array1 = {1, 2, 3, 4}
 * int[] array2 = {5, 6, 7}
 * 
 * Copia de array1: [1][2][3][4]
 * Fusion array1 + array2: [1][2][3][4][5][6][7]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_ArrayCopiarFusionar {
    
    /**
     * Devuelve una copia independiente del array recibido.
     * @param array Array a copiar
     * @return Nuevo array con los mismos elementos
     */
    public static int[] copiar(int[] array) {
        int[] copia = new int[array.length];
        for (int indice = 0; indice < array.length; indice++) {
            copia[indice] = array[indice];
        }
        return copia;
    }
    
    /**
     * Devuelve un nuevo array que contiene primero los elementos de
     * arrayA y a continuacion los de arrayB.
     * @param arrayA Primer array
     * @param arrayB Segundo array
     * @return Nuevo array con la concatenacion de ambos
     */
    public static int[] fusionar(int[] arrayA, int[] arrayB) {
        int[] resultado = new int[arrayA.length + arrayB.length];
        
        for (int indice = 0; indice < arrayA.length; indice++) {
            resultado[indice] = arrayA[indice];
        }
        
        for (int indice = 0; indice < arrayB.length; indice++) {
            resultado[arrayA.length + indice] = arrayB[indice];
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
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7};
        
        int[] copia = copiar(array1);
        int[] fusion = fusionar(array1, array2);
        
        System.out.print("Copia de array1:        ");
        mostrar(copia);
        
        System.out.print("Fusion array1 + array2: ");
        mostrar(fusion);
    }
}
