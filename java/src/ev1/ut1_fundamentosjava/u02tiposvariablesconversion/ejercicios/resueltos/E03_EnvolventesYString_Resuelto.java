package ev1.ut1_fundamentosjava.u02tiposvariablesconversion.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Declara un {@code Integer} 123456, un {@code Double} 3.1415926535,
 * un {@code Character} A, un {@code Boolean} true y un {@code String} con el texto
 * Hola, soy un texto. Imprime los cinco.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Las envolventes se asignan con el mismo literal que el primitivo.
 * {@code String} va entre comillas dobles. Cada una se imprime en su linea.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E03_EnvolventesYString_Resuelto {
    public static void main(String[] args) {
        Integer myInt = 123_456;
        Double myDouble = 3.1415926535;
        Character myChar = 'A';
        Boolean myBoolean = true;
        String myString = "Hola, soy un texto";

        System.out.println(myInt);
        System.out.println(myDouble);
        System.out.println(myChar);
        System.out.println(myBoolean);
        System.out.println(myString);
    }
}
