package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate;

import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Libro;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Acceso Hibernate a la tabla {@code libros}.
 */
public class LibroDAO_RESUELTO {

    private final SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();

    /**
     * Inserta un libro con {@code persist} y confirma la transaccion.
     */
    public void insertar(Libro libro) {
        try (Session sesion = fabricaSesiones.openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.persist(libro);
            transaccion.commit();
        }
    }

    /**
     * @param identificadorBiblioteca clave foranea {@code id_biblioteca}
     */
    public List<Libro> listarPorBiblioteca(Integer identificadorBiblioteca) {
        try (Session sesion = fabricaSesiones.openSession()) {
            return sesion.createQuery(
                            "from Libro where biblioteca.id = :identificadorBiblioteca", Libro.class)
                    .setParameter("identificadorBiblioteca", identificadorBiblioteca)
                    .list();
        }
    }

    /**
     * @param identificadorAutor clave foranea {@code id_autor}
     */
    public List<Libro> listarPorAutor(Integer identificadorAutor) {
        try (Session sesion = fabricaSesiones.openSession()) {
            return sesion.createQuery(
                            "from Libro where autor.id = :identificadorAutor", Libro.class)
                    .setParameter("identificadorAutor", identificadorAutor)
                    .list();
        }
    }
}
