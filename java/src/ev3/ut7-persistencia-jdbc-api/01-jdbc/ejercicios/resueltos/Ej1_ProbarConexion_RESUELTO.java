package ev3.ut7.jdbc.ejercicios.resueltos;

import ev3.ut7.jdbc.shared.JdbcTeoriaConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Ejercicio 1  - RESUELTO. Probar conexion a JdbcTeoria (RA9-b).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ej1_ProbarConexion_RESUELTO {

    public static void main(String[] args) {
        try (Connection cn = JdbcTeoriaConnection.getConnection()) {
            if (!cn.isClosed()) {
                System.out.println("Conexion OK");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
        }
    }
}