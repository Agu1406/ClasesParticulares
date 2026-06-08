package ev3.ut7_persistenciajdbcapi.u01jdbc.practicas.sevillaiesvelazquezcolegiojdbc;

/**
 * Conexion al servidor MySQL sin seleccionar base de datos.
 *
 * <p><b>Objetivo:</b> permitir ejecutar {@code CREATE DATABASE} antes de que exista la BD
 * {@code Colegio} ({@link ColegioSetup}).</p>
 *
 * <p>Reutiliza la configuracion de {@link ColegioConnection} y el driver MySQL Connector/J.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ColegioFactoryForServer {
    // Reutilizamos los mismos HOST/PORT/USER/PASS de ColegioConnection mediante reflexion simple.
    // Aqui reconstruimos la URL sin base de datos.
    public static java.sql.Connection getConnectionWithoutDatabase() throws java.sql.SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new java.sql.SQLException("Driver MySQL no disponible", e);
        }

        String host = ColegioConnection.getHost();
        int port = ColegioConnection.getPort();
        String user = ColegioConnection.getUser();
        String password = ColegioConnection.getPassword();

        String url = "jdbc:mysql://" + host + ":" + port +
                "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        java.util.Properties props = new java.util.Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("autoReconnect", "true");
        props.setProperty("characterEncoding", "utf8");

        return java.sql.DriverManager.getConnection(url, props);
    }

    // Eliminados metodos de reflexion: usamos getters publicos en ColegioConnection
}
