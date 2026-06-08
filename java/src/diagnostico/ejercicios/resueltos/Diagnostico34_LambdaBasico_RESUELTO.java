package diagnostico.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Filtrado con lambdas y streams
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que filtre nombres largos y los ordene alfabeticamente.</li>
 * <li>Completa filtrarLargos(List<String> nombres, int min) usando stream, filter, sorted y collect.</li>
 * <li>En el main, lee nombres y la longitud minima con Scanner teclado. Imprime la lista filtrada.</li>
 * </ul>
 *
 * <p>Diagnostico 34 — EV3 · ut9_programacionfuncional/pf · RA7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico34_LambdaBasico_RESUELTO {

    public static List<String> filtrarLargos(List<String> nombres, int minimo) {
        return nombres.stream()
                .filter(nombre -> nombre.length() > minimo)
                .sorted()
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        Scanner teclado;
        List<String> nombres;
        String linea;
        int minimo;
        List<String> filtrados;
        teclado = new Scanner(System.in);
        System.out.println("Nombres (vacia para terminar):");
        linea = teclado.nextLine();
        nombres = new ArrayList<>();
        while (!linea.isEmpty()) {
            nombres.add(linea);
            linea = teclado.nextLine();
        }
        System.out.print("Longitud minima: ");
        minimo = teclado.nextInt();
        filtrados = filtrarLargos(nombres, minimo);
        System.out.println("Filtrados: " + filtrados);
        teclado.close();
    }
}
