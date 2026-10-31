package ev4.E04_ExamenRA123.E03_MenuCajero;

import java.util.Scanner;

/**
 * Cajero simple con saldo inicial y menu do-while.
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
        double saldo = 1000.0;
        int opcion;

        do {
            System.out.println();
            System.out.println("[1] Consultar saldo");
            System.out.println("[2] Ingresar");
            System.out.println("[3] Retirar");
            System.out.println("[0] Salir");
            System.out.print("Opcion => ");
            opcion = teclado.nextInt();

            if (opcion == 1) {
                System.out.println("Saldo: " + saldo);
            } else if (opcion == 2) {
                System.out.print("Cantidad a ingresar => ");
                double cantidad = teclado.nextDouble();
                if (cantidad > 0) {
                    saldo = saldo + cantidad;
                    System.out.println("Nuevo saldo: " + saldo);
                } else {
                    System.out.println("La cantidad debe ser mayor que 0.");
                }
            } else if (opcion == 3) {
                System.out.print("Cantidad a retirar => ");
                double cantidad = teclado.nextDouble();
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor que 0.");
                } else if (cantidad > saldo) {
                    System.out.println("Saldo insuficiente.");
                } else {
                    saldo = saldo - cantidad;
                    System.out.println("Nuevo saldo: " + saldo);
                }
            } else if (opcion == 0) {
                System.out.println("Hasta luego.");
            } else {
                System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }
}
