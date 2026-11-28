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
        int numero = 0;
        while (numero < nums.length) {
            if (nums[numero] > 0) {
                System.out.println(nums[numero] + " positivo");
            } else if (nums[numero] < 0) {
                System.out.println(nums[numero] + " negativo");
            } else {
                System.out.println("cero");
            }
            numero++;
        }
    }
}
