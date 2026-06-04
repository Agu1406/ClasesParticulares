package ev3.ut7.u01jdbc.practicas.sevillaiesvelazquezcolegiojdbc.colegio;

import java.sql.SQLException;

/**
 * Utilidad para diagnosticar fallos JDBC.
 *
 * <p><b>Objetivo:</b> mostrar de forma legible la cadena de {@link SQLException} (mensaje,
 * SQLState y codigo de error) cuando falle la conexion o una sentencia SQL.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public final class SqlExceptionUtil {
    private SqlExceptionUtil() {}

    public static void printSQLException(SQLException e) {
        SQLException ex = e;
        while (ex != null) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("  SQLState: " + ex.getSQLState());
            System.err.println("  ErrorCode: " + ex.getErrorCode());
            ex = ex.getNextException();
        }
    }
}


