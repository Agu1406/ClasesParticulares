package ev4.E03_ExamenRA123.E03_AprenderASumar;

import java.util.Random;
import java.util.Scanner;

/**
 * Practica N sumas de tres numeros aleatorios; pierdes con N/2 errores (division entera).
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
        Random aleatorio = new Random();

        System.out.print("¿Cuántas sumas quieres practicar? (2-50) => ");
        int n = teclado.nextInt();

        if (n < 2 || n > 50) {
            System.out.println("Error: N debe estar entre 2 y 50.");
            return;
        }

        int limiteErrores = n / 2;
        int errores = 0;

        for (int i = 1; i <= n; i++) {
            int a = aleatorio.nextInt(91) + 10;
            int b = aleatorio.nextInt(91) + 10;
            int c = aleatorio.nextInt(91) + 10;
            int sumaCorrecta = a + b + c;

            System.out.println();
            System.out.println("Suma " + i + " de " + n + ":");
            System.out.print(a + " + " + b + " + " + c + " = ? => ");
            int respuesta = teclado.nextInt();

            if (respuesta == sumaCorrecta) {
                System.out.println("Correcto.");
            } else {
                errores = errores + 1;
                System.out.println("Incorrecto. Era " + sumaCorrecta + ".");
                System.out.println("Errores: " + errores + " / " + limiteErrores);

                if (errores >= limiteErrores) {
                    System.out.println("Has perdido: demasiados errores.");
                    return;
                }
            }
        }

        System.out.println();
        System.out.println("Has ganado: completaste las " + n + " sumas.");
    }
}
