package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.teoria;

/**
 * <p><b>OBJETIVO:</b> Ver las clases envolventes de los primitivos y un {@code String},
 * que son objetos y no tipos primitivos.</p>
 *
 * <p>Practica en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}, el E03.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_DatosAvanzados {
    public static void main(String[] args) {
        Byte myByte = 42;
        Short myShort = 32_000;
        Character myChar = 'A';
        Integer myInt = 123_456;
        Long myLong = 123_456_789L;
        Float myFloat = 3.14f;
        Double myDouble = 3.1415926535;
        String myString = "Hola, soy un texto";

        System.out.println("Byte: " + myByte);
        System.out.println("Short: " + myShort);
        System.out.println("Character: " + myChar);
        System.out.println("Integer: " + myInt);
        System.out.println("Long: " + myLong);
        System.out.println("Float: " + myFloat);
        System.out.println("Double: " + myDouble);
        System.out.println("String: " + myString);
    }
}
