package ev1.ut2_controlflujometodos.u01operadoresybasicos.teoria;

/**
 * <p><b>OBJETIVO:</b> saber en qué orden Java agrupa los operadores
 * (precedencia) y cuándo hace falta un paréntesis.</p>
 *
 * <p>De mayor a menor precedencia, lo que más vas a usar:</p>
 * <pre>
 *   ()  []  .   x++  x--
 *   ++x  --x  +x  -x  !  ~  (tipo)
 *   *  /  %
 *   +  -
 *   &lt;&lt;  &gt;&gt;  &gt;&gt;&gt;
 *   &lt;  &lt;=  &gt;  &gt;=
 *   ==  !=
 *   &amp;
 *   ^
 *   |
 *   &amp;&amp;
 *   ||
 *   ? :
 *   =  +=  -=  *=  /=  %=
 * </pre>
 *
 * <p>Con la misma precedencia, casi todos se agrupan de izquierda a derecha.
 * La asignación y el ternario se agrupan de derecha a izquierda:
 * {@code a = b = 4} es {@code a = (b = 4)}.</p>
 *
 * <p>En Java, {@code flags & 4 == 4} no compila: {@code ==} devuelve
 * {@code boolean} y {@code &} entre un {@code int} y un {@code boolean} no
 * existe. La forma que sí compila y hace lo que quieres es
 * {@code (flags & 4) == 4}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_ExpresionesYPrecedencia {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("¡INICIO DEL PROGRAMA!");
        System.out.println();

        /*
        PRIMERA PARTE - * y / van antes que + y -.
          2 + 3 * 4  se lee  2 + (3 * 4)  = 14
        */
        System.out.println("--- PRIMERA PARTE: Aritmetica ---");
        System.out.println();

        System.out.println("2 + 3 * 4     = " + (2 + 3 * 4));
        System.out.println("(2 + 3) * 4   = " + ((2 + 3) * 4));
        System.out.println("10 - 6 / 2    = " + (10 - 6 / 2));
        System.out.println("10 - 4 - 3    = " + (10 - 4 - 3) + "  (izquierda a derecha)");
        System.out.println("100 / 5 / 2   = " + (100 / 5 / 2));
        System.out.println("-3 * 2        = " + (-3 * 2));
        System.out.println("7 % 4 * 2     = " + (7 % 4 * 2) + "  (% y * empatan)");
        System.out.println();

        /*
        SEGUNDA PARTE - Asociatividad.
          a = b = c = 4  se lee de derecha a izquierda.
        */
        System.out.println("--- SEGUNDA PARTE: Asociatividad ---");
        System.out.println();

        int a;
        int b;
        int c;
        a = b = c = 4;
        System.out.println("a = b = c = 4 -> a=" + a + " b=" + b + " c=" + c);
        System.out.println("2 * 3 % 4 = " + (2 * 3 % 4) + "  ((2*3)%4)");

        int media = (8 + 6 + 10) / 3;
        System.out.println("Media de 8, 6 y 10 = " + media);
        System.out.println();

        /*
        TERCERA PARTE - Comparar y combinar.
          La aritmetica se resuelve antes que la comparacion.
          && se agrupa antes que ||:
              p || q && r    equivale a    p || (q && r)
          Escribe los parentesis para que quien lea no tenga que recordarlo.
        */
        System.out.println("--- TERCERA PARTE: Logica ---");
        System.out.println();

        boolean p = true;
        boolean q = false;
        boolean r = false;
        System.out.println("p || (q && r) = " + (p || (q && r)));
        System.out.println("(p || q) && r = " + ((p || q) && r));
        System.out.println("!p || q       = " + (!p || q));
        System.out.println("5 + 3 > 2 * 3 = " + (5 + 3 > 2 * 3));
        System.out.println();

        /*
        CUARTA PARTE - Bits y comparacion.
          & tiene menos precedencia que ==, pero en Java hay que parentizar
          porque el tipo boolean no se mezcla con el int.
        */
        System.out.println("--- CUARTA PARTE: & y == ---");
        System.out.println();

        int flags = 4;
        boolean encendido = (flags & 4) == 4;
        System.out.println("(flags & 4) == 4 -> " + encendido);
        System.out.println();

        /*
        QUINTA PARTE - El casteo llega cuando lo escribes.
          (double) (7 / 2)  parte de la division entera 3 y luego la convierte.
          (double) 7 / 2   convierte el 7 antes de dividir.
        */
        System.out.println("--- QUINTA PARTE: Casteo dentro de la expresion ---");
        System.out.println();

        System.out.println("7 / 2           = " + (7 / 2));
        System.out.println("7 / 2.0         = " + (7 / 2.0));
        System.out.println("7.0 / 2         = " + (7.0 / 2));
        System.out.println("(double) (7 / 2) = " + ((double) (7 / 2)));
        System.out.println("(double) 7 / 2   = " + ((double) 7 / 2));

        int fahrenheit = 98;
        int celsius = (fahrenheit - 32) * 5 / 9;
        int malCelsius = fahrenheit - 32 * 5 / 9;
        System.out.println("(98 - 32) * 5 / 9 = " + celsius);
        System.out.println("98 - 32 * 5 / 9   = " + malCelsius);

        int horasTotales = 47;
        int dias = horasTotales / 24;
        int horasSobrantes = horasTotales % 24;
        System.out.println(horasTotales + " horas = " + dias + " dia y " + horasSobrantes + " horas");
        System.out.println();
        System.out.println("¡FIN DEL PROGRAMA!");
        System.out.println();
    }
}
