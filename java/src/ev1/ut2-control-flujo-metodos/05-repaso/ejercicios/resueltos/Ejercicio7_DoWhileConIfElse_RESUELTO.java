package general.repaso;

/**
 * Ejercicio: do-while con if-else
 * Objetivo: Del 1 al 12 muestra aprobado/suspenso según nota simulada.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_DoWhileConIfElse_RESUELTO {
    public static void main(String[] args) {
        int i = 1;
        do {
            int nota = 4 + (i % 7);
            if (nota >= 5) {
                System.out.println("Nota " + nota + ": Aprobado");
            } else {
                System.out.println("Nota " + nota + ": Suspenso");
            }
            i++;
        } while (i <= 12);
    }
}
