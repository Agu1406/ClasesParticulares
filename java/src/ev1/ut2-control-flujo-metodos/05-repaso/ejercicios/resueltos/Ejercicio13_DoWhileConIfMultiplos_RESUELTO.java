package general.repaso;

/**
 * Ejercicio: do-while con if
 * Objetivo: Muestra múltiplos de 5 del 1 al 50 con if.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio13_DoWhileConIfMultiplos_RESUELTO {
    public static void main(String[] args) {
        int n = 1;
        do {
            if (n % 5 == 0) {
                System.out.println(n);
            }
            n++;
        } while (n <= 50);
    }
}
