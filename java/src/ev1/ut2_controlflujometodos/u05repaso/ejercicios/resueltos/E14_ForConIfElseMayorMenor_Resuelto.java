package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Compara cada valor de un array con un umbral usando if-else.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main compara cada valor de un array con un umbral usando if-else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E14_ForConIfElseMayorMenor_Resuelto {
    public static void main(String[] args) {
        int[] datos = {2, 9, 5, 11, 4};
        int umbral = 6;
        for (int v : datos) {
            if (v >= umbral) {
                System.out.println(v + " >= " + umbral);
            } else {
                System.out.println(v + " < " + umbral);
            }
        }
    }
}
