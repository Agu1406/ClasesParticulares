package com.bili.service;

import com.bili.db.Database;
import com.bili.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public void showProfile(Usuario usuario) {
        System.out.println("ID: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Perfil: " + usuario.getPerfil());
    }

    public boolean updatePassword(int idUsuario, String newPass) {
        String sql = "UPDATE usuarios SET pass = ? WHERE id_usuario = ?;";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPass);
            ps.setInt(2, idUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<String> listProducts() {
        String sql = "SELECT id_producto, nombre, precio, descripcion FROM productos ORDER BY id_producto;";
        List<String> products = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                products.add(String.format(
                        "[%d] %s | $%.2f | %s",
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error listando productos", e);
        }
        return products;
    }

    public boolean addProductToCart(int idCliente, int idProducto) {
        String sql = "INSERT INTO carrito (id_cliente, id_producto, cantidad) VALUES (?, ?, 1);";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.setInt(2, idProducto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<String> showCart(int idCliente) {
        String sql = """
                SELECT p.id_producto, p.nombre, p.precio, p.descripcion, c.cantidad
                FROM carrito c
                JOIN productos p ON c.id_producto = p.id_producto
                WHERE c.id_cliente = ?;
                """;
        List<String> cart = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cart.add(String.format(
                            "[%d] %s | $%.2f | cant: %d",
                            rs.getInt("id_producto"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getInt("cantidad")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error mostrando carrito", e);
        }
        return cart;
    }

    public double getCartTotal(int idCliente) {
        String sql = """
                SELECT COALESCE(SUM(p.precio * c.cantidad), 0) AS total_carrito
                FROM carrito c
                JOIN productos p ON c.id_producto = p.id_producto
                WHERE c.id_cliente = ?;
                """;
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("total_carrito");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error calculando total", e);
        }
        return 0;
    }
}
