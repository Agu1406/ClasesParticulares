package ev3.ut7.jdbc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Conexion compartida para teoria y ejercicios JDBC (BD demo {@code JdbcTeoria}).
 *
 * <p><b>Objetivo:</b> centralizar la conexion a MySQL para los SandBoxes del bloque {@code 01-jdbc}.</p>
 *
 * <p>Para ello, esta clase debe:</p>
 * <ul>
 *   <li>Cargar el driver MySQL y abrir {@link Connection} contra {@code JdbcTeoria}.</li>
 *   <li>Exponer host, puerto, usuario y contrasena configurables (XAMPP).</li>
 *   <li>Reutilizarse desde los SandBoxes de conexion, SELECT, CRUD y transacciones.</li>
 * </ul>
 *
 * <p>Utiliza <b>XAMPP</b>, <b>MySQL Connector/J</b> y {@link DriverManager}.
 * Preparar la BD con {@code sql/jdbc_teoria.sql}. Ver {@link ev3.ut7.jdbc.entorno.EntornoXamppIntro}.</p>
 *
 * @see ev3.ut7.jdbc.entorno.EntornoXamppIntro
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public final class JdbcTeoriaConnection {

    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE = "JdbcTeoria";
    /** Usuario XAMPP por defecto. */
    private static final String USER = "root";
    /** En XAMPP suele ir vacio. */
    private static final String PASSWORD = "";

    private JdbcTeoriaConnection() {
    }

    /**
     * Abre una conexion a {@code JdbcTeoria}. Carga el driver MySQL explicitamente
     * (didactica; JDBC 4+ puede omitir {@code Class.forName}).
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(
                    "No se encontro el driver MySQL. Anade mysql-connector-j.jar al classpath.", e);
        }

        String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        return DriverManager.getConnection(url, props);
    }

    /** Prueba rapida de conexion (sesion 2). */
    public static void main(String[] args) {
        try (Connection cn = getConnection()) {
            System.out.println("Conexion OK a " + DATABASE + " en " + HOST + ":" + PORT);
            System.out.println("AutoCommit: " + cn.getAutoCommit());
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState() + " | ErrorCode: " + e.getErrorCode());
        }
    }
}
