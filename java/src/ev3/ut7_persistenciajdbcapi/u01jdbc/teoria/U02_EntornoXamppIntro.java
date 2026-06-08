package ev3.ut7_persistenciajdbcapi.u01jdbc.teoria;

/**
 * Sesion 1 - Entorno XAMPP, MySQL y conceptos JDBC (RA9 del modulo 0485).
 * <p>
 * Material teorico sin codigo ejecutable: lee este JavaDoc antes de tocar JDBC.
 *
 * <h2>1. Instalar y arrancar XAMPP</h2>
 * <ol>
 *   <li>Descarga XAMPP: https://www.apachefriends.org/</li>
 *   <li>Instala (Windows: carpeta habitual {@code C:\xampp}).</li>
 *   <li>Abre XAMPP Control Panel y pulsa Start en MySQL.</li>
 *   <li>Apache solo si quieres phpMyAdmin por web.</li>
 *   <li>Comprueba puerto 3306 libre (conflicto con otro MySQL instalado).</li>
 * </ol>
 *
 * <h2>2. phpMyAdmin</h2>
 * Con Apache + MySQL: http://localhost/phpmyadmin - usuario {@code root}, password vacia.
 * Desde ahi ejecuta tu script de inicializacion SQL para la BD de pruebas JDBC.
 *
 * <h2>3. Modelo relacional (repaso)</h2>
 * BD {@code JdbcTeoria}, tabla {@code libros}, filas = registros, columnas = campos,
 * clave primaria {@code id} AUTO_INCREMENT.
 *
 * <h2>4. Que es JDBC</h2>
 * Java Database Connectivity: API estandar Java &harr; SGBD.
 * Flujo: Driver &rarr; Connection &rarr; Statement/PreparedStatement &rarr; ResultSet &rarr; cerrar recursos.
 * <ul>
 *   <li>{@code DriverManager} - obtiene Connection desde URL JDBC</li>
 *   <li>{@code Connection} - sesion activa con la BD</li>
 *   <li>{@code Statement} - SQL literal (SELECT, DDL)</li>
 *   <li>{@code PreparedStatement} - SQL con {@code ?} (CRUD seguro)</li>
 *   <li>{@code ResultSet} - filas de un SELECT</li>
 * </ul>
 * URL ejemplo: {@code jdbc:mysql://localhost:3306/JdbcTeoria?useSSL=false&serverTimezone=UTC}
 *
 * <h2>5. MySQL Connector/J</h2>
 * Descarga: https://dev.mysql.com/downloads/connector/j/ (Platform Independent).
 * Guarda el jar en el classpath del proyecto (p. ej. {@code mysql-connector-j-8.0.33.jar}).
 * Sin driver: {@code ClassNotFoundException: com.mysql.cj.jdbc.Driver}.
 *
 * <h2>6. RA9 vs RA8</h2>
 * RA9 (este bloque): JDBC + MySQL relacional, CRUD, integridad.
 * RA8 (mas adelante en EV3): persistencia OO, ORM.
 *
 * <h2>7. Plan de 6 sesiones (01-jdbc)</h2>
 * <ol>
 *   <li>Esta clase - {@link U02_EntornoXamppIntro}; indice {@link ev3.ut7_persistenciajdbcapi.jdbc.U06_JdbcIntro}</li>
 *   <li>Conexion - {@code teoria/02-conexion-driver/U05_SandBox.java}</li>
 *   <li>SELECT - {@code teoria/03-statement-select/U05_SandBox.java}</li>
 *   <li>CRUD - {@code teoria/04-preparedstatement-crud/U05_SandBox.java}</li>
 *   <li>Transacciones - {@code teoria/05-transacciones-y-recursos/U05_SandBox.java}</li>
 *   <li>Practica Colegio - {@code practicas/sevilla-iesvelazquez-colegio-jdbc/} (ver {@code ColegioDemo})</li>
 * </ol>
 *
 * <h2>8. Checklist antes de sesion 2</h2>
 * MySQL activo, phpMyAdmin OK, Connector/J descargado, script jdbc_teoria.sql ejecutado,
 * JDK instalado ({@code java -version}).
 *
 * @see ev3.ut7_persistenciajdbcapi.jdbc.conexion.U01_JdbcTeoriaConnection
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_EntornoXamppIntro {

    private U02_EntornoXamppIntro() {
    }
}
