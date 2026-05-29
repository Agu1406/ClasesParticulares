package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class base_datos {

    public static Connection getConexion() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el driver JDBC");
        }
        return DriverManager.getConnection("jdbc:sqlite:data/biblioteca_ces.db");
    }

    public static void crearTablas() throws SQLException {
        File carpeta = new File("data");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        Connection conn = getConexion();
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS autores ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, dni TEXT UNIQUE)");
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS bibliotecas ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, calle TEXT, localidad TEXT, provincia TEXT)");
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS libros ("
                + "isbn TEXT PRIMARY KEY, autor_id INTEGER, biblioteca_id INTEGER, "
                + "numero_paginas INTEGER, tipo TEXT, anio_publicacion INTEGER)");

        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM bibliotecas");
        rs.next();
        if (rs.getInt(1) == 0) {
            stmt.executeUpdate("INSERT INTO bibliotecas VALUES (null, 'Calle Mayor 12', 'Madrid', 'Madrid')");
            stmt.executeUpdate("INSERT INTO bibliotecas VALUES (null, 'Av. Constitucion 45', 'Sevilla', 'Sevilla')");
            stmt.executeUpdate("INSERT INTO bibliotecas VALUES (null, 'Plaza Ayuntamiento 3', 'Valencia', 'Valencia')");
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    public static int tipoError(SQLException e) {
        if (e.getMessage() != null && e.getMessage().contains("UNIQUE constraint failed")) {
            return 1;
        }
        return 0;
    }
}
