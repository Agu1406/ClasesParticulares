package general.arrays.medio;

/**
 * Ejercicio 9 (medio): Rotar un array N posiciones a la derecha
 * 
 * Crea un array de numeros enteros con 6 elementos y asignales valores.
 * 
 * Crea una funcion llamada rotarDerecha que reciba el array y un numero
 * entero N (cuantas posiciones queremos rotar a la derecha) y devuelva
 * un NUEVO array con los elementos rotados.
 * El array original NO se debe modificar.
 * 
 * Rotar a la derecha significa que cada elemento se mueve N posiciones
 * hacia la derecha, y los que se salen por el final vuelven a entrar
 * por el principio.
 * 
 * Idea para calcular la nueva posicion:
 *  - Si el original tiene tamano L y queremos rotar N posiciones,
 *    el elemento que estaba en la posicion i del original debe ir
 *    a la posicion (i + N) % L del nuevo array.
 *  - El operador % (modulo) hace que los indices "den la vuelta".
 *  - Truco: para que funcione con N mayores que L, normaliza antes:
 *      N = N % L;
 * 
 * Desde el main, muestra el array original y el resultado de rotarlo 2
 * posiciones a la derecha.
 * 
 * int[] ejemplo = {1, 2, 3, 4, 5, 6}
 * Rotar 2 a la derecha:
 * 
 * Original = [1][2][3][4][5][6]
 * Rotado   = [5][6][1][2][3][4]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_ArrayRotar {
    public static void main(String[] args) {
        
    }
}
