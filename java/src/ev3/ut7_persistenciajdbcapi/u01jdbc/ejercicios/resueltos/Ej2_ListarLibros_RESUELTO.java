package ev3.ut7_persistenciajdbcapi.u01jdbc.ejercicios.resueltos;

import ev3.ut7_persistenciajdbcapi.u01jdbc.teoria.U01_JdbcTeoriaConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejercicio 2  - RESUELTO. Listar titulos de libros (RA9-d).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ej2_ListarLibros_RESUELTO {

    public static void main(String[] args) {
        String sql = "SELECT id, titulo FROM libros ORDER BY id";

        try (Connection cn = U01_JdbcTeoriaConnection.getConnection();
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