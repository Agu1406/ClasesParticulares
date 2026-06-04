package ev3.ut9.pf.u02streams.teoria;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Teoria: busqueda y matching (PDF diapos 24-25).
 *
 * <p><b>Que son?</b> Operaciones terminales que preguntan algo sobre el stream sin
 * construir necesariamente una lista nueva:</p>
 * <ul>
 *   <li>{@code findFirst} / {@code findAny} - devuelven Optional con un elemento.</li>
 *   <li>{@code anyMatch} - existe al menos uno que cumple?</li>
 *   <li>{@code allMatch} - todos cumplen?</li>
 *   <li>{@code noneMatch} - ninguno cumple?</li>
 * </ul>
 *
 * <p><b>Por que usarlas?</b> Evitas recorrer manualmente con break/flags booleanos.
 * El stream expresa la pregunta directamente.</p>
 *
 * <p><b>Optional en findFirst:</b> puede no haber ningun match; Optional evita null
 * y obliga a pensar en el caso vacio (orElse, etc.).</p>
 *
 * <p><b>Short-circuit:</b> anyMatch/allMatch/noneMatch pueden parar antes de recorrer
 * todo si ya conocen la respuesta (ventaja sobre un for que a veces recorre de mas).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_StreamsBusquedaIntro {

    public static void main(String[] args) {
        Random rnd = new Random(0);
        List<Integer> muestra = Stream.generate(() -> rnd.nextInt(10))
                .limit(20)
                .collect(Collectors.toList());

        System.out.println("Muestra: " + muestra);

        Optional<Integer> primero = muestra.stream()
                .filter(numero -> numero > 5)
                .findFirst();
        System.out.println("findFirst > 5: " + primero);

        boolean alguno = muestra.stream().anyMatch(numero -> numero > 5);
        boolean todosNegativos = muestra.stream().allMatch(numero -> numero < 0);
        boolean ningunoNegativo = muestra.stream().noneMatch(numero -> numero < 0);

        System.out.println("anyMatch > 5: " + alguno);
        System.out.println("allMatch < 0: " + todosNegativos);
        System.out.println("noneMatch < 0: " + ningunoNegativo);
    }
}
