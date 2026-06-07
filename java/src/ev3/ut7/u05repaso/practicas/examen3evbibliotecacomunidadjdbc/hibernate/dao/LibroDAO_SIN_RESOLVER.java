package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.hibernate.dao;

import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.hibernate.model.Libro;

import java.util.List;

/**
 * Acceso Hibernate a la tabla {@code libros}.
 */
public class LibroDAO_SIN_RESOLVER {

    /**
     * Inserta un libro con {@code persist} y confirma la transaccion.
     */
    public void insertar(Libro libro) {
        // TODO
    }

    /**
     * @param identificadorBiblioteca clave foranea {@code id_biblioteca}
     */
    public List<Libro> listarPorBiblioteca(Integer identificadorBiblioteca) {
        // TODO
        return null;
    }

    /**
     * @param identificadorAutor clave foranea {@code id_autor}
     */
    public List<Libro> listarPorAutor(Integer identificadorAutor) {
        // TODO
        return null;
    }
}
