package general.bucles;

/**
 * Ejercicio 8 (for): Factorial de 6
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_FOR_RESUELTO {
    public static void main(String[] args) {
        int factorial = 1;
                for (int i = 1; i <= 6; i++) {
                    factorial *= i;
                }
                System.out.println("Factorial: " + factorial);
    }
}
