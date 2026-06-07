package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc;

import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.dao.AutorDAO_RESUELTO;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.dao.BibliotecaDAO_RESUELTO;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.dao.LibroDAO_RESUELTO;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model.Autor;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model.Biblioteca;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model.Libro;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.util.CSVUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Solucion del examen 3.ª EV con JDBC (model + util + dao).
 *
 * <p>Requisito: {@code ../sql/biblioteca_ces.sql} en phpMyAdmin. Libreria: <b>MySQL</b>.</p>
 */
public class Examen3EvBibliotecaMain_RESUELTO {

    private static final int CODIGO_DUPLICADO_MYSQL = 1062;

    public static void main(String[] args) {
        BibliotecaDAO_RESUELTO bibliotecaDao = new BibliotecaDAO_RESUELTO();
        AutorDAO_RESUELTO autorDao = new AutorDAO_RESUELTO();
        LibroDAO_RESUELTO libroDao = new LibroDAO_RESUELTO();

        try {
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
            } catch (SQLException errorSql) {
                if (esViolacionDuplicado(errorSql)) {
                    System.out.println("Error controlado: DNI duplicado");
                } else {
                    throw errorSql;
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
            } catch (SQLException errorSql) {
                if (esViolacionDuplicado(errorSql)) {
                    System.out.println("Error controlado: ISBN duplicado");
                } else {
                    throw errorSql;
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
            String nombreFicheroCsv = "libros_ana_garcia.csv";
            CSVUtil.exportarLibros(librosDeAna, nombreFicheroCsv);
            System.out.println("\nCSV: " + nombreFicheroCsv + " (" + librosDeAna.size() + " filas)");

        } catch (SQLException | IOException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    private static boolean esViolacionDuplicado(SQLException errorSql) {
        if (errorSql.getErrorCode() == CODIGO_DUPLICADO_MYSQL) {
            return true;
        }
        String mensaje = errorSql.getMessage();
        return mensaje != null && mensaje.contains("Duplicate entry");
    }
}
