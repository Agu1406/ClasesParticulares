package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.bili.service;

import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.bili.db.Database;
import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.bili.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {

    public Usuario login(String nombre, String pass) {
        String sql = """
                SELECT u.id_usuario, u.nombre, u.apellido, u.pass, p.nombre AS perfil
                FROM usuarios u
                JOIN perfiles p ON u.id_perfil = p.id_perfil
                WHERE u.nombre = ? AND u.pass = ?;
                """;
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, pass);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("pass"),
                            rs.getString("perfil")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error en login", e);
        }
        return null;
    }

    public boolean registerClient(String nombre, String apellido, String pass) {
        String sql = "INSERT INTO usuarios (nombre, apellido, pass, id_perfil) VALUES (?, ?, ?, 2);";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, pass);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
