package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Cuenta del 10 al 1 y muestra solo numeros mayores que 5.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main cuenta del 10 al 1 y muestra solo numeros mayores que 5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E04_DoWhileConIf_Resuelto {
    public static void main(String[] args) {
        int n = 10;
        do {
            if (n > 5) {
                System.out.println(n);
            }
            n--;
        } while (n >= 1);
    }
}
