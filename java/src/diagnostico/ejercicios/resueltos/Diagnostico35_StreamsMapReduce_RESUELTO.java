package diagnostico.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Map-reduce con streams sobre numeros
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que sume los cuadrados de los numeros pares de una lista.</li>
 * <li>Completa sumaCuadradosPares(List<Integer> numeros) con filter, map y reduce.</li>
 * <li>En el main, lee enteros (linea vacia para terminar) con Scanner teclado e imprime la suma.</li>
 * </ul>
 *
 * <p>Diagnostico 35 — EV3 · ut9_programacionfuncional/pf · RA7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico35_StreamsMapReduce_RESUELTO {

    public static int sumaCuadradosPares(List<Integer> numeros) {
        return numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * numero)
                .reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        Scanner teclado;
        List<Integer> numeros;
        String linea;
        Integer valor;
        int resultado;
        teclado = new Scanner(System.in);
        System.out.println("Enteros (vacia para terminar):");
        linea = teclado.nextLine();
        numeros = new ArrayList<>();
        while (!linea.isEmpty()) {
            valor = Integer.parseInt(linea);
            numeros.add(valor);
            linea = teclado.nextLine();
        }
        resultado = sumaCuadradosPares(numeros);
        System.out.println("Suma cuadrados pares: " + resultado);
        teclado.close();
    }
}
