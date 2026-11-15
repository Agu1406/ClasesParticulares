package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.teoria;

/**
 * <p><b>OBJETIVO:</b> Declarar los ocho tipos primitivos de Java mostrando el rango
 * de los numericos (minimo y maximo) y un ejemplo de {@code char} y {@code boolean}.</p>
 *
 * <p>Practica en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}, el E01.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_DatosPrimitivos {
    public static void main(String[] args) {
        // --- Enteros (de menor a mayor tamaño) ---

        // byte: de -128 a 127
        byte byteMin = -128;
        byte byteMax = 127;

        // short: de -32.768 a 32.767
        short shortMin = -32768;
        short shortMax = 32767;

        // int: de -2.147.483.648 a 2.147.483.647
        int intMin = -2147483648;
        int intMax = 2147483647;

        // long: entero muy grande; la L final evita que se lea como int
        long longMin = -9223372036854775808L;
        long longMax = 9223372036854775807L;

        // --- Decimales ---

        // float: decimal de precision sencilla (lleva una f al final)
        float floatMin = -3.4028235E38f;
        float floatMax = 3.4028235E38f;

        // double: decimal de doble precision (el mas usado)
        double doubleMin = -1.7976931348623157E308;
        double doubleMax = 1.7976931348623157E308;

        // --- Caracter ---

        // char: un solo simbolo (letra, numero, signo...); rango Unicode 0 a 65535
        char charMin = 0;
        char charMax = 65535;
        char unChar = 'A';

        // --- Logico ---

        // boolean: solo puede ser true (verdadero) o false (falso)
        boolean verdadero = true;
        boolean falso = false;

        System.out.print("" +
                "byte min: " + byteMin + "\n" +
                "byte max: " + byteMax + "\n" +
                "short min: " + shortMin + "\n" +
                "short max: " + shortMax + "\n" +
                "int min: " + intMin + "\n" +
                "int max: " + intMax + "\n" +
                "long min: " + longMin + "\n" +
                "long max: " + longMax + "\n" +
                "float min: " + floatMin + "\n" +
                "float max: " + floatMax + "\n" +
                "double min: " + doubleMin + "\n" +
                "double max: " + doubleMax + "\n" +
                "char min: " + (int) charMin + "\n" +
                "char max: " + (int) charMax + "\n" +
                "char ejemplo: " + unChar + "\n" +
                "boolean true: " + verdadero + "\n" +
                "boolean false: " + falso + "\n" +
                "");
    }
}

