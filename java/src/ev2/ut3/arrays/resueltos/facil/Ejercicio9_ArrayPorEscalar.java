package general.arrays.resueltos.facil;

/**
 * Ejercicio 9: Multiplicar un array por un escalar
 * 
 * Devuelve un nuevo array donde cada elemento es el original
 * multiplicado por el escalar. El array original no se modifica.
 * 
 * int[] ejemplo = {4, 6, 5, 7, 2}
 * Escalar = 3
 * 
 * Original   = [4][6][5][7][2]
 * Resultado  = [12][18][15][21][6]
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio9_ArrayPorEscalar {
    
    /**
     * Multiplica cada elemento del array por el escalar.
     * @param array Array original (no se modifica)
     * @param escalar Número por el que multiplicar cada elemento
     * @return Nuevo array con cada elemento multiplicado por el escalar
     */
    public static int[] multiplicarPorEscalar(int[] array, int escalar) {
        int[] resultado = new int[array.length];
        for (int indice = 0; indice < array.length; indice++) {
            resultado[indice] = array[indice] * escalar;
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
        int[] numeros = {4, 6, 5, 7, 2};
        int escalar = 3;
        
        int[] resultado = multiplicarPorEscalar(numeros, escalar);
        
        System.out.print("Array original:   ");
        mostrar(numeros);
        
        System.out.print("Array x " + escalar + ":        ");
        mostrar(resultado);
    }
}
