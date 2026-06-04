package ev3.ut7.jdbc.ejercicios.resueltos;

import ev3.ut7.jdbc.shared.JdbcTeoriaConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejercicio 3  - RESUELTO. Insertar libro con PreparedStatement (RA9-c).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ej3_InsertarLibro_RESUELTO {

    public static void main(String[] args) {
        String sql = "INSERT INTO libros (titulo, autor, precio, stock) VALUES (?, ?, ?, ?)";

        try (Connection cn = JdbcTeoriaConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, "Introduccion a JDBC");
            ps.setString(2, "Clase FP");
            ps.setDouble(3, 19.99);
            ps.setInt(4, 10);
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    System.out.println("Nuevo id: " + keys.getInt(1));
                } else {
                    System.out.println("Nuevo id: -1");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}