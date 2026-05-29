package ev3.ut7.jdbc.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Conexion compartida para teoria y ejercicios JDBC (BD demo {@code JdbcTeoria}).
 * <p>
 * Antes de usar: ejecuta {@code sql/jdbc_teoria.sql} en phpMyAdmin y ajusta {@link #USER}
 * y {@link #PASSWORD} segun tu XAMPP.
 *
 * <h2>Compilar y ejecutar (PowerShell, desde {@code teoria/_shared})</h2>
 * <pre>
 * $JAR = "C:\libs\mysql-connector-j-8.0.33.jar"
 * javac -encoding UTF-8 -d . JdbcTeoriaConnection.java
 * javac -encoding UTF-8 -d . -cp ".;$JAR" ..\02-conexion-driver\SandBox.java
 * java -cp ".;$JAR" ev3.ut7.jdbc.conexion.SandBox
 * </pre>
 *
 * Para el resto de SandBoxes, anade {@code -cp "$SHARED;$CP"} donde {@code SHARED} apunta
 * a esta carpeta compilada.
 *
 * @see ev3.ut7.jdbc.entorno.EntornoXamppIntro
 *
 * @author Agustín. A. Marquez. Piña
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
