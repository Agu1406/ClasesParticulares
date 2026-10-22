package ev4.E03_ExamenRA123.E01_ConversorMonedas;

import java.util.Scanner;

/**
 * Conversor de euros y dólares con un factor de cambio.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
import java.util.Scanner;

public class Done {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double cantidad, dolaresPorEuro, resultado;
        int opcion;

        System.out.print("Introduce la cantidad que deseas convertir => ");
        cantidad = teclado.nextDouble();
        System.out.println();

        System.out.print("¿Cuantos dolares son un euro? => ");
        dolaresPorEuro = teclado.nextDouble();
        System.out.println();

        System.out.print(
                "\n¡Opciones de conversión!\n"
                        + "[1] - Dolares a Euros.\n"
                        + "[2] - Euros a Dolares.\n"
                        + "\n"
                        + "Introduce una opción => ");
        opcion = teclado.nextInt();

        switch (opcion) {
            case 1:
                resultado = cantidad / dolaresPorEuro;
                System.out.printf("CONVERSIÓN COMPLETA => %.2f$ = %.2f€", cantidad, resultado);
                break;

            case 2:
                resultado = cantidad * dolaresPorEuro;
                System.out.printf("CONVERSIÓN COMPLETA => %.2f€ = %.2f$", cantidad, resultado);
                System.out.printf();
                break;

            default:
                System.out.println("¡Opción no valida! Intentalo de nuevo.");
                break;
        }

    }
}
