package ev3.ut9.pf.principios;

import java.util.function.Function;

/**
 * Teoria: currying (PDF diapos 36).
 *
 * <p><b>Que es currying?</b> Transformar una funcion de varios argumentos f(a,b) en
 * una cadena de funciones de un argumento: f(a) devuelve una funcion que recibe b.
 * En notacion: f(A,B) -> C se escribe f(A) -> (B -> C).</p>
 *
 * <p><b>Por que se usa en lenguajes funcionales?</b> Todas las funciones tienen un
 * solo parametro; facilita composicion y reutilizacion parcial (fijar a y obtener
 * una funcion que solo falta b).</p>
 *
 * <p><b>En Java:</b> no hay currying nativo; se simula con {@code Function} anidadas
 * o metodos que devuelven funciones ({@code sumarN}).</p>
 *
 * <p><b>Ventaja pedagogica:</b> conecta con HOF y con patrones como "sumarUno =
 * sumarN.apply(1)".</p>
 *
 * <p><b>Limitacion:</b> sintaxis mas verbosa que Haskell; usar solo cuando aporta
 * claridad, no por moda.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class CurrificacionIntro {

    public static int suma(int sumandoA, int sumandoB) {
        return sumandoA + sumandoB;
    }

    public static Function<Integer, Function<Integer, Integer>> sumaCurry() {
        return sumandoA -> sumandoB -> sumandoA + sumandoB;
    }

    public static void main(String[] args) {
        System.out.println("suma(2,3): " + suma(2, 3));

        Function<Integer, Integer> suma2 = sumaCurry().apply(2);
        System.out.println("sumaCurry apply 2 then 3: " + suma2.apply(3));

        Function<Integer, Function<Integer, Integer>> sumarN = incremento -> valor -> valor + incremento;
        Function<Integer, Integer> sumarUno = sumarN.apply(1);
        System.out.println("sumarUno(5): " + sumarUno.apply(5));
    }
}
