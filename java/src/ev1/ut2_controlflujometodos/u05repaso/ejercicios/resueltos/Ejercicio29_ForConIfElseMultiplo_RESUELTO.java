package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: for con if-else
 * Objetivo: Del 1 al 40 muestra multiplo de 4 o no con if-else.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio29_ForConIfElseMultiplo_RESUELTO {
    public static void main(String[] args) {
        for (int i = 1; i <= 40; i++) {
            if (i % 4 == 0) {
                System.out.println(i + " multiplo de 4");
            } else {
                System.out.println(i + " no es multiplo de 4");
            }
        }
    }
}
