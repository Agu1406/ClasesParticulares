package general.bucles;

/**
 * Ejercicio 8 (dowhile): Factorial de 5
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_DOWHILE_RESUELTO {
    public static void main(String[] args) {
        int i = 1;
                int factorial = 1;
                do {
                    factorial *= i;
                    i++;
                } while (i <= 5);
                System.out.println("Factorial: " + factorial);
    }
}
