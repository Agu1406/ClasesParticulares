package ev3.ut9.pf.u04principios.teoria;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Teoria: monadas (PDF diapos 35).
 *
 * <p><b>Que es una monada (idea practica)?</b> Un patron para encadenar computaciones
 * cuando cada paso puede "fallar" o producir un contexto especial: valor opcional,
 * asincronia, error... Sin anidar if-null o callbacks infinitos.</p>
 *
 * <p><b>Operaciones tipicas:</b> "envolver" un valor, "map" transformarlo dentro del
 * contexto, "flatMap" encadenar otro paso que tambien devuelve el contexto.</p>
 *
 * <p><b>Ejemplos en Java:</b></p>
 * <ul>
 *   <li>{@link Optional} - valor que puede faltar.</li>
 *   <li>{@link CompletableFuture} - valor que llegara mas tarde (async).</li>
 * </ul>
 *
 * <p><b>Por que no memorizar la definicion formal?</b> En DAM basta entender el patron:
 * encadenar sin perder el manejo de ausencia/error. Optional.map y Future.thenApply
 * son la misma idea con distinto contexto.</p>
 *
 * <p><b>Demo:</b> Optional.map y CompletableFuture.supplyAsync + thenApply.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_MonadasIntro {

    public static void main(String[] args) {
        Optional<String> nombre = Optional.of("Ana");
        Optional<String> saludo = nombre.map(texto -> "Hola, " + texto);
        System.out.println("Optional map: " + saludo.orElse("?"));

        CompletableFuture<String> futuro = CompletableFuture
                .supplyAsync(() -> "datos")
                .thenApply(d -> d.toUpperCase());
        System.out.println("CompletableFuture: " + futuro.join());
    }
}
