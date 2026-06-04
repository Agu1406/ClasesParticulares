package general.repaso;

/**
 * Ejercicio: for con if
 * Objetivo: Recorre 2..50 y muestra numeros primos usando if.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio20_ForConIfPrimos_RESUELTO {
    public static void main(String[] args) {
        for (int n = 2; n <= 50; n++) {
            boolean primo = true;
            for (int d = 2; d * d <= n; d++) {
                if (n % d == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) {
                System.out.println(n);
            }
        }
    }
}
