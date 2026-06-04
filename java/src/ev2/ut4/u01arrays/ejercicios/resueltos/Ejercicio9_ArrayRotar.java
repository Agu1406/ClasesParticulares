package ev2.ut4.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 9 (medio): Rotar un array N posiciones a la derecha
 * 
 * Devuelve un nuevo array con los elementos rotados N posiciones a
 * la derecha. El original no se modifica.
 * 
 * Original = [1][2][3][4][5][6]
 * Rotar 2 -> [5][6][1][2][3][4]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_ArrayRotar {
    
    /**
     * Devuelve un nuevo array con los elementos rotados N posiciones
     * a la derecha. El array original no se modifica.
     * @param array Array original
     * @param posiciones Numero de posiciones a rotar (puede ser mayor que el tamano)
     * @return Nuevo array rotado
     */
    public static int[] rotarDerecha(int[] array, int posiciones) {
        int longitud = array.length;
        int desplazamiento = posiciones % longitud;
        int[] rotado = new int[longitud];
        
        for (int indice = 0; indice < longitud; indice++) {
            int nuevaPosicion = (indice + desplazamiento) % longitud;
            rotado[nuevaPosicion] = array[indice];
        }
        
        return rotado;
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
        int[] numeros = {1, 2, 3, 4, 5, 6};
        int posiciones = 2;
        
        int[] rotado = rotarDerecha(numeros, posiciones);
        
        System.out.print("Array original:        ");
        mostrar(numeros);
        
        System.out.print("Rotado " + posiciones + " a la derecha: ");
        mostrar(rotado);
    }
}
