package ev3.ut7.jdbc.preparedstatement;

import ev3.ut7.jdbc.conexion.JdbcTeoriaConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Sesion 4 - {@link java.sql.PreparedStatement}: INSERT, UPDATE, DELETE (RA9 CE c, e).
 * <p>
 * Usa placeholders {@code ?} en lugar de concatenar SQL. Incluye demo de riesgo de inyeccion SQL.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class SandBox {

    public static void main(String[] args) {
        System.out.println("=== SESION 4: PREPAREDSTATEMENT CRUD ===\n");

        int idNuevo = insertarLibro("Patrones de diseno", "GoF", 42.00, 3);
        System.out.println("Insertado id: " + idNuevo);
        System.out.println();

        if (idNuevo > 0) {
            boolean ok = actualizarPrecio(idNuevo, 38.50);
            System.out.println("Precio actualizado? " + ok);
            System.out.println();

            mostrarLibro(idNuevo);
            System.out.println();

            boolean borrado = eliminarLibro(idNuevo);
            System.out.println("Eliminado? " + borrado);
        }

        System.out.println();
        demoInyeccionSql();
    }

    private static int insertarLibro(String titulo, String autor, double precio, int stock) {
        System.out.println("1) INSERT con PreparedStatement");
        String sql = "INSERT INTO libros (titulo, autor, precio, stock) VALUES (?, ?, ?, ?)";

        try (Connection cn = JdbcTeoriaConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setDouble(3, precio);
            ps.setInt(4, stock);
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            imprimirError(e);
        }
        return -1;
    }

    private static boolean actualizarPrecio(int id, double nuevoPrecio) {
        System.out.println("2) UPDATE");
        String sql = "UPDATE libros SET precio = ? WHERE id = ?";

        try (Connection cn = JdbcTeoriaConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setDouble(1, nuevoPrecio);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            imprimirError(e);
            return false;
        }
    }

    private static void mostrarLibro(int id) {
        System.out.println("3) SELECT por ID");
        String sql = "SELECT titulo, precio FROM libros WHERE id = ?";

        try (Connection cn = JdbcTeoriaConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("  " + rs.getString("titulo") + " -> " + rs.getDouble("precio") + " EUR");
                }
            }
        } catch (SQLException e) {
            imprimirError(e);
        }
    }

    private static boolean eliminarLibro(int id) {
        System.out.println("4) DELETE");
        String sql = "DELETE FROM libros WHERE id = ?";

        try (Connection cn = JdbcTeoriaConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            imprimirError(e);
            return false;
        }
    }

    private static void demoInyeccionSql() {
        System.out.println("5) POR QUE NO CONCATENAR SQL");
        String entradaMaliciosa = "' OR '1'='1";
        System.out.println("Entrada usuario: " + entradaMaliciosa);
        System.out.println("Mal (concatenacion): SELECT * FROM libros WHERE titulo = '" + entradaMaliciosa + "'");
        System.out.println("Bien (PreparedStatement): SELECT * FROM libros WHERE titulo = ?  --> parametro escapado");
    }

    private static void imprimirError(SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
    }
}
