package diagnostico.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interfaces exportables CSV
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con la interfaz Exportable y metodo toCsv().</li>
 * <li>Implementa la interfaz en las clases Libro y Autor.</li>
 * <li>En el main, lee titulo del libro y nombre del autor con Scanner teclado.</li>
 * <li>Crea los objetos, guardalos en un array de Exportable e imprime cada linea CSV.</li>
 * </ul>
 *
 * <p>Diagnostico 32 — EV3 · ut6_pooavanzadaestructuras · RA7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico32_Interfaces_SIN_RESOLVER {

    // TODO: interface Exportable con toCsv(); Libro y Autor que lo implementen

    interface Exportable {
        // TODO
    }

    static class Libro implements Exportable {
        // TODO
    }

    static class Autor implements Exportable {
        // TODO
    }
    public static void main(String[] args) {
        Scanner teclado;
        String tituloLibro;
        String nombreAutor;
        List<Exportable> items;
        Exportable item;
        teclado = new Scanner(System.in);
        System.out.print("Titulo del libro: ");
        tituloLibro = teclado.nextLine();
        System.out.print("Nombre del autor: ");
        nombreAutor = teclado.nextLine();
        // TODO: crear items y exportar CSV
        items = new ArrayList<>();
        items.add(new Libro(tituloLibro));
        items.add(new Autor(nombreAutor));
        for (Exportable elemento : items) {
            System.out.println(elemento.toCsv());
        }
        teclado.close();
    }
}
