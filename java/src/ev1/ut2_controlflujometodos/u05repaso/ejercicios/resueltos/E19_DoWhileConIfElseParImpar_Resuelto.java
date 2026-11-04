package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Del 1 al 18 muestra par o impar con if-else.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main del 1 al 18 muestra par o impar con if-else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E19_DoWhileConIfElseParImpar_Resuelto {
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
