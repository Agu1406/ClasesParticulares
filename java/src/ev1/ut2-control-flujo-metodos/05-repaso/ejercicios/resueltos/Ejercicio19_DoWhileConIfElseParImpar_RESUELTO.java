package general.repaso;

/**
 * Ejercicio: do-while con if-else
 * Objetivo: Del 1 al 18 muestra par o impar con if-else.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio19_DoWhileConIfElseParImpar_RESUELTO {
    public static void main(String[] args) {
        int i = 1;
        do {
            if (i % 2 == 0) {
                System.out.println(i + " par");
            } else {
                System.out.println(i + " impar");
            }
            i++;
        } while (i <= 18);
    }
}
