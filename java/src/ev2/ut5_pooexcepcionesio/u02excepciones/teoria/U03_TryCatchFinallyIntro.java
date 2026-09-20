package ev2.ut5_pooexcepcionesio.u02excepciones.teoria;

import java.util.Scanner;

/**
 * Teoria: {@code try}, {@code catch} y {@code finally} en Java.
 *
 * <p><b>Objetivo:</b> capturar errores en tiempo de ejecucion sin detener todo el programa
 * y ejecutar codigo de limpieza con {@code finally}. Varios {@code catch}: de mas concreto
 * a mas general. Entrada por teclado como en UT3 ({@code Scanner} + {@code parseInt}).</p>
 *
 * <p>Indice: {@link U01_ExcepcionesIntro}. Anterior: {@link U02_ExcepcionesConceptos}.
 * Siguiente: {@link U04_ThrowThrowsYExcepcionesPropias}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 06/09/2026
 * @see U02_ExcepcionesConceptos
 * @see U04_ThrowThrowsYExcepcionesPropias
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_TryCatchFinallyIntro {

    public static void main(String[] args) {
        System.out.println("=== TRY - CATCH - FINALLY ===\n");

        ejemploBasico();
        System.out.println();

        ejemploMultiplesCatch("20", "0");
        ejemploMultiplesCatch("hola", "5");
        System.out.println();

        ejemploFinally();
        System.out.println();

        ejemploCatchGenerico();
        System.out.println();

        ejemploScanner();
    }

    private static void ejemploBasico() {
        System.out.println("1) TRY-CATCH BASICO (division entre cero)");
        try {
            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
        }
    }

    private static void ejemploMultiplesCatch(String textoNumero, String textoDivisor) {
        System.out.println("2) VARIOS CATCH con entradas: " + textoNumero + " y " + textoDivisor);
        /*
         * Java entra en el primer catch que coincida.
         * Orden: de mas concreto a mas general.
         */
        try {
            int numero = Integer.parseInt(textoNumero);
            int divisor = Integer.parseInt(textoDivisor);
            int resultado = numero / divisor;
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: debes escribir numeros validos.");
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
        }
    }

    private static void ejemploFinally() {
        System.out.println("3) FINALLY (siempre se ejecuta)");
        try {
            System.out.println("Dentro del try.");
            int valor = 5 / 0;
            System.out.println(valor);
        } catch (ArithmeticException e) {
            System.out.println("Se capturo: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("finally: bloque de limpieza / cierre de operacion.");
        }
    }

    private static void ejemploCatchGenerico() {
        System.out.println("4) CATCH GENERICO (Exception) — util al empezar (ejercicios 1-4)");
        try {
            Integer.parseInt("xyz");
        } catch (Exception e) {
            System.out.println("Error controlado: " + e.getClass().getSimpleName()
                    + " -> " + e.getMessage());
        }
    }

    private static void ejemploScanner() {
        System.out.println("5) SCANNER + parseInt (estilo UT3)");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe un entero --> ");
        String linea = teclado.nextLine().trim();
        try {
            int n = Integer.parseInt(linea);
            System.out.println("Numero leido: " + n);
        } catch (NumberFormatException e) {
            System.out.println("No es un entero valido: \"" + linea + "\"");
        } finally {
            System.out.println("finally: fin de la lectura.");
        }
        teclado.close();
    }
}
