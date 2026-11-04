package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.teoria;

/**
 * <p><b>OBJETIVO:</b> Declarar los ocho tipos primitivos de Java e imprimir su valor.</p>
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
        // byte: numero entero muy pequeno (de -128 a 127)
        byte unByte = 42;

        // short: numero entero pequeno (de -32.768 a 32.767)
        short unShort = 32000;

        // char: un solo simbolo (letra, numero, signo, etc.)
        char unChar = 'A';

        // int: numero entero habitual (de -2.147.483.648 a 2.147.483.647)
        int unInt = 123456;

        // long: numero entero muy grande; la L final evita que se lea como int
        long unLong = 123456789L;

        // float: numero decimal de precision sencilla (lleva una f al final)
        float unFloat = 3.14f;

        // double: numero decimal de doble precision (el mas usado para decimales)
        double unDouble = 3.1415926535;

        // boolean: solo puede ser true (verdadero) o false (falso)
        boolean unBoolean = true;

        System.out.println("byte: " + unByte);
        System.out.println("short: " + unShort);
        System.out.println("char: " + unChar);
        System.out.println("int: " + unInt);
        System.out.println("long: " + unLong);
        System.out.println("float: " + unFloat);
        System.out.println("double: " + unDouble);
        System.out.println("boolean: " + unBoolean);
    }
}
