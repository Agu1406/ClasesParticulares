package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Suma por filas en matriz bidimensional
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que sume cada fila de una matriz bidimensional.</li>
 * <li>Completa el metodo sumaPorFilas(int[][] matriz) que devuelva un array con la suma de cada fila.</li>
 * <li>Usa bucles for con variables fila y columna declaradas al inicio.</li>
 * <li>En el main, lee filas, columnas y valores con Scanner teclado. Construye la matriz e imprime las sumas.</li>
 * </ul>
 *
 * <p>Diagnostico 20 — EV2 · ut4_colecciones · RA6.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico20_Arrays2D_RESUELTO {

    public static int[] sumaPorFilas(int[][] matriz) {
        int[] sumas;
        int fila;
        int columna;
        sumas = new int[matriz.length];
        for (fila = 0; fila < matriz.length; fila++) {
            for (columna = 0; columna < matriz[fila].length; columna++) {
                sumas[fila] += matriz[fila][columna];
            }
        }
        return sumas;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int filas;
        int[][] matriz;
        int fila;
        int columnas;
        int columna;
        int[] sumas;
        int indice;
        teclado = new Scanner(System.in);
        System.out.print("Numero de filas: ");
        filas = teclado.nextInt();
        matriz = new int[filas][];
        for (fila = 0; fila < filas; fila++) {
            System.out.print("Columnas en fila " + (fila + 1) + ": ");
            columnas = teclado.nextInt();
            matriz[fila] = new int[columnas];
            for (columna = 0; columna < columnas; columna++) {
                System.out.print("  Valor [" + fila + "][" + columna + "]: ");
                matriz[fila][columna] = teclado.nextInt();
            }
        }
        sumas = sumaPorFilas(matriz);
        for (indice = 0; indice < sumas.length; indice++) {
            System.out.println("Suma fila " + indice + ": " + sumas[indice]);
        }
        teclado.close();
    }
}
