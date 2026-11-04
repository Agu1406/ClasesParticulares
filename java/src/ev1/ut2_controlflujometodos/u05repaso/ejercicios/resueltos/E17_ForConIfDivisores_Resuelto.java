package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Recorre 1..n y muestra divisores usando if.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main recorre 1..n y muestra divisores usando if.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E17_ForConIfDivisores_Resuelto {
    public static void main(String[] args) {
        int n = 12;
        System.out.println("Divisores de " + n + ":");
        for (int d = 1; d <= n; d++) {
            if (n % d == 0) {
                System.out.println(d);
            }
        }
    }
}
