package ev3.ut7.jdbc.ejercicios.facil;

import ev3.ut7.jdbc.shared.JdbcTeoriaConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejercicio 2 (facil) - RESUELTO. Listar titulos de libros (RA9-d).
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ej2_ListarLibros {

    public static void main(String[] args) {
        String sql = "SELECT id, titulo FROM libros ORDER BY id";

        try (Connection cn = JdbcTeoriaConnection.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("[" + rs.getInt("id") + "] " + rs.getString("titulo"));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
