package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:data/examen_biblioteca_jdbc.db";

    private DatabaseManager() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initSchema() throws SQLException {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
            st.execute("""
                    CREATE TABLE IF NOT EXISTS autores (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        nombre TEXT NOT NULL,
                        apellido TEXT NOT NULL,
                        dni TEXT NOT NULL UNIQUE
                    );
                    """);
            st.execute("""
                    CREATE TABLE IF NOT EXISTS bibliotecas (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        calle TEXT NOT NULL,
                        localidad TEXT NOT NULL,
                        provincia TEXT NOT NULL
                    );
                    """);
            st.execute("""
                    CREATE TABLE IF NOT EXISTS libros (
                        isbn TEXT PRIMARY KEY,
                        numero_paginas INTEGER NOT NULL,
                        tipo TEXT NOT NULL,
                        anio_publicacion INTEGER NOT NULL,
                        autor_id INTEGER NOT NULL,
                        biblioteca_id INTEGER NOT NULL,
                        FOREIGN KEY (autor_id) REFERENCES autores(id),
                        FOREIGN KEY (biblioteca_id) REFERENCES bibliotecas(id)
                    );
                    """);
        }
    }
}
