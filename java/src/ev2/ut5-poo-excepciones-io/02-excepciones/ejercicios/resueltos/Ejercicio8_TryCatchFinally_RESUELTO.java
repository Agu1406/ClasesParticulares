package general.trycatchfinally;

/**
 * Ejercicio 8: Catch + finally: division
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_TryCatchFinally_RESUELTO {
    public static void main(String[] args) {
        try {
                    int x = 100 / 5; System.out.println(x);
                    System.out.println("Bloque try ejecutado correctamente.");
                } catch (NumberFormatException e) {
                    System.out.println("Error de formato numerico.");
                } catch (ArithmeticException e) {
                    System.out.println("Error aritmetico.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Indice fuera de rango.");
                } catch (NullPointerException e) {
                    System.out.println("Referencia nula.");
                } finally {
                    System.out.println("Finally: fin del ejercicio.");
                }
    }
}
