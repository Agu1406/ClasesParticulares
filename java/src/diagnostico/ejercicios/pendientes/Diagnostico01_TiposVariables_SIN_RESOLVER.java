package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Media de enteros con precision decimal
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que calcule la media de dos numeros enteros introducidos por teclado.</li>
 * <li>Completa el metodo mediaEnteros(int a, int b) para que devuelva la media con decimales.</li>
 * <li>Usa double en la division (por ejemplo, dividir entre 2.0) para no perder la parte decimal.</li>
 * <li>En el main, lee los dos valores con Scanner teclado, llama al metodo e imprime la media.</li>
 * </ul>
 *
 * <p>Diagnostico 01 — EV1 · ut1_fundamentosjava · RA1.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico01_TiposVariables_SIN_RESOLVER {

    public static double mediaEnteros(int a, int b) {
        // TODO: usar double para no perder decimales en la division
        return 0;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int a;
        int b;
        double resultado;
        teclado = new Scanner(System.in);
        System.out.print("Primer entero: ");
        a = teclado.nextInt();
        System.out.print("Segundo entero: ");
        b = teclado.nextInt();
        // TODO: llamar a mediaEnteros y mostrar resultado
        resultado = mediaEnteros(a, b);
        System.out.println("Media: " + resultado);
        teclado.close();
    }
}
