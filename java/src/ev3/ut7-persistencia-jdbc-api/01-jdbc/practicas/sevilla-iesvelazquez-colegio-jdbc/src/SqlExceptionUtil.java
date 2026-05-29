package andalucia.sevilla.iesvelazquez.colegiojdbc.src;

import java.sql.SQLException;

/**
 * Imprime cadena de {@link java.sql.SQLException}: mensaje, SQLState y ErrorCode (util para depurar JDBC).
 *
 * @author Agustín. A. Marquez. Piña
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


