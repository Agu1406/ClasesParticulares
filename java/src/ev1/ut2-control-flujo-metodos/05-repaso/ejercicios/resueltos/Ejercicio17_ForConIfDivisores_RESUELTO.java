package general.repaso;

/**
 * Ejercicio: for con if
 * Objetivo: Recorre 1..n y muestra divisores usando if.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio17_ForConIfDivisores_RESUELTO {
    public static void main(String[] args) {
        int n = 12;
        System.out.println("Divisores de " + n + ":");
        for (int d = 1; d <= n; d++) {
            if (n % d == 0) {
                System.out.println(d);
            }
        }
    }
}
