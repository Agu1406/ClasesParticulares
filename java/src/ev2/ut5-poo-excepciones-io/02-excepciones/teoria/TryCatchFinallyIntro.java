package general.trycatchfinally;

/**
 * Teoría: {@code try}, {@code catch}, {@code finally} y {@code throw} en Java.
 *
 * <p><b>Objetivo:</b> capturar errores en tiempo de ejecución sin detener todo el programa
 * y liberar recursos con {@code finally}.</p>
 *
 * <p>Índice del subtema: {@link ExcepcionesIntro}.
 * Ejercicios en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class TryCatchFinallyIntro {

    public static void main(String[] args) {
        System.out.println("=== TRY - CATCH - FINALLY (demo) ===");
        System.out.println();

        // 1) Ejemplo básico: posible división por cero
        ejemploDivision(10, 0);
        System.out.println();

        // 2) Ejemplo con múltiples catch: parseo + división
        ejemploMultiplesCatch("20", "0");
        ejemploMultiplesCatch("hola", "5");
        System.out.println();

        // 3) Ejemplo con finally
        ejemploConFinally();
        System.out.println();

        // 4) Lanzar excepciones manualmente (throw)
        ejemploThrowManual(150);
        ejemploThrowManual(25);
        System.out.println();

        // 5) Excepciones personalizadas (propias)
        ejemploExcepcionPropia(-3);
        ejemploExcepcionPropia(30);
    }

    private static void ejemploDivision(int a, int b) {
        System.out.println("1) EJEMPLO BÁSICO");
        try {
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
            System.out.println("Detalle técnico: " + e.getMessage());
        }
    }

    private static void ejemploMultiplesCatch(String textoNumero, String textoDivisor) {
        System.out.println("2) MÚLTIPLES CATCH con entradas: " + textoNumero + " y " + textoDivisor);
        try {
            int numero = Integer.parseInt(textoNumero);
            int divisor = Integer.parseInt(textoDivisor);
            int resultado = numero / divisor;
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: debes escribir números válidos.");
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
        }
    }

    private static void ejemploConFinally() {
        System.out.println("3) EJEMPLO CON FINALLY");
        try {
            System.out.println("Dentro del try.");
            int valor = 5 / 0; // Fuerza la excepción
            System.out.println(valor); // No se ejecuta
        } catch (ArithmeticException e) {
            System.out.println("Se capturó la excepción: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("finally SIEMPRE se ejecuta (para liberar recursos, cerrar ficheros, etc.).");
        }
    }

    private static void ejemploThrowManual(int porcentajeDescuento) {
        System.out.println("4) THROW MANUAL con descuento: " + porcentajeDescuento);
        try {
            validarDescuento(porcentajeDescuento);
            System.out.println("Descuento aceptado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    private static void validarDescuento(int descuento) {
        // Lanzamos la excepción "a voluntad" si la regla no se cumple.
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
        }
    }

    private static void ejemploExcepcionPropia(int edad) {
        System.out.println("5) EXCEPCIÓN PROPIA con edad: " + edad);
        try {
            validarEdad(edad);
            System.out.println("Edad válida para el registro.");
        } catch (EdadInvalidaException e) {
            System.out.println("Excepción personalizada: " + e.getMessage());
        }
    }

    private static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("Edad fuera de rango permitido (0-120).");
        }
    }

    // Excepción personalizada (checked exception).
    static class EdadInvalidaException extends Exception {
        public EdadInvalidaException(String mensaje) {
            super(mensaje);
        }
    }
}
