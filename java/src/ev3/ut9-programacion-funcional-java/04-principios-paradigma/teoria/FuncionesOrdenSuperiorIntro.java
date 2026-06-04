package ev3.ut9.pf.principios;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Teoria: funciones de orden superior (PDF diapos 33-34).
 *
 * <p><b>Que es una funcion de orden superior (HOF)?</b> Una funcion que recibe otra
 * funcion como parametro, o que devuelve una funcion como resultado.</p>
 *
 * <p><b>Que es "funcion de primera clase"?</b> Las funciones se tratan como valores:
 * las guardas en variables, las pasas a metodos, las devuelves. En Java esto llego
 * de forma explicita con lambda e interfaces funcionales.</p>
 *
 * <p><b>Por que se usa?</b> Parametrizas comportamiento: un mismo metodo
 * {@code checkNumberFor} puede probar "mayor que 3", "par", etc. cambiando solo el
 * Predicate que le pasas.</p>
 *
 * <p><b>Ventaja frente a copiar-pegar ifs:</b> menos duplicacion; reglas reutilizables;
 * codigo alineado con streams (filter recibe Predicate).</p>
 *
 * <p><b>Demo:</b> HOF con Predicate + funciones que devuelven funciones (curry manual).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class FuncionesOrdenSuperiorIntro {

    public static boolean checkNumberFor(double valor, Predicate<Double> pred) {
        return pred.test(valor);
    }

    public static void main(String[] args) {
        System.out.println("checkNumberFor(3.5, n>3): "
                + checkNumberFor(3.5, valor -> valor > 3.0));

        Function<Integer, Function<Integer, Integer>> sumarN = incremento -> valor -> valor + incremento;
        Function<Integer, Integer> sumarUno = sumarN.apply(1);

        Function<String, Integer> textoAEntero = Integer::parseInt;
        Function<Integer, Integer> incrementarUno = numero -> numero + 1;

        System.out.println("textoAEntero: " + textoAEntero.apply("3"));
        System.out.println("sumarUno: " + sumarUno.apply(6));
        System.out.println("incrementarUno: " + incrementarUno.apply(6));
    }
}
