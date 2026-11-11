package ev4.E06_ExamenRA2.E02_SumaHastaLimite;

import java.util.Scanner;

/**
 * Suma enteros hasta alcanzar o superar un limite.
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

        System.out.print("Limite positivo => ");
        int limite = teclado.nextInt();

        if (limite <= 0) {
            System.out.println("Error: el limite debe ser positivo.");
            return;
        }

        int suma = 0;
        int cantidad = 0;

        while (suma < limite) {
            System.out.print("Numero => ");
            int n = teclado.nextInt();
            suma = suma + n;
            cantidad = cantidad + 1;
        }

        System.out.println("Suma final: " + suma);
        System.out.println("Numeros leidos: " + cantidad);
        if (suma == limite) {
            System.out.println("Se igualo el limite exactamente.");
        } else {
            System.out.println("Se supero el limite.");
        }
    }
}
