package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Del 1 al 12 muestra aprobado/suspenso segun nota simulada.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main del 1 al 12 muestra aprobado/suspenso segun nota simulada.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E07_DoWhileConIfElse_Resuelto {
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
