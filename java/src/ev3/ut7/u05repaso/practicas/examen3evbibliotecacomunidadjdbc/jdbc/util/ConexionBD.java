package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexion JDBC a MySQL ({@code biblioteca_ces}).
 */
public final class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/biblioteca_ces"
                    + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
