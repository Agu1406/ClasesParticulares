package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea dos Integer con valor 100, uno con valueOf desde el texto 100 y otro con el literal, e imprime == y equals. Repite la comparacion con 1000.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Con 100, == y equals pueden coincidir por la cache de Integer. Con 1000, == es false y equals es true.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E13_ValueOfYEquals_Resuelto {
    public static void main(String[] args) {
        Integer a = Integer.valueOf("100");
        Integer b = 100;
        System.out.println("a == b: " + (a == b));
        System.out.println("a.equals(b): " + a.equals(b));
        Integer grandeA = Integer.valueOf(1000);
        Integer grandeB = Integer.valueOf(1000);
        System.out.println("1000: a == b -> " + (grandeA == grandeB));
        System.out.println("1000: a.equals(b) -> " + grandeA.equals(grandeB));
    }
}
