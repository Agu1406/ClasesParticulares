package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 10: Sumar dos arrays elemento a elemento
 * 
 * Devuelve un nuevo array del mismo tamano donde cada posicion es
 * la suma de las posiciones equivalentes en los dos arrays de entrada.
 * Asumimos que ambos arrays tienen el mismo tamano.
 * 
 * Array A    = [1][2][3][4][5]
 * Array B    = [10][20][30][40][50]
 * Resultado  = [11][22][33][44][55]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_ArraySumarArrays {
    
    /**
     * Suma dos arrays del mismo tamano elemento a elemento.
     * @param arrayA Primer array
     * @param arrayB Segundo array (debe tener el mismo tamano que arrayA)
     * @return Nuevo array con la suma posicion a posicion
     */
    public static int[] sumarArrays(int[] arrayA, int[] arrayB) {
        int[] resultado = new int[arrayA.length];
        for (int indice = 0; indice < arrayA.length; indice++) {
            resultado[indice] = arrayA[indice] + arrayB[indice];
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
        int[] arrayA = {1, 2, 3, 4, 5};
        int[] arrayB = {10, 20, 30, 40, 50};
        
        int[] resultado = sumarArrays(arrayA, arrayB);
        
        System.out.print("Array A:   ");
        mostrar(arrayA);
        
        System.out.print("Array B:   ");
        mostrar(arrayB);
        
        System.out.print("Suma A+B:  ");
        mostrar(resultado);
    }
}
