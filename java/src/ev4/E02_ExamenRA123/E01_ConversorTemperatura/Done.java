package ev4.E02_ExamenRA123.E01_ConversorTemperatura;

import java.util.Scanner;

/**
 * Conversor de temperatura entre Celsius y Fahrenheit.
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

        System.out.print("Temperatura => ");
        double temperatura = teclado.nextDouble();

        System.out.print("Escala de origen (C/F) => ");
        String textoEscala = teclado.next();
        char escala = textoEscala.charAt(0);

        double resultado;
        String de;
        String a;

        if (escala == 'C' || escala == 'c') {
            // F = C * 9.0 / 5.0 + 32
            resultado = temperatura * 9.0 / 5.0 + 32;
            de = "°C";
            a = "°F";
        } else if (escala == 'F' || escala == 'f') {
            // C = (F - 32) * 5.0 / 9.0
            resultado = (temperatura - 32) * 5.0 / 9.0;
            de = "°F";
            a = "°C";
        } else {
            System.out.println("Escala no válida. Usa C o F.");
            return;
        }

        System.out.println(temperatura + " " + de + " equivalen a " + resultado + " " + a);

        // Casteo a int: se pierden los decimales (truncado).
        int resultadoEntero = (int) resultado;
        System.out.println("Valor truncado (int): " + resultadoEntero);
    }
}
