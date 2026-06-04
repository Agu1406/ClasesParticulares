package com.biblioteca;

import com.biblioteca.dao.AutorDAO;
import com.biblioteca.dao.BibliotecaDAO;
import com.biblioteca.dao.LibroDAO;
import com.biblioteca.db.DatabaseManager;
import com.biblioteca.model.Autor;
import com.biblioteca.model.Biblioteca;
import com.biblioteca.model.Libro;
import com.biblioteca.util.CsvExporter;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {

    private final AutorDAO autorDAO = new AutorDAO();
    private final BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
    private final LibroDAO libroDAO = new LibroDAO();

    public static void main(String[] args) {
        try {
            new Main().ejecutar();
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void ejecutar() throws Exception {
        DatabaseManager.initSchema();

        System.out.println("=== Alta manual de bibliotecas ===");
        Biblioteca bibliotecaCentro = bibliotecaDAO.insertar(
                "Calle Mayor 12", "Madrid", "Madrid");
        Biblioteca bibliotecaNorte = bibliotecaDAO.insertar(
                "Av. de la Constitucion 45", "Burgos", "Burgos");
        Biblioteca bibliotecaSur = bibliotecaDAO.insertar(
                "Plaza de Espana 3", "Sevilla", "Sevilla");
        System.out.println("Bibliotecas registradas: " + bibliotecaDAO.listarTodas().size());

        System.out.println("\n=== Alta de autores (con control de DNI duplicado) ===");
        Autor garcia = crearAutor("Ana", "Garcia", "12345678A");
        Autor lopez = crearAutor("Carlos", "Lopez", "87654321B");
        intentarCrearAutorDuplicado("Pedro", "Ruiz", "12345678A");

        System.out.println("\n=== Insercion de libros (buscando autor y controlando ISBN duplicado) ===");
        insertarLibro("978-84-376-0494-7", garcia, bibliotecaCentro, 320, "Novela", 2018);
        insertarLibro("978-84-8181-227-5", lopez, bibliotecaNorte, 256, "Ensayo", 2020);
        insertarLibro("978-84-339-2879-8", garcia, bibliotecaSur, 410, "Novela", 2015);
        intentarInsertarLibroDuplicado("978-84-376-0494-7", lopez, bibliotecaNorte, 100, "Poesia", 2022);

        System.out.println("\n=== Libros de la biblioteca de Madrid ===");
        listarLibrosBiblioteca(bibliotecaCentro.id());

        System.out.println("\n=== Todos los autores ===");
        listarAutores();

        System.out.println("\n=== Exportacion CSV de libros de Ana Garcia ===");
        exportarLibrosAutor(garcia.id(), "libros_ana_garcia.csv");
    }

    private Autor crearAutor(String nombre, String apellido, String dni) throws SQLException {
        try {
            Autor autor = autorDAO.insertar(nombre, apellido, dni);
            System.out.println("Autor creado: " + autor.nombreCompleto() + " (DNI " + autor.dni() + ")");
            return autor;
        } catch (SQLException e) {
            return manejarViolacionUnica(e, "DNI", () -> {
                throw new SQLException("No se pudo crear el autor con DNI " + dni, e);
            });
        }
    }

    private void intentarCrearAutorDuplicado(String nombre, String apellido, String dni) {
        System.out.println("Intentando autor con DNI duplicado (" + dni + ")...");
        try {
            autorDAO.insertar(nombre, apellido, dni);
            System.out.println("Autor creado (no esperado).");
        } catch (SQLException e) {
            if (esViolacionUnica(e)) {
                System.out.println("Error gestionado: ya existe un autor con ese DNI.");
            } else {
                System.err.println("Error SQL: " + e.getMessage());
            }
        }
    }

    private void insertarLibro(
            String isbn,
            Autor autor,
            Biblioteca biblioteca,
            int paginas,
            String tipo,
            int anio
    ) throws SQLException {
        Optional<Autor> autorEncontrado = autorDAO.buscarPorId(autor.id());
        if (autorEncontrado.isEmpty()) {
            System.out.println("No se encontro el autor con id " + autor.id() + ". Libro no insertado.");
            return;
        }

        try {
            Libro libro = libroDAO.insertar(isbn, paginas, tipo, anio, autor.id(), biblioteca.id());
            System.out.println("Libro insertado en " + biblioteca + ": " + libro);
        } catch (SQLException e) {
            manejarViolacionUnica(e, "ISBN", () -> {
                System.out.println("Error gestionado al insertar ISBN " + isbn + ": ISBN duplicado.");
            });
        }
    }

    private void intentarInsertarLibroDuplicado(
            String isbn,
            Autor autor,
            Biblioteca biblioteca,
            int paginas,
            String tipo,
            int anio
    ) {
        System.out.println("Intentando libro con ISBN duplicado (" + isbn + ")...");
        try {
            libroDAO.insertar(isbn, paginas, tipo, anio, autor.id(), biblioteca.id());
            System.out.println("Libro insertado (no esperado).");
        } catch (SQLException e) {
            if (esViolacionUnica(e)) {
                System.out.println("Error gestionado: ya existe un libro con ese ISBN.");
            } else {
                System.err.println("Error SQL: " + e.getMessage());
            }
        }
    }

    private void listarLibrosBiblioteca(long bibliotecaId) throws SQLException {
        Optional<Biblioteca> biblioteca = bibliotecaDAO.buscarPorId(bibliotecaId);
        biblioteca.ifPresentOrElse(
                b -> System.out.println("Biblioteca: " + b),
                () -> System.out.println("Biblioteca no encontrada (id=" + bibliotecaId + ")")
        );

        List<Libro> libros = libroDAO.listarPorBiblioteca(bibliotecaId);
        if (libros.isEmpty()) {
            System.out.println("No hay libros en esta biblioteca.");
            return;
        }
        libros.forEach(libro -> System.out.println("  - " + libro));
    }

    private void listarAutores() throws SQLException {
        List<Autor> autores = autorDAO.listarTodos();
        autores.forEach(autor ->
                System.out.println("  - " + autor.nombreCompleto() + " | DNI: " + autor.dni())
        );
    }

    private void exportarLibrosAutor(long autorId, String nombreArchivo) throws Exception {
        Optional<Autor> autor = autorDAO.buscarPorId(autorId);
        if (autor.isEmpty()) {
            System.out.println("Autor no encontrado para exportar.");
            return;
        }

        List<Libro> libros = libroDAO.listarPorAutor(autorId);
        Path archivo = CsvExporter.exportarLibrosAutor(libros, nombreArchivo);
        System.out.println("Exportados " + libros.size() + " libro(s) de " + autor.get().nombreCompleto());
        System.out.println("Archivo: " + archivo);
        libros.forEach(libro -> System.out.println("  - " + libro.isbn() + " (" + libro.tipo() + ")"));
    }

    private boolean esViolacionUnica(SQLException e) {
        SQLException actual = e;
        while (actual != null) {
            if (actual.getErrorCode() == 23505) {
                return true;
            }
            String mensaje = actual.getMessage();
            if (mensaje != null && mensaje.toUpperCase().contains("UNIQUE")) {
                return true;
            }
            actual = actual.getNextException();
        }
        return false;
    }

    private <T> T manejarViolacionUnica(SQLException e, String campo, SqlRunnable accion) throws SQLException {
        if (esViolacionUnica(e)) {
            accion.run();
            return null;
        }
        throw e;
    }

    @FunctionalInterface
    private interface SqlRunnable {
        void run() throws SQLException;
    }
}
