package controller;

import model.Autor;
import model.Libro;
import model.base_datos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class autores {

    public static boolean insertar(String nombre, String apellido, String dni) {
        try {
            Connection conn = base_datos.getConexion();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO autores (nombre, apellido, dni) VALUES (?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("Autor creado: " + nombre + " " + apellido);
            return true;
        } catch (SQLException e) {
            switch (base_datos.tipoError(e)) {
                case 1 -> System.out.println("Error: ya existe un autor con ese DNI");
                default -> System.out.println("Error al guardar el autor.");
            }
            return false;
        }
    }

    public static Autor buscarPorDni(String dni) throws SQLException {
        Connection conn = base_datos.getConexion();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT ID, nombre, apellido, dni FROM autores WHERE dni = ?");
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();

        Autor autor = null;
        if (rs.next()) {
            autor = new Autor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }

        rs.close();
        ps.close();
        conn.close();
        return autor;
    }

    public static void listarTodos() throws SQLException {
        Connection conn = base_datos.getConexion();
        PreparedStatement ps = conn.prepareStatement("SELECT ID, nombre, apellido, dni FROM autores");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(new Autor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }

        rs.close();
        ps.close();
        conn.close();
    }
}
