package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbcjdbc;

import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbcjdbc.Biblioteca;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbcjdbc.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Acceso JDBC a la tabla {@code bibliotecas}.
 */
public class BibliotecaDAO_RESUELTO {

    public void insertar(Biblioteca biblioteca) throws SQLException {
        String consulta = "INSERT INTO bibliotecas (calle, localidad, provincia) VALUES (?, ?, ?)";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
            sentencia.setString(1, biblioteca.getCalle());
            sentencia.setString(2, biblioteca.getLocalidad());
            sentencia.setString(3, biblioteca.getProvincia());
            sentencia.executeUpdate();
            try (ResultSet clavesGeneradas = sentencia.getGeneratedKeys()) {
                if (clavesGeneradas.next()) {
                    biblioteca.setId(clavesGeneradas.getInt(1));
                }
            }
        }
    }
}
