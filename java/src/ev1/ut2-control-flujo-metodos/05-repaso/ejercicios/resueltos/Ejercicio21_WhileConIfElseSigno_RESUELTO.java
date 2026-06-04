package general.repaso;

/**
 * Ejercicio: while con if-else
 * Objetivo: Clasifica valores de un array en positivo/negativo con if-else.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio21_WhileConIfElseSigno_RESUELTO {
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
