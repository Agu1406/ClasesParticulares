package general.repaso;

/**
 * Ejercicio: for con if-else
 * Objetivo: Del 1 al 40 muestra múltiplo de 4 o no con if-else.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio29_ForConIfElseMultiplo_RESUELTO {
    public static void main(String[] args) {
        for (int i = 1; i <= 40; i++) {
            if (i % 4 == 0) {
                System.out.println(i + " múltiplo de 4");
            } else {
                System.out.println(i + " no es múltiplo de 4");
            }
        }
    }
}
