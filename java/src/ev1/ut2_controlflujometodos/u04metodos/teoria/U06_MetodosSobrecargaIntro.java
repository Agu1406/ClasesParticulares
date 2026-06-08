package ev1.ut2_controlflujometodos.u04metodos.teoria;

/**
 * Teoria: sobrecarga de metodos (overload) en Java.
 *
 * <p><b>Objetivo:</b> definir varios metodos con el mismo nombre pero distintos parametros.</p>
 *
 * <p>Java distingue las versiones por la <b>firma</b>: numero y tipo de parametros.
 * El tipo de retorno por si solo no basta para sobrecargar.</p>
 *
 * <pre>{@code
 * public static int maximo(int a, int b) {
 *     return a >= b ? a : b;
 * }
 *
 * public static double maximo(double a, double b) {
 *     return a >= b ? a : b;
 * }
 *
 * // Java elige la version segun los argumentos:
 * maximo(3, 7);       // int
 * maximo(3.5, 2.1);   // double
 * }</pre>
 *
 * <p><b>Cuando usar sobrecarga:</b> la misma operacion con distintos tipos o cantidades de datos
 * ({@code imprimir}, {@code calcular}, {@code formatear}) sin inventar nombres distintos
 * ({@code maximoEntero}, {@code maximoDecimal}).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U06_MetodosSobrecargaIntro {

    public static int maximo(int a, int b) {
        return a >= b ? a : b;
    }

    public static double maximo(double a, double b) {
        return a >= b ? a : b;
    }

    public static int maximo(int a, int b, int c) {
        int mayor;
        mayor = maximo(a, b);
        return maximo(mayor, c);
    }

    public static void imprimir(String texto) {
        System.out.println("[INFO] " + texto);
    }

    public static void imprimir(String texto, int veces) {
        int contador;
        for (contador = 0; contador < veces; contador++) {
            System.out.println("[INFO] " + texto);
        }
    }

    public static void main(String[] args) {
        System.out.println("Max int: " + maximo(3, 7));
        System.out.println("Max double: " + maximo(3.5, 2.1));
        System.out.println("Max tres: " + maximo(3, 7, 5));
        imprimir("Hola");
        imprimir("Repetido", 3);
    }
}
