package ev4.E07_ExamenRA2.E02_ContadorPasos;

import java.util.Locale;
import java.util.Scanner;

/**
 * Contador de pasos con centinela 0.
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

        int dias = 0;
        int total = 0;
        int maximo = 0;

        int pasos = teclado.nextInt();
        while (pasos != 0) {
            if (pasos < 0) {
                System.out.println("Ignorado");
            } else {
                dias = dias + 1;
                total = total + pasos;
                if (dias == 1 || pasos > maximo) {
                    maximo = pasos;
                }
            }
            pasos = teclado.nextInt();
        }

        if (dias == 0) {
            System.out.println("Sin datos");
        } else {
            double media = (double) total / dias;
            System.out.println("Dias: " + dias);
            System.out.println("Total: " + total);
            System.out.printf(Locale.US, "Media: %.1f%n", media);
            System.out.println("Maximo: " + maximo);
        }
    }
}
