package controller;

import model.Autor;
import model.Biblioteca;
import model.base_datos;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class bibliotecas {

    public static ArrayList<Biblioteca> listar() throws SQLException {
        Connection conn = base_datos.getConexion();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT ID, calle, localidad, provincia FROM bibliotecas");
        ResultSet rs = ps.executeQuery();

        ArrayList<Biblioteca> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Biblioteca(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }

        rs.close();
        ps.close();
        conn.close();
        return lista;
    }

    public static void mostrarLibros(int IDBiblioteca) throws SQLException {
        Connection conn = base_datos.getConexion();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT l.isbn, l.numero_paginas, l.tipo, l.anio_publicacion, a.nombre, a.apellido "
                        + "FROM libros l, autores a WHERE l.autor_ID = a.ID AND l.biblioteca_ID = ?");
        ps.setInt(1, IDBiblioteca);
        ResultSet rs = ps.executeQuery();

        boolean hay = false;
        while (rs.next()) {
            hay = true;
            System.out.println("ISBN: " + rs.getString(1) + ", paginas: " + rs.getInt(2)
                    + ", tipo: " + rs.getString(3) + ", anio: " + rs.getInt(4)
                    + ", autor: " + rs.getString(5) + " " + rs.getString(6));
        }
        if (!hay) {
            System.out.println("No hay libros en esa biblioteca");
        }

        rs.close();
        ps.close();
        conn.close();
    }
}
