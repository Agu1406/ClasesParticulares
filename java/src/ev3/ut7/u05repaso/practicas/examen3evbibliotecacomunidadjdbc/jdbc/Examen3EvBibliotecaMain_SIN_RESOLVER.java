package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc;

import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.dao.AutorDAO_SIN_RESOLVER;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.dao.BibliotecaDAO_SIN_RESOLVER;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.dao.LibroDAO_SIN_RESOLVER;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model.Autor;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model.Biblioteca;

/**
 * Plantilla alumno JDBC: completar DAO, {@code CSVUtil} y el flujo del examen.
 */
public class Examen3EvBibliotecaMain_SIN_RESOLVER {

    public static void main(String[] args) {
        BibliotecaDAO_SIN_RESOLVER bibliotecaDao = new BibliotecaDAO_SIN_RESOLVER();
        AutorDAO_SIN_RESOLVER autorDao = new AutorDAO_SIN_RESOLVER();
        LibroDAO_SIN_RESOLVER libroDao = new LibroDAO_SIN_RESOLVER();

        // TODO 1: insertar 2 bibliotecas y 2 autores
        Biblioteca bibliotecaUno = null;
        Biblioteca bibliotecaDos = null;
        Autor autorUno = null;
        Autor autorDos = null;

        // TODO 2: DNI duplicado (error 1062)
        // TODO 3: insertar libros; ISBN duplicado
        // TODO 4: listar libros por biblioteca
        // TODO 5: listar autores
        // TODO 6: listar libros por autor + CSVUtil.exportarLibros(...)
    }
}
