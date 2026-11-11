package ev4.E03_ExamenRA2.E02_TerminadosEn3;

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
        int numero, contador = 0;
        boolean continuar = true;

        while (continuar) {
            System.out.print("Introduce un número => ");
            numero = teclado.nextInt();
            System.out.println();

            if (numero % 10 == 3) {
                contador++;
            } else if (numero < 0) {
                System.out.println("¡Fin del bule!");
                continuar = false;
            }
        }

        System.out.printf("¡Un total de %d números ingresados acababan en tres!", contador);
    }   
}