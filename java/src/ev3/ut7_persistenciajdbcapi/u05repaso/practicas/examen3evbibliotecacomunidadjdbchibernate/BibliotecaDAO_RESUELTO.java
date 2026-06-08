package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate;

import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.Biblioteca;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbchibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Acceso Hibernate a la tabla {@code bibliotecas}.
 */
public class BibliotecaDAO_RESUELTO {

    private final SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();

    /**
     * Inserta una biblioteca con {@code persist} y confirma la transaccion.
     */
    public void insertar(Biblioteca biblioteca) {
        try (Session sesion = fabricaSesiones.openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.persist(biblioteca);
            transaccion.commit();
        }
    }
}
