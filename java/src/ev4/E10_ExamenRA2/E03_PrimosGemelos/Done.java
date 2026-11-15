package ev4.E10_ExamenRA2.E03_PrimosGemelos;

import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> metodo {@code esPrimo} y parejas de primos gemelos en un intervalo.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> divisores hasta la raiz; el bucle para en {@code p + 2 <= b}
 * para que la pareja entera quede dentro.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 15/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    static boolean esPrimo(int n) {
        int divisor;

        if (n < 2) {
            return false;
        }
        for (divisor = 2; divisor * divisor <= n; divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        int extremoA, extremoB, primo, parejas;

        teclado = new Scanner(System.in);
        extremoA = teclado.nextInt();
        extremoB = teclado.nextInt();

        if (extremoA > extremoB) {
            System.out.println("Intervalo no válido");
        } else {
            parejas = 0;
            for (primo = extremoA; primo + 2 <= extremoB; primo++) {
                if (esPrimo(primo) && esPrimo(primo + 2)) {
                    System.out.println(primo + " " + (primo + 2));
                    parejas++;
                }
            }
            System.out.println("Parejas: " + parejas);
        }

        teclado.close();
    }
}
