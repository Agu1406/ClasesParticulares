package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate;

import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.AutorDAO_SIN_RESOLVER;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.BibliotecaDAO_SIN_RESOLVER;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.LibroDAO_SIN_RESOLVER;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Autor;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Biblioteca;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.HibernateUtil;

/**
 * Plantilla alumno: completar DAO, {@code CSVUtil} y el flujo del examen.
 */
public class Examen3EvBibliotecaMain_SIN_RESOLVER {

    public static void main(String[] args) {
        BibliotecaDAO_SIN_RESOLVER bibliotecaDao = new BibliotecaDAO_SIN_RESOLVER();
        AutorDAO_SIN_RESOLVER autorDao = new AutorDAO_SIN_RESOLVER();
        LibroDAO_SIN_RESOLVER libroDao = new LibroDAO_SIN_RESOLVER();

        // TODO 1: insertar 2 bibliotecas y 2 autores con los DAO
        Biblioteca bibliotecaUno = null;
        Biblioteca bibliotecaDos = null;
        Autor autorUno = null;
        Autor autorDos = null;

        // TODO 2: insertar autor con DNI duplicado y capturar el error
        // TODO 3: buscar autores por id, insertar libros; capturar ISBN duplicado
        // TODO 4: listar libros por biblioteca
        // TODO 5: listar todos los autores
        // TODO 6: listar libros por autor y exportar CSV con CSVUtil.exportarLibros(...)

        HibernateUtil.shutdown();
    }
}
