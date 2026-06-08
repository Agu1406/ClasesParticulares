package diagnostico.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Busqueda opcional con Optional
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que busque el primer nombre que empiece por un prefijo.</li>
 * <li>Completa buscarNombre(List<String> nombres, String prefijo) con stream, filter, findFirst y orElse.</li>
 * <li>Si no hay coincidencia, devuelve "No encontrado".</li>
 * <li>En el main, lee nombres y el prefijo con Scanner teclado e imprime el resultado.</li>
 * </ul>
 *
 * <p>Diagnostico 36 — EV3 · ut9_programacionfuncional/pf · RA7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico36_Optional_SIN_RESOLVER {

    public static String buscarNombre(List<String> nombres, String prefijo) {
        // TODO: stream filter startsWith, findFirst, orElse("No encontrado")
        return null;
    }
    public static void main(String[] args) {
        Scanner teclado;
        List<String> nombres;
        String linea;
        String prefijo;
        String encontrado;
        teclado = new Scanner(System.in);
        System.out.println("Nombres (vacia para terminar):");
        linea = teclado.nextLine();
        nombres = new ArrayList<>();
        while (!linea.isEmpty()) {
            nombres.add(linea);
            linea = teclado.nextLine();
        }
        System.out.print("Prefijo a buscar: ");
        prefijo = teclado.nextLine();
        // TODO: llamar a buscarNombre
        encontrado = buscarNombre(nombres, prefijo);
        System.out.println("Resultado: " + encontrado);
        teclado.close();
    }
}
