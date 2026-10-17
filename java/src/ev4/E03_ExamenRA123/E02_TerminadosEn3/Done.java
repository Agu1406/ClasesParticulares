package ev4.E03_ExamenRA123.E02_TerminadosEn3;

import java.util.Scanner;

/**
 * Cuenta enteros positivos que terminan en 3 hasta leer uno negativo.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int contador = 0;

        System.out.println("Introduce enteros positivos. Un negativo termina.");

        System.out.print("Número => ");
        int n = teclado.nextInt();

        while (n >= 0) {
            if (n % 10 == 3) {
                contador++;
            }
            System.out.print("Número => ");
            n = teclado.nextInt();
        }

        System.out.println("Números terminados en 3: " + contador);
    }
}
