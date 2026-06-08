package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate;

import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Autor;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Acceso Hibernate a la tabla {@code autores}.
 */
public class AutorDAO_RESUELTO {

    private final SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();

    /**
     * Inserta un autor con {@code persist} y confirma la transaccion.
     */
    public void insertar(Autor autor) {
        try (Session sesion = fabricaSesiones.openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.persist(autor);
            transaccion.commit();
        }
    }

    /**
     * @param identificador clave primaria
     * @return autor gestionado o {@code null} si no existe
     */
    public Autor buscarPorId(Integer identificador) {
        try (Session sesion = fabricaSesiones.openSession()) {
            return sesion.get(Autor.class, identificador);
        }
    }

    /**
     * @return todos los autores ordenados por id
     */
    public List<Autor> listarTodos() {
        try (Session sesion = fabricaSesiones.openSession()) {
            return sesion.createQuery("from Autor order by id", Autor.class).list();
        }
    }
}
