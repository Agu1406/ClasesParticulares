package ev4.E05_ExamenRA2.E02_MultiplosEnRango;

import java.util.Scanner;

/**
 * Cuenta y suma multiplos de un divisor en un rango.
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

        System.out.print("Inicio => ");
        int inicio = teclado.nextInt();
        System.out.print("Fin => ");
        int fin = teclado.nextInt();
        System.out.print("Divisor => ");
        int divisor = teclado.nextInt();

        if (divisor == 0) {
            System.out.println("Error: el divisor no puede ser 0.");
            return;
        }

        if (inicio > fin) {
            int aux = inicio;
            inicio = fin;
            fin = aux;
        }

        int contador = 0;
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            if (i % divisor == 0) {
                contador = contador + 1;
                suma = suma + i;
            }
        }

        System.out.println("Multiplos encontrados: " + contador);
        System.out.println("Suma de multiplos: " + suma);
    }
}
