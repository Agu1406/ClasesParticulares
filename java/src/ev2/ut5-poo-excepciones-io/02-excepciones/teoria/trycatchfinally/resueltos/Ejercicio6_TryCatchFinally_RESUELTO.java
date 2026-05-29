package general.trycatchfinally;

/**
 * Ejercicio 6: Varios catch: parse o índice
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio6_TryCatchFinally_RESUELTO {
    public static void main(String[] args) {
        try {
                    String txt = "hola"; int[] a = {1}; int n = Integer.parseInt(txt); System.out.println(a[n]);
                    System.out.println("Bloque try ejecutado correctamente.");
                } catch (NumberFormatException e) {
                    System.out.println("Error de formato numérico.");
                } catch (ArithmeticException e) {
                    System.out.println("Error aritmético.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Índice fuera de rango.");
                } catch (NullPointerException e) {
                    System.out.println("Referencia nula.");
                }
    }
}
