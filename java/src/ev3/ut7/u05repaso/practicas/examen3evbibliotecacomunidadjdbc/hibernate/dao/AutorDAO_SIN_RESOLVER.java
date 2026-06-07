package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.hibernate.dao;

import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.hibernate.model.Autor;

import java.util.List;

/**
 * Acceso Hibernate a la tabla {@code autores}.
 */
public class AutorDAO_SIN_RESOLVER {

    /**
     * Inserta un autor con {@code persist} y confirma la transaccion.
     */
    public void insertar(Autor autor) {
        // TODO
    }

    /**
     * @param identificador clave primaria
     * @return autor gestionado o {@code null} si no existe
     */
    public Autor buscarPorId(Integer identificador) {
        // TODO
        return null;
    }

    /**
     * @return todos los autores ordenados por id
     */
    public List<Autor> listarTodos() {
        // TODO
        return null;
    }
}
