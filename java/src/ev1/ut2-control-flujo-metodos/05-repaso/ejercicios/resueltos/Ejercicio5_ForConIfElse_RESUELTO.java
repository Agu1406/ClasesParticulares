package general.repaso;

/**
 * Ejercicio: for con if-else
 * Objetivo: Del 1 al 15 muestra si cada número es mayor o menor que 8.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_ForConIfElse_RESUELTO {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            if (i > 8) {
                System.out.println(i + " mayor que 8");
            } else {
                System.out.println(i + " menor o igual que 8");
            }
        }
    }
}
