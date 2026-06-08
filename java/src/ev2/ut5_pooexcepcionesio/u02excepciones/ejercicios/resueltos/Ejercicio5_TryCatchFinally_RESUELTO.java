package ev2.ut5_pooexcepcionesio.u02excepciones.ejercicios.resueltos;

/**
 * Ejercicio 5: Varios catch: null o indice
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_TryCatchFinally_RESUELTO {
    public static void main(String[] args) {
        try {
                    String s = null; int[] a = {1}; System.out.println(s.length()); System.out.println(a[2]);
                    System.out.println("Bloque try ejecutado correctamente.");
                } catch (NumberFormatException e) {
                    System.out.println("Error de formato numerico.");
                } catch (ArithmeticException e) {
                    System.out.println("Error aritmetico.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Indice fuera de rango.");
                } catch (NullPointerException e) {
                    System.out.println("Referencia nula.");
                }
    }
}
