package ev4.E07_ExamenRA2.E03_SimplificarFracciones;

import java.util.Scanner;

/**
 * Simplifica una fraccion con MCD (Euclides).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 24/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numerador = teclado.nextInt();
        int denominador = teclado.nextInt();

        if (denominador == 0) {
            System.out.println("Fraccion no valida");
            return;
        }

        // Signo solo en el numerador
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        int divisor = mcd(numerador, denominador);
        numerador = numerador / divisor;
        denominador = denominador / divisor;

        System.out.println(numerador + "/" + denominador);
    }

    public static int mcd(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }
}
