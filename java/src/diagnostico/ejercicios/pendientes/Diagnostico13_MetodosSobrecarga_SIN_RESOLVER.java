package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Sobrecarga de metodos maximo
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que compare dos valores y devuelva el mayor.</li>
 * <li>Completa dos versiones del metodo maximo: una para int y otra para double (sobrecarga).</li>
 * <li>En el main, lee dos enteros y dos decimales con Scanner teclado e imprime cada maximo.</li>
 * </ul>
 *
 * <p>Diagnostico 13 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico13_MetodosSobrecarga_SIN_RESOLVER {

    public static int maximo(int a, int b) {
        // TODO
        return 0;
    }

    public static double maximo(double a, double b) {
        // TODO: sobrecarga del metodo
        return 0;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int enteroA;
        int enteroB;
        double decimalA;
        double decimalB;
        teclado = new Scanner(System.in);
        System.out.print("Primer entero: ");
        enteroA = teclado.nextInt();
        System.out.print("Segundo entero: ");
        enteroB = teclado.nextInt();
        System.out.print("Primer decimal: ");
        decimalA = teclado.nextDouble();
        System.out.print("Segundo decimal: ");
        decimalB = teclado.nextDouble();
        // TODO: llamar a maximo
        System.out.println("Max entero: " + maximo(enteroA, enteroB));
        System.out.println("Max decimal: " + maximo(decimalA, decimalB));
        teclado.close();
    }
}
