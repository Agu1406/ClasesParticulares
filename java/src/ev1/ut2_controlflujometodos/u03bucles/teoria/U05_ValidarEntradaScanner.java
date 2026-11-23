package ev1.ut2_controlflujometodos.u03bucles.teoria;

import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> comprobar el tipo con {@code hasNextInt}/{@code hasNextDouble}
 * antes de leer, para no romper el programa con una excepcion.</p>
 *
 * <p>Relacionado con Galicia viaxe (U2T3) y con {@code E12} ejercicio 3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_ValidarEntradaScanner {

    public static void main(String[] args) {
        Scanner teclado;
        int edad;

        teclado = new Scanner(System.in);
        System.out.print("Edad (entero): ");

        if (!teclado.hasNextInt()) {
            System.out.println("Dato no valido");
            teclado.close();
            return;
        }

        edad = teclado.nextInt();
        if (edad < 0 || edad > 120) {
            System.out.println("Fuera de rango");
        } else {
            System.out.println("Edad leida: " + edad);
        }

        teclado.close();
    }
}
