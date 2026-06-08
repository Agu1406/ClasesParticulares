package ev2.ut4_colecciones.u01arrays.ejercicios.pendientes;

/**
 * Ejercicio 10 (dificil): Recorrer una matriz en espiral
 * 
 * Crea un array bidimensional de enteros de 4 filas y 4 columnas con
 * valores del 1 al 16 ordenados por filas.
 * 
 * Crea una funcion llamada recorrerEnEspiral que reciba la matriz y
 * muestre por pantalla todos sus elementos siguiendo un recorrido
 * en ESPIRAL desde fuera hacia dentro, en este orden:
 * 
 *   1. La fila superior, de izquierda a derecha.
 *   2. La columna derecha, de arriba a abajo (sin repetir la esquina).
 *   3. La fila inferior, de derecha a izquierda (sin repetir la esquina).
 *   4. La columna izquierda, de abajo a arriba (sin repetir las esquinas).
 *   5. Repetir el mismo proceso con la "submatriz" interior, hasta
 *      recorrer todos los elementos.
 * 
 * Idea para resolverlo: usa cuatro variables que delimiten el
 * rectangulo que falta por recorrer:
 *  - filaArriba (empieza en 0)
 *  - filaAbajo  (empieza en matriz.length - 1)
 *  - columnaIzquierda (empieza en 0)
 *  - columnaDerecha  (empieza en matriz[0].length - 1)
 * 
 * Usa un bucle while (filaArriba <= filaAbajo && columnaIzquierda <= columnaDerecha).
 * Dentro del while haz cuatro bucles for, uno para cada lado de la
 * "capa". Despues de cada lado, ajusta el limite correspondiente
 * (filaArriba++, columnaDerecha--, etc.).
 * 
 * Ejemplo con una matriz 4x4:
 * 
 *  [ 1][ 2][ 3][ 4]
 *  [ 5][ 6][ 7][ 8]
 *  [ 9][10][11][12]
 *  [13][14][15][16]
 * 
 * Recorrido en espiral:
 *   1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 * 
 * Visualmente:
 *  -> -> -> ->
 *           ?
 *  -> -> ?    ?
 *  ?   ?    ?
 *  ? <- <-    ?
 *  <- <- <- <- <-
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_ArrayBidimensionalEspiral {
    public static void main(String[] args) {
        
    }
}
