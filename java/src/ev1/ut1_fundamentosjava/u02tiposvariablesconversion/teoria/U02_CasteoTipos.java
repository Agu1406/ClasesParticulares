package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.teoria;

/**
 * <p><b>OBJETIVO:</b> Convertir un tipo primitivo en otro con casteo {@code (tipo)} y ver qué
 * ocurre (agregar decimales, truncar, o pasar de {@code char} a su código numérico).</p>
 *
 * <p>Debes estar ya familiarizado con comentarios, sintaxis básica, variables e impresión
 * por pantalla, y diferenciar en teoría los datos primitivos de los avanzados.</p>
 *
 * <p>Practica en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}, el E02.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 * @since 03/06/2026
 */
public class U02_CasteoTipos {
    public static void main(String[] args) {
        int edadProfesorE = 26, alturaProfesorE, letraInt;
        double alturaProfesorD = 1.76, edadProfesorD, letraDouble;
        char letraChar = 'A';
        byte edadProfesorB;
        float alturaProfesorF;
        boolean esHumano = true;

        /*
         * Se lee de derecha a izquierda, de la siguiente forma:
         *
         * "Transforma edadProfesorE a double y luego guarda el resultado de esa
         * transformación en edadProfesorD".
         */
        edadProfesorD = (double) edadProfesorE;
        System.out.print("" +
                "\n¡Ejemplo de conversión de INT a DOUBLE!\n" +
                "\n" +
                "- Edad profesor (int): " + edadProfesorE + ".\n" +
                "- Edad profesor (double): " + edadProfesorD + ".\n" +
                "");

        /*
         * Cuando Java convierte números decimales en números enteros los decimales no
         * se redondean nunca, se ignoran, como si no existieran y Java se queda solo
         * con el número entero original.
         */
        alturaProfesorE = (int) alturaProfesorD;
        System.out.print("" +
                "\n¡Ejemplo de conversión de DOUBLE a INT!\n" +
                "\n" +
                "- Altura profesor (double): " + alturaProfesorD + ".\n" +
                "- Altura profesor (int): " + alturaProfesorE + ".\n" +
                "");

        /*
         * Para las máquinas no existen las letras, ellas solo ven números, entonces
         * en los lenguajes de programación cada letra/carácter/símbolo está asociado
         * a un número; esos números se conocen como ASCII.
         *
         * https://elcodigoascii.com.ar
         */
        letraInt = (int) letraChar;
        System.out.print("" +
                "\n¡Ejemplo de conversión de CHAR a INT!\n" +
                "\n" +
                "- Letra (char): " + letraChar + ".\n" +
                "- Letra (int): " + letraInt + ".\n" +
                "");

        /*
         * Un char también se puede pasar a double: es el mismo código ASCII,
         * pero con .0 al final. Poco útil en la práctica, pero funciona.
         */
        letraDouble = (double) letraChar;
        System.out.print("" +
                "\n¡Ejemplo de conversión de CHAR a DOUBLE!\n" +
                "\n" +
                "- Letra (char): " + letraChar + ".\n" +
                "- Letra (double): " + letraDouble + ".\n" +
                "");

        /*
         * El mismo proceso vale para otras primitivas numéricas
         * (byte, float, short, long, etc.).
         */
        edadProfesorB = (byte) edadProfesorE;
        alturaProfesorF = (float) alturaProfesorD;
        System.out.print("" +
                "\n¡Ejemplo de conversión a BYTE y a FLOAT!\n" +
                "\n" +
                "- Edad profesor (int): " + edadProfesorE + ".\n" +
                "- Edad profesor (byte): " + edadProfesorB + ".\n" +
                "- Altura profesor (double): " + alturaProfesorD + ".\n" +
                "- Altura profesor (float): " + alturaProfesorF + ".\n" +
                "");

        /*
         * boolean NO se puede castear a número ni a char (ni al revés).
         * Solo admite true o false; lo imprimimos tal cual.
         */
        System.out.print("" +
                "\n¡Boolean no admite casteo!\n" +
                "\n" +
                "- ¿Es humano? (boolean): " + esHumano + ".\n" +
                "");
    }
}
