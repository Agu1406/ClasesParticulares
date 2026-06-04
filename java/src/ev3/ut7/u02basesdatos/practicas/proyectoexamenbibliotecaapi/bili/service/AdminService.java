package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.bili.service;

import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.bili.db.Database;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService {

    public boolean createUser(String nombre, String apellido, String pass, String perfil) {
        int idPerfil = "ADMIN".equalsIgnoreCase(perfil) ? 1 : 2;
        String sql = "INSERT INTO usuarios (nombre, apellido, pass, id_perfil) VALUES (?, ?, ?, ?);";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, pass);
            ps.setInt(4, idPerfil);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateUser(int idUsuario, String apellido, String pass, String perfil) {
        int idPerfil = "ADMIN".equalsIgnoreCase(perfil) ? 1 : 2;
        String sql = "UPDATE usuarios SET apellido = ?, pass = ?, id_perfil = ? WHERE id_usuario = ?;";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, apellido);
            ps.setString(2, pass);
            ps.setInt(3, idPerfil);
            ps.setInt(4, idUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public int importProductsIfEmpty() {
        if (!isProductsTableEmpty()) {
            return 0;
        }
        String apiUrl = "https://fakestoreapi.com/products";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode products = mapper.readTree(response.body());
            return saveProducts(products);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error importando productos", e);
        }
    }

    public int clearProductsAndCart() {
        String deleteCart = "DELETE FROM carrito;";
        String deleteProducts = "DELETE FROM productos;";
        try (Connection conn = Database.getConnection();
             PreparedStatement psCart = conn.prepareStatement(deleteCart);
             PreparedStatement psProd = conn.prepareStatement(deleteProducts)) {
            conn.setAutoCommit(false);
            int cartDeleted = psCart.executeUpdate();
            int productsDeleted = psProd.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return cartDeleted + productsDeleted;
        } catch (SQLException e) {
            throw new RuntimeException("Error vaciando tablas", e);
        }
    }

    private boolean isProductsTableEmpty() {
        String sql = "SELECT COUNT(*) AS total FROM productos;";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() && rs.getInt("total") == 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error verificando productos", e);
        }
    }

    private int saveProducts(JsonNode products) {
        String sql = "INSERT INTO productos (id_producto, nombre, precio, descripcion) VALUES (?, ?, ?, ?);";
        int inserted = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (JsonNode p : products) {
                ps.setInt(1, p.get("id").asInt());
                ps.setString(2, p.get("title").asText());
                ps.setDouble(3, p.get("price").asDouble());
                ps.setString(4, p.get("description").asText());
                inserted += ps.executeUpdate();
            }
            return inserted;
        } catch (SQLException e) {
            throw new RuntimeException("Error guardando productos", e);
        }
    }
}
