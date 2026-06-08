package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate;

import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.AutorDAO_RESUELTO;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.BibliotecaDAO_RESUELTO;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.LibroDAO_RESUELTO;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Autor;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Biblioteca;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Libro;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.CSVUtil;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.HibernateUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

/**
 * Solucion del examen 3.ª EV con Hibernate (model + util + dao).
 *
 * <p>Requisito: {@code biblioteca_ces.sql} en phpMyAdmin. Librerias: <b>MySQL</b> + <b>Hibernate</b>.</p>
 */
public class Examen3EvBibliotecaMain_RESUELTO {

    private static final int CODIGO_DUPLICADO_MYSQL = 1062;

    /**
     * Ejecuta el enunciado delegando en los DAO; CSV con {@link CSVUtil}.
     *
     * @param args no se usan
     */
    public static void main(String[] args) {
        BibliotecaDAO_RESUELTO bibliotecaDao = new BibliotecaDAO_RESUELTO();
        AutorDAO_RESUELTO autorDao = new AutorDAO_RESUELTO();
        LibroDAO_RESUELTO libroDao = new LibroDAO_RESUELTO();

        Biblioteca bibliotecaMadrid = new Biblioteca("Calle Mayor 12", "Madrid", "Madrid");
        Biblioteca bibliotecaBurgos = new Biblioteca("Av. Constitucion 45", "Burgos", "Burgos");
        Autor autorAna = new Autor("Ana", "Garcia", "12345678A");
        Autor autorCarlos = new Autor("Carlos", "Lopez", "87654321B");

        bibliotecaDao.insertar(bibliotecaMadrid);
        bibliotecaDao.insertar(bibliotecaBurgos);
        autorDao.insertar(autorAna);
        autorDao.insertar(autorCarlos);
        System.out.println("Bibliotecas: " + bibliotecaMadrid + " | " + bibliotecaBurgos);
        System.out.println("Autores: " + autorAna + ", " + autorCarlos);

        try {
            autorDao.insertar(new Autor("Pedro", "Ruiz", "12345678A"));
        } catch (RuntimeException errorPersistencia) {
            if (esViolacionDuplicado(errorPersistencia)) {
                System.out.println("Error controlado: DNI duplicado");
            } else {
                throw errorPersistencia;
            }
        }

        Autor autorAnaEnBaseDatos = autorDao.buscarPorId(autorAna.getId());
        if (autorAnaEnBaseDatos != null) {
            Libro libroEnMadrid = new Libro(
                    "978-84-376-0494-7", 320, "Novela", 2018,
                    autorAnaEnBaseDatos, bibliotecaMadrid);
            libroDao.insertar(libroEnMadrid);
            System.out.println("Libro en Madrid: " + libroEnMadrid);
        }

        Autor autorCarlosEnBaseDatos = autorDao.buscarPorId(autorCarlos.getId());
        if (autorCarlosEnBaseDatos != null) {
            Libro libroEnBurgos = new Libro(
                    "978-84-8181-227-5", 256, "Ensayo", 2020,
                    autorCarlosEnBaseDatos, bibliotecaBurgos);
            libroDao.insertar(libroEnBurgos);
            System.out.println("Libro en Burgos: " + libroEnBurgos);
        }

        try {
            libroDao.insertar(new Libro(
                    "978-84-376-0494-7", 100, "Poesia", 2022,
                    autorCarlos, bibliotecaBurgos));
        } catch (RuntimeException errorPersistencia) {
            if (esViolacionDuplicado(errorPersistencia)) {
                System.out.println("Error controlado: ISBN duplicado");
            } else {
                throw errorPersistencia;
            }
        }

        System.out.println("\nLibros biblioteca Madrid (id=" + bibliotecaMadrid.getId() + "):");
        List<Libro> librosDeMadrid = libroDao.listarPorBiblioteca(bibliotecaMadrid.getId());
        for (Libro libroActual : librosDeMadrid) {
            System.out.println("  " + libroActual);
        }

        System.out.println("\nTodos los autores:");
        for (Autor autorActual : autorDao.listarTodos()) {
            System.out.println("  " + autorActual);
        }

        List<Libro> librosDeAna = libroDao.listarPorAutor(autorAna.getId());
        String nombreFicheroCsv = Path.of(
                "src/ev3/ut7_persistenciajdbcapi/u05repaso/practicas/examen3evbibliotecacomunidadjdbchibernate/libros_ana_garcia.csv"
        ).toString();
        try {
            CSVUtil.exportarLibros(librosDeAna, nombreFicheroCsv);
            System.out.println("\nCSV: " + nombreFicheroCsv + " (" + librosDeAna.size() + " filas)");
        } catch (IOException errorEntradaSalida) {
            System.out.println("Error CSV: " + errorEntradaSalida.getMessage());
        }

        HibernateUtil.shutdown();
    }

    private static boolean esViolacionDuplicado(Throwable error) {
        Throwable causa = error;
        while (causa != null) {
            if (causa instanceof SQLException errorSql && errorSql.getErrorCode() == CODIGO_DUPLICADO_MYSQL) {
                return true;
            }
            String mensajeError = causa.getMessage();
            if (mensajeError != null && mensajeError.contains("Duplicate entry")) {
                return true;
            }
            causa = causa.getCause();
        }
        return false;
    }
}
