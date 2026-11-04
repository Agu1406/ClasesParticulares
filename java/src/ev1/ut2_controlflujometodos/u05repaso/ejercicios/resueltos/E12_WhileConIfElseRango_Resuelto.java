package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Cuenta del 1 al 25 y clasifica en bajo/alto con if-else.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main cuenta del 1 al 25 y clasifica en bajo/alto con if-else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E12_WhileConIfElseRango_Resuelto {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 25) {
            if (i <= 12) {
                System.out.println(i + " bajo");
            } else {
                System.out.println(i + " alto");
            }
            i++;
        }
    }
}
