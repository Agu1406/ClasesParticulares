package general.trycatchfinally;

/**
 * Ejercicio 11: División con validaciones y {@code throw}
 * Versión resuelta.
 *
 * <p>El código contempla:</p>
 * <ul>
 *   <li>El segundo número no sea cero</li>
 *   <li>El primer número no sea cero ni negativo</li>
 *   <li>El primer valor sea mayor que 100</li>
 * </ul>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio11_TryCatchFinally_RESUELTO {

    public static double dividirConReglas(int primerNumero, int segundoNumero) {
        if (segundoNumero == 0) {
            throw new IllegalArgumentException("El segundo número no puede ser cero.");
        }
        if (primerNumero <= 0) {
            throw new IllegalArgumentException("El primer número no puede ser cero ni negativo.");
        }
        if (primerNumero <= 100) {
            throw new IllegalArgumentException("El primer número debe ser mayor que 100.");
        }
        return (double) primerNumero / segundoNumero;
    }

    public static void main(String[] args) {
        int primerNumero = 150;
        int segundoNumero = 3;

        try {
            double resultado = dividirConReglas(primerNumero, segundoNumero);
            System.out.println("Resultado de la división: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}
