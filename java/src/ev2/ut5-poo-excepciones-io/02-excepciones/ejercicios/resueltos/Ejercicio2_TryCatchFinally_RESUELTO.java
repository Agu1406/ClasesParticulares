package general.trycatchfinally;

/**
 * Ejercicio 2: Un solo catch: ArithmeticException
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_TryCatchFinally_RESUELTO {
    public static void main(String[] args) {
        try {
                    int x = 10 / 0;
                    System.out.println("Bloque try ejecutado correctamente.");
                } catch (Exception e) {
                    System.out.println("Error controlado: " + e.getClass().getSimpleName());
                }
    }
}
