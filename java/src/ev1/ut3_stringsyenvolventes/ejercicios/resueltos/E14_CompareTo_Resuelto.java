package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Compara dos o mas cadenas con {@code compareTo} y
 * {@code compareToIgnoreCase}. Interpreta el resultado: negativo si la primera va antes,
 * cero si son iguales en orden, positivo si va despues. Muestra los valores por consola.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code compareTo} usa orden lexicografico (Unicode).
 * {@code "casa".compareTo("caso")} es negativo porque en la primera diferencia
 * {@code 'a' < 'o'}. {@code compareToIgnoreCase} trata mayusculas y minusculas como iguales,
 * por eso {@code "Java".compareToIgnoreCase("java")} es {@code 0}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/08/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E14_CompareTo_Resuelto {

    public static void main(String[] args) {
        String x = "casa";
        String y = "caso";
        int orden = x.compareTo(y);
        System.out.println("compareTo(\"" + x + "\", \"" + y + "\"): " + orden);
        if (orden < 0) {
            System.out.println("\"" + x + "\" va antes que \"" + y + "\"");
        } else if (orden > 0) {
            System.out.println("\"" + x + "\" va despues que \"" + y + "\"");
        } else {
            System.out.println("Mismo orden");
        }

        String a = "Java";
        String b = "java";
        int sinMayus = a.compareToIgnoreCase(b);
        System.out.println("compareToIgnoreCase(\"" + a + "\", \"" + b + "\"): " + sinMayus);
        if (sinMayus == 0) {
            System.out.println("Iguales ignorando mayusculas");
        }
    }
}
