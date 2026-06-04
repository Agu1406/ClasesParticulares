package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.dao;

import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.db.DatabaseManager;
import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public Libro insertar(
            String isbn,
            int paginas,
            String tipo,
            int anio,
            long autorId,
            long bibliotecaId
    ) throws SQLException {
        String sql = """
                INSERT INTO libros (isbn, numero_paginas, tipo, anio_publicacion, autor_id, biblioteca_id)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbn);
            ps.setInt(2, paginas);
            ps.setString(3, tipo);
            ps.setInt(4, anio);
            ps.setLong(5, autorId);
            ps.setLong(6, bibliotecaId);
            ps.executeUpdate();
        }
        return new Libro(isbn, paginas, tipo, anio, autorId, bibliotecaId);
    }

    public List<Libro> listarPorBiblioteca(long bibliotecaId) throws SQLException {
        String sql = """
                SELECT isbn, numero_paginas, tipo, anio_publicacion, autor_id, biblioteca_id
                FROM libros WHERE biblioteca_id = ?
                """;
        return consulta(sql, bibliotecaId);
    }

    public List<Libro> listarPorAutor(long autorId) throws SQLException {
        String sql = """
                SELECT isbn, numero_paginas, tipo, anio_publicacion, autor_id, biblioteca_id
                FROM libros WHERE autor_id = ?
                """;
        return consulta(sql, autorId);
    }

    private List<Libro> consulta(String sql, long id) throws SQLException {
        List<Libro> lista = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(map(rs));
                }
            }
        }
        return lista;
    }

    private static Libro map(ResultSet rs) throws SQLException {
        return new Libro(
                rs.getString("isbn"),
                rs.getInt("numero_paginas"),
                rs.getString("tipo"),
                rs.getInt("anio_publicacion"),
                rs.getLong("autor_id"),
                rs.getLong("biblioteca_id"));
    }
}
