package ev4.E04_ExamenRA123.E01_FacturaDescuento;

import java.util.Scanner;

/**
 * Factura con descuento si horas &gt;= 10 y casteo del total.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 24/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static final double DESCUENTO = 0.15;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Concepto => ");
        String concepto = teclado.nextLine();

        System.out.print("Horas => ");
        int horas = teclado.nextInt();

        System.out.print("Precio por hora => ");
        double precioHora = teclado.nextDouble();

        double subtotal = horas * precioHora;
        double importeDescuento = 0;
        if (horas >= 10) {
            importeDescuento = subtotal * DESCUENTO;
        }
        double total = subtotal - importeDescuento;

        // Casteo: se pierden los decimales
        int totalEntero = (int) total;

        System.out.println();
        System.out.println("Concepto: " + concepto);
        System.out.println("Horas: " + horas);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Descuento: " + importeDescuento);
        System.out.println("Total: " + total);
        System.out.println("Total truncado (int): " + totalEntero);
    }
}
