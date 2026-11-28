package ev4.E10_ExamenRA2.E01_TarifaAparcamiento;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> tarifa de aparcamiento con minutos gratis, tope y etiqueta CERO.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> si minutos &gt; 15 cobra la estancia entera ×0.04; tope 18;
 * luego mitad si etiqueta CERO.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 15/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado = new Scanner(System.in);
        int minutos, etiquetaCero;
        double importe;
        minutos = teclado.nextInt();
        etiquetaCero = teclado.nextInt();

        if (minutos < 0 || (etiquetaCero != 0 && etiquetaCero != 1)) {
            System.out.println("Datos no válidos");
        } else {
            importe = 0;
            // A partir del minuto 16 se cobra toda la estancia
            if (minutos > 15) {
                importe = minutos * 0.04;
                if (importe > 18) {
                    importe = 18;
                }
            }
            // Descuento CERO despues del tope
            if (etiquetaCero == 1) {
                importe = importe / 2;
            }
            System.out.printf(Locale.US, "Importe: %.2f €%n", importe);
        }

        teclado.close();
    }
}
