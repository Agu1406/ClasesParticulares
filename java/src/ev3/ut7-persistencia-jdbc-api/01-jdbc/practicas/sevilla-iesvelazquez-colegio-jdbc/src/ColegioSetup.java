package andalucia.sevilla.iesvelazquez.colegiojdbc.src;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Preparacion del esquema: base de datos {@code Colegio} y tabla {@code Alumnos}.
 *
 * <p><b>Objetivo:</b> dejar el entorno listo para persistir alumnos antes de probar el CRUD.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Crear la base de datos {@code Colegio} si no existe (conexion al servidor sin BD).</li>
 *   <li>Crear la tabla {@code Alumnos} con clave primaria autoincremental y restricciones del enunciado.</li>
 *   <li>Ejecutar el DDL mediante {@link java.sql.Statement} y gestionar errores SQL.</li>
 * </ul>
 *
 * <p>Utiliza {@link ColegioFactoryForServer}, {@link ColegioConnection} y MySQL en XAMPP.
 * Ejecutar una sola vez antes de {@link ColegioDemo}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ColegioSetup {

    public static void main(String[] args) {
        // Crea la BD y la tabla desde Java usando Statement, siguiendo el PDF
        String createDb = "CREATE DATABASE IF NOT EXISTS Colegio" +
                " DEFAULT CHARACTER SET utf8mb4" +
                " DEFAULT COLLATE utf8mb4_general_ci";

        String createTable = "CREATE TABLE IF NOT EXISTS Alumnos (" +
                " id_alumno INT AUTO_INCREMENT PRIMARY KEY," +
                " nombre VARCHAR(100) NOT NULL," +
                " correo VARCHAR(150) NOT NULL UNIQUE," +
                " telefono VARCHAR(20) NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci";

        // Para crear la BD debemos conectar al servidor sin especificar BD
        try (Connection rootConn = ColegioFactoryForServer.getConnectionWithoutDatabase()) {
            try (Statement st = rootConn.createStatement()) {
                st.executeUpdate(createDb);
                System.out.println("BD Colegio creada/verificada");
            }
         } catch (SQLException e) {
             SqlExceptionUtil.printSQLException(e);
            return;
        }

        // Ahora conectar ya a la BD Colegio y crear la tabla
        try (Connection cn = ColegioConnection.getConnection();
             Statement st = cn.createStatement()) {
            st.executeUpdate(createTable);
            System.out.println("Tabla Alumnos creada/verificada");
        } catch (SQLException e) {
            SqlExceptionUtil.printSQLException(e);
        }
    }
}
