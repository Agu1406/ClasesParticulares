package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Del 1 al 40 muestra multiplo de 4 o no con if-else.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main del 1 al 40 muestra multiplo de 4 o no con if-else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E29_ForConIfElseMultiplo_Resuelto {
    public static void main(String[] args) {
        for (int numero = 1; numero <= 40; numero++) {
            if (numero % 4 == 0) {
                System.out.println(numero + " multiplo de 4");
            } else {
                System.out.println(numero + " no es multiplo de 4");
            }
        }
    }
}
