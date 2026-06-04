package ev3.ut9.pf.u02streams.teoria;

import java.util.List;

/**
 * Teoria: evaluacion perezosa (lazy) (PDF diapos 20).
 *
 * <p><b>Que es la pereza en streams?</b> Las operaciones intermedias (filter, map, peek)
 * no recorren datos al definirlas. Solo cuando llamas una operacion terminal (count,
 * collect, forEach...) Java ejecuta el pipeline completo.</p>
 *
 * <p><b>Por que existe?</b> Permite fusionar pasos y evitar trabajo innecesario: si
 * buscas el primer elemento que cumple condicion, no hace falta procesar el resto de
 * la lista (short-circuit).</p>
 *
 * <p><b>Frente al enfoque tradicional:</b> en un for, cada linea se ejecuta en el
 * momento en que la escribes. En un stream mal construido puedes pensar que ya corrio
 * filter cuando aun no ha pasado nada; hay que recordar: sin terminal, no hay recorrido.</p>
 *
 * <p><b>peek:</b> operacion intermedia de depuracion; observa elementos cuando el
 * stream realmente se ejecuta (al llegar la terminal).</p>
 *
 * <p><b>Demo:</b> construye filter+peek y solo al llamar count() aparecen mensajes peek.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_StreamsPerezaIntro {

    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Bob", "Carlos", "Diana");

        System.out.println("Cadena perezosa (sin terminal aun no ejecuta efectos):");
        var stream = nombres.stream()
                .peek(nombre -> System.out.println("  peek: " + nombre))
                .filter(nombre -> nombre.length() > 3);

        System.out.println("Llamando terminal count...");
        long total = stream.count();
        System.out.println("count = " + total);
    }
}
