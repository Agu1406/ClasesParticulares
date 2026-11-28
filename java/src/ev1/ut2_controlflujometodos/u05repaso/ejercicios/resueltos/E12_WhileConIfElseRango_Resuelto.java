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
        int numero = 1;
        while (numero <= 25) {
            if (numero <= 12) {
                System.out.println(numero + " bajo");
            } else {
                System.out.println(numero + " alto");
            }
            numero++;
        }
    }
}
