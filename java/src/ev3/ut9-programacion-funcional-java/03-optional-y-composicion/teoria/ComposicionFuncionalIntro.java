package ev3.ut9.pf.optional;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Teoria: composicion funcional (PDF diapos 13-14).
 *
 * <p><b>Que es composicion?</b> Unir funciones, comparadores o predicados pequenos en
 * reglas mas grandes sin reescribir la logica entera cada vez.</p>
 *
 * <p><b>Function:</b> {@code andThen} aplica f despues de g ({@code f(g(x))});
 * {@code compose} aplica g antes de f. Orden distinto: conviene nombrarlos en voz alta.</p>
 *
 * <p><b>Comparator:</b> {@code comparing} elige clave; {@code thenComparing} desempata;
 * {@code reversed} invierte orden. Sustituye comparadores manuales largos en sort.</p>
 *
 * <p><b>Predicate:</b> {@code and}, {@code or}, {@code negate} combinan condiciones
 * reutilizables (ej. "blanco" y "barato").</p>
 *
 * <p><b>Por que mejor que un if gigante?</b> Cada pieza tiene nombre; se testea por
 * separado; el codigo declara la regla de negocio de forma legible.</p>
 *
 * <p><b>Demo:</b> funciones encadenadas, ordenacion de coches, predicado compuesto.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class ComposicionFuncionalIntro {

    static final class Coche {
        private final String color;
        private final double precio;
        private final int hp;

        Coche(String color, double precio, int hp) {
            this.color = color;
            this.precio = precio;
            this.hp = hp;
        }

        String color() {
            return color;
        }

        double precio() {
            return precio;
        }

        int hp() {
            return hp;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> incrementar = valor -> valor + 1;
        Function<Integer, Integer> duplicar = valor -> valor * 2;
        Function<Integer, Integer> incrementarDespuesDuplicar = incrementar.andThen(duplicar);
        Function<Integer, Integer> duplicarDespuesIncrementar = incrementar.compose(duplicar);

        System.out.println("andThen duplicar(incrementar(1)): " + incrementarDespuesDuplicar.apply(1));
        System.out.println("compose incrementar(duplicar(1)): " + duplicarDespuesIncrementar.apply(1));

        Coche cocheBlancoBarato = new Coche("white", 15000, 90);
        Coche cocheNegroCaro = new Coche("black", 25000, 120);
        Coche cocheBlancoMedio = new Coche("white", 18000, 100);

        Comparator<Coche> porPrecioYHp = Comparator
                .comparing(Coche::precio)
                .reversed()
                .thenComparing(Coche::hp);

        java.util.List<Coche> coches = java.util.Arrays.asList(cocheBlancoBarato, cocheNegroCaro, cocheBlancoMedio);
        java.util.List<Coche> ordenados = new java.util.ArrayList<>(coches);
        ordenados.sort(porPrecioYHp);
        System.out.println("Orden coche: " + ordenados);

        Predicate<Coche> esBlanco = coche -> "white".equals(coche.color());
        Predicate<Coche> noBlancoBarato = esBlanco.negate().and(coche -> coche.precio() < 20000);

        System.out.println("cocheBlancoBarato cumple noBlancoBarato: " + noBlancoBarato.test(cocheBlancoBarato));
        System.out.println("cocheNegroCaro cumple noBlancoBarato: " + noBlancoBarato.test(cocheNegroCaro));
    }
}
