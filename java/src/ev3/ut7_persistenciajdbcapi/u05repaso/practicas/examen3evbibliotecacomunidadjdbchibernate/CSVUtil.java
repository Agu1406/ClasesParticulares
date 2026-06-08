package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate;

import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Libro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Exporta libros a CSV (separador {@code ;}), como pide el examen.
 */
public final class CSVUtil {

    private CSVUtil() {
    }

    /**
     * Genera un fichero con cabecera {@code isbn;paginas;tipo;anio} y una fila por libro.
     *
     * @param listaLibros libros a volcar (por ejemplo los de un autor)
     * @param nombreFichero ruta del CSV de salida
     */
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
