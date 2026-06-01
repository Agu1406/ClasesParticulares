package andalucia.sevilla.iesvelazquez.colegiojdbc.src;

import java.sql.SQLException;
import java.util.List;

/**
 * Demostración integrada del acceso a datos del colegio.
 *
 * <p><b>Objetivo de la práctica:</b> gestionar alumnos en MySQL desde Java aplicando JDBC
 * de extremo a extremo (conexión, DDL, CRUD y transacciones).</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Insertar alumnos y recuperar el identificador generado por la base de datos.</li>
 *   <li>Consultar un registro por id y listar todos los alumnos.</li>
 *   <li>Actualizar datos y eliminar registros de forma controlada.</li>
 *   <li>Demostrar una operación transaccional (varios inserts con commit o rollback).</li>
 * </ul>
 *
 * <p>Utiliza {@link AlumnosDAO}, {@link ColegioConnection}, {@link Alumno} y MySQL Connector/J.
 * Requiere haber ejecutado antes {@link ColegioSetup}.</p>
 *
 * @see AlumnosDAO
 * @see ColegioConnection
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ColegioDemo {
    public static void main(String[] args) throws Exception {
        AlumnosDAO dao = new AlumnosDAO();

        // Inserción simple
        Alumno a = new Alumno(null, "Ana Pérez", "ana.perez@example.com", "600000001");
        int idGenerado = dao.insertar(a);
        System.out.println("Insertado alumno con id = " + idGenerado);

        // Obtener por ID
        Alumno obtenido = dao.obtenerPorId(idGenerado);
        System.out.println("Obtenido: " + obtenido);

        // Listado
        List<Alumno> todos = dao.listarTodos();
        System.out.println("Listado total: " + todos);

        // Actualización
        obtenido.setTelefono("600000999");
        boolean actualizado = dao.actualizar(obtenido);
        System.out.println("Actualizado? " + actualizado);

        // Ejemplo transaccional (intenta insertar dos a la vez)
        Alumno t1 = new Alumno(null, "Trans A", "trans.a@example.com", "611111111");
        Alumno t2 = new Alumno(null, "Trans B", "trans.b@example.com", "622222222");
        try {
            dao.insertarDosAlumnosEnTransaccion(t1, t2);
            System.out.println("Transacción OK: ids " + t1.getIdAlumno() + ", " + t2.getIdAlumno());
        } catch (SQLException ex) {
            SqlExceptionUtil.printSQLException(ex);
        }

        // Eliminación (para no dejar datos de prueba)
        boolean eliminado = dao.eliminar(idGenerado);
        System.out.println("Eliminado? " + eliminado);

        // (Demostración de filtros/paginación eliminada para ceñirnos al PDF)
    }
}


