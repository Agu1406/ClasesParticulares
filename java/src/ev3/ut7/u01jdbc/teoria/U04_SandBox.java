package ev3.ut7.u01jdbc.teoria;

import ev3.ut7.u01jdbc.teoria.U01_JdbcTeoriaConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Sesion 3 - {@link java.sql.Statement} y recorrido de {@link java.sql.ResultSet} (RA9 CE d).
 * <p>
 * Tabla demo: {@code libros} en BD {@code JdbcTeoria}. Patron: {@code executeQuery} + {@code while(rs.next())}.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_SandBox {

    public static void main(String[] args) {
        System.out.println("=== SESION 3: STATEMENT + SELECT ===\n");

        listarTodos();
        System.out.println();
        contarLibros();
        System.out.println();
        selectConCondicion();
    }

    private static void listarTodos() {
        System.out.println("1) LISTAR TODOS LOS LIBROS");
        String sql = "SELECT id, titulo, autor, precio, stock FROM libros ORDER BY id";

        try (Connection cn = U01_JdbcTeoriaConnection.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                System.out.printf("  [%d] %s - %s (%.2f EUR, stock %d)%n",
                        id, titulo, autor, precio, stock);
            }
        } catch (SQLException e) {
            imprimirError(e);
        }
    }

    private static void contarLibros() {
        System.out.println("2) CONTAR REGISTROS");
        String sql = "SELECT COUNT(*) AS total FROM libros";

        try (Connection cn = U01_JdbcTeoriaConnection.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("Total libros: " + rs.getInt("total"));
            }
        } catch (SQLException e) {
            imprimirError(e);
        }
    }

    private static void selectConCondicion() {
        System.out.println("3) SELECT CON WHERE (precio > 30)");
        String sql = "SELECT titulo, precio FROM libros WHERE precio > 30 ORDER BY precio DESC";

        try (Connection cn = U01_JdbcTeoriaConnection.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("  - " + rs.getString("titulo") + ": " + rs.getDouble("precio") + " EUR");
            }
        } catch (SQLException e) {
            imprimirError(e);
        }
    }

    private static void imprimirError(SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
    }
}
