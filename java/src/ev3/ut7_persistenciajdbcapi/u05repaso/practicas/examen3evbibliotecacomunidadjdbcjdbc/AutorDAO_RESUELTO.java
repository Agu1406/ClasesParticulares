package ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbcjdbc;

import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbcjdbc.Autor;
import ev3.ut7_persistenciajdbcapi.u05repaso.practicas.examen3evbibliotecacomunidadjdbcjdbc.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Acceso JDBC a la tabla {@code autores}.
 */
public class AutorDAO_RESUELTO {

    /**
     * Inserta un autor y asigna el id generado.
     */
    public void insertar(Autor autor) throws SQLException {
        String consulta = "INSERT INTO autores (nombre, apellido, dni) VALUES (?, ?, ?)";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
            sentencia.setString(1, autor.getNombre());
            sentencia.setString(2, autor.getApellido());
            sentencia.setString(3, autor.getDni());
            sentencia.executeUpdate();
            try (ResultSet clavesGeneradas = sentencia.getGeneratedKeys()) {
                if (clavesGeneradas.next()) {
                    autor.setId(clavesGeneradas.getInt(1));
                }
            }
        }
    }

    public Autor buscarPorId(Integer identificador) throws SQLException {
        String consulta = "SELECT id, nombre, apellido, dni FROM autores WHERE id = ?";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {
            sentencia.setInt(1, identificador);
            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return mapearAutor(resultado);
                }
            }
        }
        return null;
    }

    public List<Autor> listarTodos() throws SQLException {
        String consulta = "SELECT id, nombre, apellido, dni FROM autores ORDER BY id";
        List<Autor> listaAutores = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(consulta);
             ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                listaAutores.add(mapearAutor(resultado));
            }
        }
        return listaAutores;
    }

    private Autor mapearAutor(ResultSet resultado) throws SQLException {
        Autor autor = new Autor();
        autor.setId(resultado.getInt("id"));
        autor.setNombre(resultado.getString("nombre"));
        autor.setApellido(resultado.getString("apellido"));
        autor.setDni(resultado.getString("dni"));
        return autor;
    }
}
