package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Declara e imprime un {@code byte} 42, un {@code short} 32000,
 * un {@code char} A, un {@code int} 123456, un {@code long} 123456789, un {@code float} 3.14,
 * un {@code double} 3.1415926535 y un {@code boolean} true. Una linea por valor.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Cada primitivo se declara con su literal (la L del long y la f del float)
 * y se imprime con {@code System.out.println}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E01_OchoPrimitivos_Resuelto {
    public static void main(String[] args) {
        byte unByte = 42;
        short unShort = 32000;
        char unChar = 'A';
        int unInt = 123456;
        long unLong = 123456789L;
        float unFloat = 3.14f;
        double unDouble = 3.1415926535;
        boolean unBoolean = true;

        System.out.println(unByte);
        System.out.println(unShort);
        System.out.println(unChar);
        System.out.println(unInt);
        System.out.println(unLong);
        System.out.println(unFloat);
        System.out.println(unDouble);
        System.out.println(unBoolean);
    }
}
