package ev4.E06_ExamenRA2.E01_NominaSimple;

import java.util.Scanner;

/**
 * Nomina con horas extra (x1.5) e IRPF 15 %.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 24/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static final double IRPF = 0.15;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre => ");
        String nombre = teclado.nextLine();

        System.out.print("Horas trabajadas => ");
        int horas = teclado.nextInt();

        System.out.print("Precio hora => ");
        double precioHora = teclado.nextDouble();

        double bruto;
        if (horas <= 40) {
            bruto = horas * precioHora;
        } else {
            int extras = horas - 40;
            bruto = 40 * precioHora + extras * precioHora * 1.5;
        }

        double retencion = bruto * IRPF;
        double neto = bruto - retencion;

        // Casteo: se pierden los decimales
        int netoEntero = (int) neto;

        System.out.println();
        System.out.println("Nombre: " + nombre);
        System.out.println("Bruto: " + bruto);
        System.out.println("Retencion IRPF: " + retencion);
        System.out.println("Neto: " + neto);
        System.out.println("Neto truncado (int): " + netoEntero);
    }
}
