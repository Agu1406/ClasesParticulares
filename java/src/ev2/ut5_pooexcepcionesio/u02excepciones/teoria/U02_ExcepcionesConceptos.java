package ev2.ut5_pooexcepcionesio.u02excepciones.teoria;

/**
 * Teoria: que es una excepcion y tipos habituales en Java.
 *
 * <p><b>Objetivo:</b> ver fallos en tiempo de ejecucion (el codigo compila, pero al
 * correr puede romper) y reconocer las excepciones mas usadas en este subtema,
 * enlazando con parseo de Strings (UT3), division y arrays (UT4).</p>
 *
 * <p>Indice: {@link U01_ExcepcionesIntro}. Siguiente: {@link U03_TryCatchFinallyIntro}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 06/09/2026
 * @see U03_TryCatchFinallyIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_ExcepcionesConceptos {

    public static void main(String[] args) {
        System.out.println("=== EXCEPCIONES: CONCEPTOS ===\n");

        /*
         * Sin try-catch el programa se detiene y muestra el stack trace.
         * Aqui capturamos para poder ver varios tipos en la misma demo.
         */
        System.out.println("1) NumberFormatException (UT3: Integer.parseInt)");
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("   Capturado: " + e.getClass().getSimpleName());
            System.out.println("   Mensaje: " + e.getMessage());
        }
        System.out.println();

        System.out.println("2) ArithmeticException (division entera entre cero)");
        try {
            int x = 10 / 0;
            System.out.println(x);
        } catch (ArithmeticException e) {
            System.out.println("   Capturado: " + e.getClass().getSimpleName());
            System.out.println("   Mensaje: " + e.getMessage());
        }
        System.out.println();

        System.out.println("3) NullPointerException (usar un String null)");
        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            System.out.println("   Capturado: " + e.getClass().getSimpleName());
            System.out.println("   Mensaje: " + e.getMessage());
        }
        System.out.println();

        /*
         * Posiciones => [0][1]
         * Valores    => [10][20]
         * numeros[5] no existe -> ArrayIndexOutOfBoundsException
         */
        System.out.println("4) ArrayIndexOutOfBoundsException (UT4 arrays)");
        try {
            int[] numeros = {10, 20};
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Capturado: " + e.getClass().getSimpleName());
            System.out.println("   Mensaje: " + e.getMessage());
        }

        System.out.println("\nResumen:");
        System.out.println("  NumberFormatException           -> parseo incorrecto");
        System.out.println("  ArithmeticException             -> division entre cero");
        System.out.println("  NullPointerException            -> objeto null");
        System.out.println("  ArrayIndexOutOfBoundsException  -> indice invalido");
        System.out.println("\nSiguiente: U03_TryCatchFinallyIntro");
    }
}
