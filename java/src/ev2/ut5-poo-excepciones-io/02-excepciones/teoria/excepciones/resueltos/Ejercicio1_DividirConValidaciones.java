package general.excepciones.resueltos;

/**
 * Práctica Excepciones 1 (resuelto)
 * Diseña un programa que divide dos números.
 * 
 * El código contempla:
 * - Que el segundo número no sea cero
 * - Que el primer número no sea cero ni menor que cero
 * - Que el primer valor sea mayor que 100
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_DividirConValidaciones {

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

