package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Muestra multiplos de 5 del 1 al 50 con if.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main muestra multiplos de 5 del 1 al 50 con if.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E13_DoWhileConIfMultiplos_Resuelto {
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
