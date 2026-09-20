package ev2.ut5_pooexcepcionesio.u02excepciones.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea una excepcion propia comprobada (extiende {@code Exception})
 * y un metodo {@code validarEdad(int)} con {@code throws}. En el {@code main}, llama
 * al metodo dentro de {@code try/catch} con edades valida e invalida.
 * Enlace: teoria {@code U04_ThrowThrowsYExcepcionesPropias}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Las checked obligan a declarar {@code throws} o capturar.
 * {@code EdadInvalidaException} lleva el mensaje al {@code catch} via
 * {@code getMessage()}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 06/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E13_ThrowsChecked_Resuelto {

    static class EdadInvalidaException extends Exception {
        public EdadInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("Edad fuera de rango (0-120): " + edad);
        }
    }

    public static void main(String[] args) {
        probar(25);
        probar(-1);
    }

    private static void probar(int edad) {
        try {
            validarEdad(edad);
            System.out.println("Edad " + edad + " valida.");
        } catch (EdadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
