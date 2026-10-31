package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Para n = 1, 2, 3, 4 y 5 muestra n, su cuadrado, su cubo
 * y su raíz cuadrada con tres decimales. Sin bucles.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code Math.pow} para el cuadrado y el cubo, {@code Math.sqrt}
 * para la raíz. Una línea por valor.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E19_PotenciasYRaices_Resuelto {
    public static void main(String[] args) {
        System.out.printf("n=%d cuad=%.0f cubo=%.0f raiz=%.3f%n", 1, Math.pow(1, 2), Math.pow(1, 3), Math.sqrt(1));
        System.out.printf("n=%d cuad=%.0f cubo=%.0f raiz=%.3f%n", 2, Math.pow(2, 2), Math.pow(2, 3), Math.sqrt(2));
        System.out.printf("n=%d cuad=%.0f cubo=%.0f raiz=%.3f%n", 3, Math.pow(3, 2), Math.pow(3, 3), Math.sqrt(3));
        System.out.printf("n=%d cuad=%.0f cubo=%.0f raiz=%.3f%n", 4, Math.pow(4, 2), Math.pow(4, 3), Math.sqrt(4));
        System.out.printf("n=%d cuad=%.0f cubo=%.0f raiz=%.3f%n", 5, Math.pow(5, 2), Math.pow(5, 3), Math.sqrt(5));
    }
}
