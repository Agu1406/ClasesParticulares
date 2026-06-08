package diagnostico.ejercicios.resueltos;

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
public class Diagnostico32_Interfaces_RESUELTO {

    interface Exportable {
        String toCsv();
    }

    static class Libro implements Exportable {
        private final String titulo;

        public Libro(String titulo) {
            this.titulo = titulo;
        }

        @Override
        public String toCsv() {
            return "LIBRO;" + titulo;
        }
    }

    static class Autor implements Exportable {
        private final String nombre;

        public Autor(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toCsv() {
            return "AUTOR;" + nombre;
        }
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
        items = new ArrayList<>();
        items.add(new Libro(tituloLibro));
        items.add(new Autor(nombreAutor));
        for (Exportable elemento : items) {
            System.out.println(elemento.toCsv());
        }
        teclado.close();
    }
}
