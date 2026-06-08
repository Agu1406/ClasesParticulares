package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Maximo en array unidimensional
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que encuentre el valor maximo de un array de enteros.</li>
 * <li>Completa el metodo maximo(int[] numeros).</li>
 * <li>En el main, lee cuantos numeros hay y cada valor con Scanner teclado.</li>
 * <li>Guarda los datos en un array, llama al metodo e imprime el maximo.</li>
 * </ul>
 *
 * <p>Diagnostico 19 — EV2 · ut4_colecciones · RA6.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico19_Arrays1D_RESUELTO {

    public static int maximo(int[] numeros) {
        int mayor;
        int indice;
        mayor = numeros[0];
        for (indice = 1; indice < numeros.length; indice++) {
            if (numeros[indice] > mayor) {
                mayor = numeros[indice];
            }
        }
        return mayor;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int cantidad;
        int[] numeros;
        int indice;
        int mayor;
        teclado = new Scanner(System.in);
        System.out.print("Cuantos numeros: ");
        cantidad = teclado.nextInt();
        numeros = new int[cantidad];
        for (indice = 0; indice < cantidad; indice++) {
            System.out.print("Numero " + (indice + 1) + ": ");
            numeros[indice] = teclado.nextInt();
        }
        mayor = maximo(numeros);
        System.out.println("Maximo: " + mayor);
        teclado.close();
    }
}
