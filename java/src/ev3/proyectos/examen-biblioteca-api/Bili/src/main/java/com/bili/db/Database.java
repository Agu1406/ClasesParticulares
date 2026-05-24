package com.bili.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String DB_URL = "jdbc:sqlite:bili.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void init() {
        try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
            st.execute("""
                    CREATE TABLE IF NOT EXISTS perfiles (
                        id_perfil INTEGER PRIMARY KEY AUTOINCREMENT,
                        nombre TEXT NOT NULL UNIQUE
                    );
                    """);

            st.execute("""
                    CREATE TABLE IF NOT EXISTS usuarios (
                        id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
                        nombre TEXT NOT NULL UNIQUE,
                        apellido TEXT NOT NULL,
                        pass TEXT NOT NULL,
                        id_perfil INTEGER NOT NULL,
                        FOREIGN KEY (id_perfil) REFERENCES perfiles(id_perfil)
                    );
                    """);

            st.execute("""
                    CREATE TABLE IF NOT EXISTS productos (
                        id_producto INTEGER PRIMARY KEY,
                        nombre TEXT NOT NULL,
                        precio REAL NOT NULL,
                        descripcion TEXT
                    );
                    """);

            st.execute("""
                    CREATE TABLE IF NOT EXISTS carrito (
                        id_carrito INTEGER PRIMARY KEY AUTOINCREMENT,
                        id_cliente INTEGER NOT NULL,
                        id_producto INTEGER NOT NULL,
                        cantidad INTEGER NOT NULL DEFAULT 1,
                        FOREIGN KEY (id_cliente) REFERENCES usuarios(id_usuario),
                        FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
                    );
                    """);

            seedProfiles(conn);
            seedAdmin(conn);
        } catch (SQLException e) {
            throw new RuntimeException("Error inicializando DB", e);
        }
    }

    private static void seedProfiles(Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT OR IGNORE INTO perfiles (id_perfil, nombre) VALUES (?, ?)")) {
            ps.setInt(1, 1);
            ps.setString(2, "ADMIN");
            ps.executeUpdate();
            ps.setInt(1, 2);
            ps.setString(2, "CLIENTE");
            ps.executeUpdate();
        }
    }

    private static void seedAdmin(Connection conn) throws SQLException {
        String sql = """
                INSERT INTO usuarios (nombre, apellido, pass, id_perfil)
                SELECT ?, ?, ?, 1
                WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE id_perfil = 1);
                """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "admin");
            ps.setString(2, "root");
            ps.setString(3, "admin123");
            ps.executeUpdate();
        }
    }
}
