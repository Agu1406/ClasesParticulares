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
public class Done {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Cantidad a convertir => ");
        double cantidad = teclado.nextDouble();

        System.out.print("Dólares por 1 euro (ej. 1.10) => ");
        double dolaresPorEuro = teclado.nextDouble();

        System.out.println();
        System.out.println("¡Menú del programa!");
        System.out.println("[1] - Euros a dólares");
        System.out.println("[2] - Dólares a euros");
        System.out.print("Introduce una opción => ");
        int opcion = teclado.nextInt();

        double resultado;

        if (opcion == 1) {
            resultado = cantidad * dolaresPorEuro;
            System.out.println(cantidad + " euros = " + resultado + " dólares");
        } else if (opcion == 2) {
            resultado = cantidad / dolaresPorEuro;
            System.out.println(cantidad + " dólares = " + resultado + " euros");
        } else {
            System.out.println("Opción no válida.");
        }
    }
}
