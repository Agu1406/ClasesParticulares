package ev3.ut7.u01jdbc.teoria;

import ev3.ut7.u01jdbc.teoria.U01_JdbcTeoriaConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Sesion 5 - Transacciones ({@code setAutoCommit}, commit/rollback) y {@link java.sql.SQLException} (RA9).
 * <p>
 * Ejemplo: transferir stock entre dos libros como operacion atomica. Si falla, rollback deshace todo.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_SandBox {

    public static void main(String[] args) {
        System.out.println("=== SESION 5: TRANSACCIONES ===\n");

        transferirStock(1, 2, 2);
        System.out.println();
        transferirStockConError(1, 2, 9999);
    }

    /**
     * Resta stock del libro origen y suma al destino en una sola transaccion.
     */
    private static void transferirStock(int idOrigen, int idDestino, int cantidad) {
        System.out.println("1) TRANSFERENCIA OK: " + cantidad + " unidades de id " + idOrigen + " -> " + idDestino);

        String sqlRestar = "UPDATE libros SET stock = stock - ? WHERE id = ? AND stock >= ?";
        String sqlSumar = "UPDATE libros SET stock = stock + ? WHERE id = ?";

        try (Connection cn = U01_JdbcTeoriaConnection.getConnection()) {
            boolean autoCommitAnterior = cn.getAutoCommit();
            cn.setAutoCommit(false);

            try (PreparedStatement restar = cn.prepareStatement(sqlRestar);
                 PreparedStatement sumar = cn.prepareStatement(sqlSumar)) {

                restar.setInt(1, cantidad);
                restar.setInt(2, idOrigen);
                restar.setInt(3, cantidad);
                int filasRestadas = restar.executeUpdate();

                if (filasRestadas == 0) {
                    throw new SQLException("Stock insuficiente en libro origen");
                }

                sumar.setInt(1, cantidad);
                sumar.setInt(2, idDestino);
                sumar.executeUpdate();

                cn.commit();
                System.out.println("  Transaccion confirmada (commit).");
            } catch (SQLException e) {
                cn.rollback();
                System.out.println("  Transaccion revertida (rollback): " + e.getMessage());
            } finally {
                cn.setAutoCommit(autoCommitAnterior);
            }
        } catch (SQLException e) {
            imprimirError(e);
        }
    }

    private static void transferirStockConError(int idOrigen, int idDestino, int cantidad) {
        System.out.println("2) TRANSFERENCIA FALLIDA (stock imposible): " + cantidad + " unidades");
        transferirStock(idOrigen, idDestino, cantidad);
        System.out.println("  (Los datos no deben haber cambiado por el rollback)");
    }

    private static void imprimirError(SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
        System.err.println("SQLState: " + e.getSQLState() + " | ErrorCode: " + e.getErrorCode());

        SQLException causa = e.getNextException();
        while (causa != null) {
            System.err.println("  Causa encadenada: " + causa.getMessage());
            causa = causa.getNextException();
        }
    }
}
