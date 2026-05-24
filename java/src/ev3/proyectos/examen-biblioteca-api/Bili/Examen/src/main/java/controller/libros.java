package controller;

import model.Autor;
import model.base_datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class libros {

    public static boolean insertar(String isbn, int autorID, int bibliotecaID, int paginas, String tipo, int anio) {
        try {
            Connection conn = base_datos.getConexion();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO libros VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, isbn);
            ps.setInt(2, autorID);
            ps.setInt(3, bibliotecaID);
            ps.setInt(4, paginas);
            ps.setString(5, tipo);
            ps.setInt(6, anio);
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("Libro insertado: " + isbn);
            return true;
        } catch (SQLException e) {
            switch (base_datos.tipoError(e)) {
                case 1 -> System.out.println("Error: ya existe un libro con ese ISBN");
                default -> System.out.println("Error al guardar el libro.");
            }
            return false;
        }
    }

    public static void exportarCsv(String dni) throws Exception {
        Autor autor = autores.buscarPorDni(dni);
        if (autor == null) {
            System.out.println("Error: no se encontro el autor");
            return;
        }

        Connection conn = base_datos.getConexion();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT isbn, biblioteca_ID, numero_paginas, tipo, anio_publicacion FROM libros WHERE autor_ID = ?");
        ps.setInt(1, autor.ID);
        ResultSet rs = ps.executeQuery();

        File carpeta = new File("export");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        FileWriter fw = new FileWriter("export/libros_autor_" + dni + ".csv");
        fw.write("isbn,biblioteca_ID,numero_paginas,tipo,anio_publicacion,autor\n");

        while (rs.next()) {
            fw.write(rs.getString(1) + "," + rs.getInt(2) + "," + rs.getInt(3) + ","
                    + rs.getString(4) + "," + rs.getInt(5) + "," + autor.nombre + " " + autor.apellido + "\n");
        }

        fw.close();
        rs.close();
        ps.close();
        conn.close();

        System.out.println("Fichero csv guardado en export/libros_autor_" + dni + ".csv");
    }
}
