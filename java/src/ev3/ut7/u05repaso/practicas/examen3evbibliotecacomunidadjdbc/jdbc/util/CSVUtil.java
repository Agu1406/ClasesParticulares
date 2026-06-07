package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.util;

import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model.Libro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Exporta libros a CSV (separador {@code ;}).
 */
public final class CSVUtil {

    private CSVUtil() {
    }

    public static void exportarLibros(List<Libro> listaLibros, String nombreFichero) throws IOException {
        try (PrintWriter escritorCsv = new PrintWriter(new FileWriter(nombreFichero))) {
            escritorCsv.println("isbn;paginas;tipo;anio");
            for (Libro libroActual : listaLibros) {
                escritorCsv.println(libroActual.getIsbn() + ";"
                        + libroActual.getNumPaginas() + ";"
                        + libroActual.getTipo() + ";"
                        + libroActual.getAnioPublicacion());
            }
        }
    }
}
