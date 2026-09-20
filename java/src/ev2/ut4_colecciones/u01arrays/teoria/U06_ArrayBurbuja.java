package ev2.ut4_colecciones.u01arrays.teoria;

import java.util.Random;

/**
 * Teoria: ordenar un array con el algoritmo de burbuja.
 *
 * <p><b>Objetivo:</b> recorrer el array varias veces intercambiando pares
 * adyacentes desordenados hasta dejarlo ascendente. Practica en
 * {@code ejercicios/…/Ejercicio2_ArrayOrdenarBurbuja}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U06_ArrayBurbuja {

    public static void main(String[] args) {
        int[] arrayNumeros = rellenarArray(new int[10]);

        /*
         * Ejemplo mental:
         * Posiciones => [0][1][2][3][4][5]
         * Valores    => [9][3][1][7][2][5]
         */
        for (int turno = 0; turno < arrayNumeros.length; turno++) {
            for (int posicion = 0; posicion < arrayNumeros.length - 1; posicion++) {
                if (arrayNumeros[posicion] > arrayNumeros[posicion + 1]) {
                    int auxiliar = arrayNumeros[posicion];
                    arrayNumeros[posicion] = arrayNumeros[posicion + 1];
                    arrayNumeros[posicion + 1] = auxiliar;
                }
            }
        }

        imprimirArray(arrayNumeros);
    }

    public static void imprimirArray(int[] arrayNumeros) {
        System.out.println("Array ordenado:");
        for (int posicion = 0; posicion < arrayNumeros.length; posicion++) {
            System.out.print("[" + arrayNumeros[posicion] + "]");
        }
        System.out.println();
    }

    public static int[] rellenarArray(int[] arrayNumeros) {
        Random generador = new Random();
        for (int posicion = 0; posicion < arrayNumeros.length; posicion++) {
            arrayNumeros[posicion] = generador.nextInt(21);
        }
        return arrayNumeros;
    }
}
