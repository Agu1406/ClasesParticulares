package ev4.E07_ExamenRA2.E01_FacturaLuz;

import java.util.Locale;
import java.util.Scanner;

/**
 * Factura de la luz: fijo + energia + descuento 10 % si kWh &gt;= 300.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 24/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static final double FIJO = 3.50;
    public static final double PRECIO_KWH = 0.18;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        double kwh = teclado.nextDouble();

        if (kwh < 0) {
            System.out.println("Datos no validos");
            return;
        }

        double energia = kwh * PRECIO_KWH;
        double descuento = 0;
        if (kwh >= 300) {
            descuento = energia * 0.10;
        }
        double total = FIJO + energia - descuento;

        System.out.printf(Locale.US, "Fijo: %.2f%n", FIJO);
        System.out.printf(Locale.US, "Energia: %.2f%n", energia);
        System.out.printf(Locale.US, "Descuento: %.2f%n", descuento);
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
