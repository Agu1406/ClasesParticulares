package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.dao;

import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.db.DatabaseManager;
import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.model.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorDAO {

    public Autor insertar(String nombre, String apellido, String dni) throws SQLException {
        String sql = "INSERT INTO autores (nombre, apellido, dni) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    long id = keys.getLong(1);
                    return new Autor(id, nombre, apellido, dni);
                }
            }
        }
        throw new SQLException("No se obtuvo id de autor");
    }

    public Optional<Autor> buscarPorId(long id) throws SQLException {
        String sql = "SELECT id, nombre, apellido, dni FROM autores WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    public List<Autor> listarTodos() throws SQLException {
        String sql = "SELECT id, nombre, apellido, dni FROM autores ORDER BY id";
        List<Autor> lista = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        }
        return lista;
    }

    private static Autor map(ResultSet rs) throws SQLException {
        return new Autor(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("dni"));
    }
}
