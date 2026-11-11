package ev4.E02_ExamenRA2.E02_CajeroAparcamiento;

import java.util.Scanner;

/**
 * Cajero de aparcamiento: tarifa por minuto, minimo de cobro y bono con descuento.
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

        final double PRECIO_MINUTO = 0.05;
        final double MINIMO = 1.00;

        System.out.print("Minutos estacionados => ");
        int minutos = teclado.nextInt();

        if (minutos < 0) {
            System.out.println("Error: los minutos no pueden ser negativos.");
        } else {
            double bruto = minutos * PRECIO_MINUTO;
            double cobro;

            if (bruto < MINIMO) {
                cobro = MINIMO;
            } else {
                cobro = bruto;
            }

            System.out.print("¿Tiene bono? (S/N) => ");
            String bono = teclado.next();

            double descuento = 0;
            if (bono.equals("S") || bono.equals("s")) {
                descuento = cobro * 0.10;
            }

            double total = cobro - descuento;

            System.out.println();
            System.out.println("Minutos: " + minutos);
            System.out.println("Cobro sin descuento: " + cobro);
            System.out.println("Descuento: " + descuento);
            System.out.println("Total a pagar: " + total);
        }
    }
}
