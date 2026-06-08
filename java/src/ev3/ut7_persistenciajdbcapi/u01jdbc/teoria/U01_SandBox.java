package ev3.ut7_persistenciajdbcapi.u01jdbc.teoria;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Sesion 2 - Primera conexion JDBC y metadatos basicos (RA9 CE a, b).
 * <p>
 * Requisitos: XAMPP/MySQL activo, script jdbc_teoria.sql ejecutado, Connector/J en classpath.
 * Configura credenciales en {@link ev3.ut7_persistenciajdbcapi.jdbc.conexion.U01_JdbcTeoriaConnection}.
 *
 * @see ev3.ut7_persistenciajdbcapi.jdbc.entorno.U02_EntornoXamppIntro
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_SandBox {

    public static void main(String[] args) {
        System.out.println("=== SESION 2: CONEXION JDBC ===\n");

        ejemploConexionBasica();
        System.out.println();
        ejemploMetadatos();
        System.out.println();
        ejemploErroresComunes();
    }

    private static void ejemploConexionBasica() {
        System.out.println("1) CONEXION BASICA");
        try (Connection cn = U01_JdbcTeoriaConnection.getConnection()) {
            System.out.println("Conectado correctamente.");
            System.out.println("Cerrada? " + cn.isClosed());
        } catch (SQLException e) {
            imprimirError(e);
        }
    }

    private static void ejemploMetadatos() {
        System.out.println("2) METADATOS DE LA BD");
        try (Connection cn = U01_JdbcTeoriaConnection.getConnection()) {
            DatabaseMetaData meta = cn.getMetaData();
            System.out.println("Producto: " + meta.getDatabaseProductName());
            System.out.println("Version: " + meta.getDatabaseProductVersion());
            System.out.println("Driver: " + meta.getDriverName());
            System.out.println("URL: " + meta.getURL());
        } catch (SQLException e) {
            imprimirError(e);
        }
    }

    private static void ejemploErroresComunes() {
        System.out.println("3) ERRORES FRECUENTES (referencia)");
        System.out.println("- Communications link failure -> MySQL parado en XAMPP");
        System.out.println("- Unknown database -> ejecuta el script SQL de inicializacion de tu BD");
        System.out.println("- ClassNotFoundException driver -> falta el .jar en -cp");
        System.out.println("- Access denied -> revisa USER/PASSWORD en U01_JdbcTeoriaConnection");
    }

    private static void imprimirError(SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
        System.err.println("SQLState: " + e.getSQLState() + " | ErrorCode: " + e.getErrorCode());
    }
}
