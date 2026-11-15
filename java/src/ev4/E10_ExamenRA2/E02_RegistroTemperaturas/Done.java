package ev4.E10_ExamenRA2.E02_RegistroTemperaturas;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> lecturas hasta centinela 999; media, maxima y alertas.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> la maxima arranca con la primera lectura; alerta si
 * {@code > 35} o {@code < 2}; media con division real.</p>
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
        Scanner teclado;
        int lecturas, suma, maxima, alertas, temperatura;

        teclado = new Scanner(System.in);
        lecturas = 0;
        suma = 0;
        maxima = 0;
        alertas = 0;

        temperatura = teclado.nextInt();
        while (temperatura != 999) {
            if (lecturas == 0 || temperatura > maxima) {
                maxima = temperatura;
            }
            lecturas++;
            suma = suma + temperatura;
            if (temperatura > 35 || temperatura < 2) {
                alertas++;
            }
            temperatura = teclado.nextInt();
        }

        if (lecturas == 0) {
            System.out.println("Sin lecturas");
        } else {
            System.out.println("Lecturas: " + lecturas);
            System.out.printf(Locale.US, "Media: %.1f%n", (double) suma / lecturas);
            System.out.println("Máxima: " + maxima);
            System.out.println("Alertas: " + alertas);
        }

        teclado.close();
    }
}
