package ev4.E01_ExamenRA123.E01_TicketIVA;

import java.util.*;

/**
 * Solucion del ticket con IVA (continuacion del estilo del alumno).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static final double IVA = 0.21;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Diga el nombre del producto: ");
        String nombre = teclado.nextLine();

        System.out.println("Diga la cantidad de unidades: ");
        int unidades = teclado.nextInt();

        System.out.println("Diga el precio del producto: ");
        double precio = teclado.nextDouble();

        // Primero, precio base
        double precioBase = unidades * precio;

        // Segundo, con IVA
        double importeIva = precioBase * IVA;

        // Tercero, total a pagar
        double total = precioBase + importeIva;

        // Casteo a int: se pierden los decimales (se trunca)
        int totalEntero = (int) total;

        System.out.println();
        System.out.println("Producto: " + nombre);
        System.out.println("Unidades: " + unidades);
        System.out.println("Base: " + precioBase);
        System.out.println("IVA (21%): " + importeIva);
        System.out.println("Total: " + total);
        System.out.println("Total truncado (int): " + totalEntero);
    }
}
