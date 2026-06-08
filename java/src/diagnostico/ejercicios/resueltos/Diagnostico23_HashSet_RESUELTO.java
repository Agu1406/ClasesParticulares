package diagnostico.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Eliminacion de duplicados con HashSet
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que elimine duplicados de una lista de enteros.</li>
 * <li>Completa el metodo sinDuplicados(List<Integer> numeros) usando HashSet.</li>
 * <li>En el main, lee enteros (uno por linea, linea vacia para terminar) con Scanner teclado.</li>
 * <li>Imprime el conjunto sin duplicados.</li>
 * </ul>
 *
 * <p>Diagnostico 23 — EV2 · ut4_colecciones · RA6.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico23_HashSet_RESUELTO {

    public static Set<Integer> sinDuplicados(List<Integer> numeros) {
        return new HashSet<>(numeros);
    }
    public static void main(String[] args) {
        Scanner teclado;
        List<Integer> numeros;
        String linea;
        Integer valor;
        Set<Integer> unicos;
        teclado = new Scanner(System.in);
        System.out.println("Enteros (linea vacia para terminar):");
        linea = teclado.nextLine();
        numeros = new ArrayList<>();
        while (!linea.isEmpty()) {
            valor = Integer.parseInt(linea);
            numeros.add(valor);
            linea = teclado.nextLine();
        }
        unicos = sinDuplicados(numeros);
        System.out.println("Sin duplicados: " + unicos);
        teclado.close();
    }
}
