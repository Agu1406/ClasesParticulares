package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.dao;

import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model.Libro;
import ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Acceso JDBC a la tabla {@code libros}.
 */
public class LibroDAO_RESUELTO {

    public void insertar(Libro libro) throws SQLException {
        String consulta = """
                INSERT INTO libros (isbn, num_paginas, tipo, anio_publicacion, id_autor, id_biblioteca)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {
            sentencia.setString(1, libro.getIsbn());
            sentencia.setInt(2, libro.getNumPaginas());
            sentencia.setString(3, libro.getTipo());
            sentencia.setInt(4, libro.getAnioPublicacion());
            sentencia.setInt(5, libro.getAutor().getId());
            sentencia.setInt(6, libro.getBiblioteca().getId());
            sentencia.executeUpdate();
        }
    }

    public List<Libro> listarPorBiblioteca(Integer identificadorBiblioteca) throws SQLException {
        String consulta = """
                SELECT isbn, num_paginas, tipo, anio_publicacion
                FROM libros WHERE id_biblioteca = ?
                """;
        return listarLibros(consulta, identificadorBiblioteca);
    }

    public List<Libro> listarPorAutor(Integer identificadorAutor) throws SQLException {
        String consulta = """
                SELECT isbn, num_paginas, tipo, anio_publicacion
                FROM libros WHERE id_autor = ?
                """;
        return listarLibros(consulta, identificadorAutor);
    }

    private List<Libro> listarLibros(String consulta, int identificador) throws SQLException {
        List<Libro> listaLibros = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {
            sentencia.setInt(1, identificador);
            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    Libro libro = new Libro();
                    libro.setIsbn(resultado.getString("isbn"));
                    libro.setNumPaginas(resultado.getInt("num_paginas"));
                    libro.setTipo(resultado.getString("tipo"));
                    libro.setAnioPublicacion(resultado.getInt("anio_publicacion"));
                    listaLibros.add(libro);
                }
            }
        }
        return listaLibros;
    }
}
