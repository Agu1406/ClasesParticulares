package diagnostico.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Recorrido for-each de colecciones
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que recorra una lista y un mapa e imprima su contenido.</li>
 * <li>Completa imprimirColecciones(List<String> lista, Map<String, Integer> mapa).</li>
 * <li>Recorre la lista con indice y el mapa con Iterator (no uses i, j, k).</li>
 * <li>En el main, lee los datos de lista y mapa con Scanner teclado y llama al metodo.</li>
 * </ul>
 *
 * <p>Diagnostico 24 — EV2 · ut4_colecciones · RA6.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico24_ColeccionesForEach_RESUELTO {

    public static void imprimirColecciones(List<String> lista, Map<String, Integer> mapa) {
        int indice;
        String elemento;
        Iterator<Map.Entry<String, Integer>> iterador;
        Map.Entry<String, Integer> entrada;
        for (indice = 0; indice < lista.size(); indice++) {
            elemento = lista.get(indice);
            System.out.println("Lista: " + elemento);
        }
        iterador = mapa.entrySet().iterator();
        while (iterador.hasNext()) {
            entrada = iterador.next();
            System.out.println("Mapa: " + entrada.getKey() + "=" + entrada.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner teclado;
        List<String> lista;
        Map<String, Integer> mapa;
        String linea;
        String clave;
        int valor;
        teclado = new Scanner(System.in);
        System.out.println("Elementos de lista (vacia para terminar):");
        linea = teclado.nextLine();
        lista = new ArrayList<>();
        while (!linea.isEmpty()) {
            lista.add(linea);
            linea = teclado.nextLine();
        }
        System.out.println("Pares clave=valor del mapa (clave vacia para terminar):");
        mapa = new HashMap<>();
        clave = teclado.nextLine();
        while (!clave.isEmpty()) {
            System.out.print("Valor entero: ");
            valor = teclado.nextInt();
            teclado.nextLine();
            mapa.put(clave, valor);
            System.out.print("Clave: ");
            clave = teclado.nextLine();
        }
        imprimirColecciones(lista, mapa);
        teclado.close();
    }
}
