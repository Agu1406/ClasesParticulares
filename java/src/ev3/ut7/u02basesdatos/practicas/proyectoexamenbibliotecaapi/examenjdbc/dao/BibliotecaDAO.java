package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.dao;

import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.db.DatabaseManager;
import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.model.Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BibliotecaDAO {

    public Biblioteca insertar(String calle, String localidad, String provincia) throws SQLException {
        String sql = "INSERT INTO bibliotecas (calle, localidad, provincia) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, calle);
            ps.setString(2, localidad);
            ps.setString(3, provincia);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return new Biblioteca(keys.getLong(1), calle, localidad, provincia);
                }
            }
        }
        throw new SQLException("No se obtuvo id de biblioteca");
    }

    public Optional<Biblioteca> buscarPorId(long id) throws SQLException {
        String sql = "SELECT id, calle, localidad, provincia FROM bibliotecas WHERE id = ?";
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

    public List<Biblioteca> listarTodas() throws SQLException {
        String sql = "SELECT id, calle, localidad, provincia FROM bibliotecas ORDER BY id";
        List<Biblioteca> lista = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        }
        return lista;
    }

    private static Biblioteca map(ResultSet rs) throws SQLException {
        return new Biblioteca(
                rs.getLong("id"),
                rs.getString("calle"),
                rs.getString("localidad"),
                rs.getString("provincia"));
    }
}
