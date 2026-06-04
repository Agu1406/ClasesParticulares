package ev1.ut2.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: while con if-else
 * Objetivo: Cuenta del 1 al 25 y clasifica en bajo/alto con if-else.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio12_WhileConIfElseRango_RESUELTO {
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
