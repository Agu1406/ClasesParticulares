package general.repaso;

/**
 * Ejercicio: while con if-else
 * Objetivo: Cuenta del 1 al 20 y muestra PAR/IMPAR con if-else.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_WhileConIfElse_RESUELTO {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 20) {
            if (i % 2 == 0) {
                System.out.println(i + " PAR");
            } else {
                System.out.println(i + " IMPAR");
            }
            i++;
        }
    }
}
