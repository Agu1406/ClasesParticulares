package ev2.ut5.u02excepciones.ejercicios.resueltos;

/**
 * Ejercicio 10: Varios catch + finally: null/indice
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_TryCatchFinally_RESUELTO {
    public static void main(String[] args) {
        try {
                    String s = "java"; int[] a = {1,2}; System.out.println(s.charAt(1)); System.out.println(a[0]);
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
