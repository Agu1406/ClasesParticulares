package ev4.E05_ExamenRA123.E03_AdivinaNumero;

import java.util.Random;
import java.util.Scanner;

/**
 * Adivina un numero 1-50 con 7 intentos.
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
        Random aleatorio = new Random();

        int secreto = aleatorio.nextInt(50) + 1;
        int maxIntentos = 7;
        boolean acertado = false;

        System.out.println("He pensado un numero entre 1 y 50. Tienes " + maxIntentos + " intentos.");

        for (int intento = 1; intento <= maxIntentos; intento++) {
            System.out.print("Intento " + intento + " => ");
            int numero = teclado.nextInt();

            if (numero == secreto) {
                System.out.println("Correcto. Has ganado.");
                acertado = true;
                break;
            } else if (numero < secreto) {
                System.out.println("El secreto es mayor.");
            } else {
                System.out.println("El secreto es menor.");
            }
        }

        if (!acertado) {
            System.out.println("Has perdido. El numero era " + secreto + ".");
        }
    }
}
