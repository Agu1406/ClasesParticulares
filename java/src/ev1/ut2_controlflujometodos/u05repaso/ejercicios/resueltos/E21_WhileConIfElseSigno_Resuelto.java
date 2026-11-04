package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Clasifica valores de un array en positivo/negativo con if-else.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main clasifica valores de un array en positivo/negativo con if-else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E21_WhileConIfElseSigno_Resuelto {
    public static void main(String[] args) {
        int[] nums = {4, -2, 0, 7, -5};
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0) {
                System.out.println(nums[i] + " positivo");
            } else if (nums[i] < 0) {
                System.out.println(nums[i] + " negativo");
            } else {
                System.out.println("cero");
            }
            i++;
        }
    }
}
