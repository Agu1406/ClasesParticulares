package ev3.ut9_programacionfuncional.pf.u02streams.teoria;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Teoria: reduce y collect (PDF diapos 26).
 *
 * <p><b>Que son operaciones terminales?</b> Cierran el pipeline y producen un resultado
 * concreto: un numero, un boolean, una List, un String...</p>
 *
 * <p><b>reduce:</b> combina todos los elementos en un solo valor acumulando (suma,
 * producto, max...). Recibe identidad inicial y funcion acumuladora
 * {@code (acumulador, elemento) -> ...}.</p>
 *
 * <p><b>collect:</b> materializa el stream en una estructura: {@code toList()},
 * {@code joining("-")}, {@code groupingBy}... Es la forma idiomatica de "guardar
 * resultados" sin mutar listas externas con forEach+add.</p>
 *
 * <p><b>Por que reduce/collect frente a un acumulador manual?</b> Expresas la agregacion
 * en una linea; menos variables mutables; alinea con RA6 (operaciones agregadas).</p>
 *
 * <p><b>Integer::sum</b> en reduce es equivalente a {@code (a,b) -> a + b}: referencia
 * a metodo como lambda.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_StreamsReduceIntro {

    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        int suma = numeros.stream().reduce(0, (acumulador, elemento) -> acumulador + elemento);
        System.out.println("Suma reduce: " + suma);

        int sumaParesX10 = numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 10)
                .reduce(0, Integer::sum);
        System.out.println("Suma pares*10: " + sumaParesX10);

        String unidos = numeros.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-"));
        System.out.println("joining: " + unidos);
    }
}
