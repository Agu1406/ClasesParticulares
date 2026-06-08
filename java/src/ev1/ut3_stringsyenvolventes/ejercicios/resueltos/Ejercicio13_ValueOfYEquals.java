package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * Ejercicio 13: valueOf, autoboxing y equals en Integer
 * Crea dos Integer con el valor 100 (uno con valueOf desde String, otro con literal)
 * e imprime el resultado de == y de equals.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio13_ValueOfYEquals {

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
