package andalucia.sevilla.iesvelazquez.colegiojdbc.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Conexion JDBC a la base de datos {@code Colegio}.
 *
 * <p><b>Practica integradora</b> IES Velazquez - bloque {@code 01-jdbc} (RA9).
 * Enunciado: {@code acceso-datos-contenido--sevilla-iesvelazquez.pdf} (carpeta de la practica).</p>
 *
 * <p><b>Objetivo de esta parte:</b> disponer de una conexion estable a MySQL para que el resto
 * de la aplicacion pueda leer y modificar datos de alumnos.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Cargar el driver JDBC de MySQL y abrir un {@link Connection} con {@link DriverManager}.</li>
 *   <li>Centralizar host, puerto, usuario, contrasena y nombre de la base de datos.</li>
 *   <li>Construir la URL JDBC con los parametros adecuados para MySQL 8+.</li>
 *   <li>Comprobar que la conexion responde antes de ejecutar el CRUD ({@link ColegioDemo}).</li>
 * </ul>
 *
 * <p>Utiliza <b>XAMPP</b> (MySQL), <b>MySQL Connector/J</b> en el classpath y la API JDBC
 * ({@link java.sql.Connection}, {@link java.util.Properties}). La base y la tabla se crean con
 * {@link ColegioSetup} o con {@code sql/colegio.sql}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ColegioConnection {

    // Cambia estos valores segun tu entorno local
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE = "Colegio"; // se crea via SQL o desde Java
    private static final String USER = "root";
    private static final String PASSWORD = ""; // pon tu contrasena

    // Construye la URL de conexion MySQL moderna (MySQL 8+)
    private static String buildJdbcUrl(String host, int port, String database) {
        return "jdbc:mysql://" + host + ":" + port + "/" + database +
                "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }

    public static Connection getConnection() throws SQLException {
        // Carga explicita del driver segun PDF (aunque DriverManager lo hace automatico
        // con JDBC 4, aqui lo forzamos para seguir la teoria)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver MySQL JDBC en el classpath", e);
        }

        String url = buildJdbcUrl(HOST, PORT, DATABASE);

        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        // Ejemplos de propiedades utiles
        props.setProperty("autoReconnect", "true");
        props.setProperty("characterEncoding", "utf8");

        return DriverManager.getConnection(url, props);
    }

    // Getters publicos para evitar reflexion desde otras clases del mismo paquete
    public static String getHost() { return HOST; }
    public static int getPort() { return PORT; }
    public static String getUser() { return USER; }
    public static String getPassword() { return PASSWORD; }

     public static void main(String[] args) {
         try (Connection cn = getConnection()) {
             System.out.println("Conexion OK a MySQL (BD: " + DATABASE + ")");
         } catch (SQLException e) {
             SqlExceptionUtil.printSQLException(e);
         }
     }
}


