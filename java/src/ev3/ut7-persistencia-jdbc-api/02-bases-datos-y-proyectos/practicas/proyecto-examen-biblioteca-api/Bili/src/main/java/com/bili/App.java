package com.bili;

import com.bili.db.Database;
import com.bili.model.Usuario;
import com.bili.service.AdminService;
import com.bili.service.AuthService;
import com.bili.service.ClientService;

import java.util.List;
import java.util.Scanner;

/**
 * Bili Store - tienda de consola con SQLite (Java 17+, Maven).
 * <p>
 * Practica de login, roles CLIENTE/ADMIN, carrito e importacion desde API.
 * <p>
 * Ejecutar: {@code mvn compile exec:java} desde la carpeta del proyecto (pom.xml).
 * Admin inicial: usuario {@code admin}, password {@code admin123}.
 * <p>
 * Cliente: ver datos, cambiar password, listar productos, carrito, total.
 * Admin: CRUD usuarios, importar desde https://fakestoreapi.com/products (si tabla vacia),
 * vaciar tablas carrito y productos.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class App {
    private static final Scanner SC = new Scanner(System.in);
    private static final AuthService AUTH_SERVICE = new AuthService();
    private static final ClientService CLIENT_SERVICE = new ClientService();
    private static final AdminService ADMIN_SERVICE = new AdminService();

    public static void main(String[] args) {
        Database.init();
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n=== TIENDA BILI ===");
            System.out.println("1) Login");
            System.out.println("2) Registro");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            String option = SC.nextLine();

            switch (option) {
                case "1" -> loginFlow();
                case "2" -> registerFlow();
                case "0" -> {
                    System.out.println("Hasta luego.");
                    return;
                }
                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    private static void loginFlow() {
        System.out.print("Usuario: ");
        String user = SC.nextLine().trim();
        System.out.print("Password: ");
        String pass = SC.nextLine().trim();

        Usuario logged = AUTH_SERVICE.login(user, pass);
        if (logged == null) {
            System.out.println("Credenciales invalidas.");
            return;
        }

        System.out.printf("Bienvenido %s (%s)%n", logged.getNombre(), logged.getPerfil());
        if ("ADMIN".equalsIgnoreCase(logged.getPerfil())) {
            adminMenu();
        } else {
            clientMenu(logged);
        }
    }

    private static void registerFlow() {
        System.out.println("\n=== Registro cliente ===");
        System.out.print("Nombre de usuario: ");
        String nombre = SC.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = SC.nextLine().trim();
        System.out.print("Password: ");
        String pass = SC.nextLine().trim();

        boolean ok = AUTH_SERVICE.registerClient(nombre, apellido, pass);
        System.out.println(ok ? "Registro exitoso." : "No se pudo registrar (usuario existente).");
    }

    private static void clientMenu(Usuario usuario) {
        while (true) {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1) Ver datos");
            System.out.println("2) Modificar password");
            System.out.println("3) Mostrar productos");
            System.out.println("4) Seleccionar producto (agregar al carrito)");
            System.out.println("5) Mostrar carrito");
            System.out.println("6) Ver total compra");
            System.out.println("0) Cerrar sesion");
            System.out.print("Opcion: ");
            String option = SC.nextLine();

            switch (option) {
                case "1" -> CLIENT_SERVICE.showProfile(usuario);
                case "2" -> {
                    System.out.print("Nueva password: ");
                    boolean ok = CLIENT_SERVICE.updatePassword(usuario.getIdUsuario(), SC.nextLine().trim());
                    System.out.println(ok ? "Password actualizada." : "No se pudo actualizar.");
                }
                case "3" -> printLines(CLIENT_SERVICE.listProducts(), "No hay productos.");
                case "4" -> {
                    System.out.print("Ingrese id_producto: ");
                    int idProducto = parseInt(SC.nextLine());
                    if (idProducto <= 0) {
                        System.out.println("ID invalido.");
                        break;
                    }
                    boolean ok = CLIENT_SERVICE.addProductToCart(usuario.getIdUsuario(), idProducto);
                    System.out.println(ok ? "Producto agregado al carrito." : "No se pudo agregar.");
                }
                case "5" -> printLines(CLIENT_SERVICE.showCart(usuario.getIdUsuario()), "Carrito vacio.");
                case "6" -> {
                    double total = CLIENT_SERVICE.getCartTotal(usuario.getIdUsuario());
                    System.out.printf("Total carrito: $%.2f%n", total);
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1) Crear usuario");
            System.out.println("2) Modificar usuario");
            System.out.println("3) Importar productos (si tabla vacia)");
            System.out.println("4) Vaciar tablas carrito y productos");
            System.out.println("0) Cerrar sesion");
            System.out.print("Opcion: ");
            String option = SC.nextLine();

            switch (option) {
                case "1" -> createUserFlow();
                case "2" -> updateUserFlow();
                case "3" -> {
                    int imported = ADMIN_SERVICE.importProductsIfEmpty();
                    if (imported == 0) {
                        System.out.println("No se importo: la tabla productos no esta vacia.");
                    } else {
                        System.out.println("Productos importados: " + imported);
                    }
                }
                case "4" -> {
                    int deleted = ADMIN_SERVICE.clearProductsAndCart();
                    System.out.println("Registros eliminados: " + deleted);
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    private static void createUserFlow() {
        System.out.print("Nombre usuario: ");
        String nombre = SC.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = SC.nextLine().trim();
        System.out.print("Password: ");
        String pass = SC.nextLine().trim();
        System.out.print("Perfil (ADMIN/CLIENTE): ");
        String perfil = SC.nextLine().trim().toUpperCase();
        if (!"ADMIN".equals(perfil) && !"CLIENTE".equals(perfil)) {
            System.out.println("Perfil invalido.");
            return;
        }
        boolean ok = ADMIN_SERVICE.createUser(nombre, apellido, pass, perfil);
        System.out.println(ok ? "Usuario creado." : "No se pudo crear usuario.");
    }

    private static void updateUserFlow() {
        System.out.print("ID usuario a modificar: ");
        int idUsuario = parseInt(SC.nextLine());
        if (idUsuario <= 0) {
            System.out.println("ID invalido.");
            return;
        }
        System.out.print("Nuevo apellido: ");
        String apellido = SC.nextLine().trim();
        System.out.print("Nueva password: ");
        String pass = SC.nextLine().trim();
        System.out.print("Perfil (ADMIN/CLIENTE): ");
        String perfil = SC.nextLine().trim().toUpperCase();
        if (!"ADMIN".equals(perfil) && !"CLIENTE".equals(perfil)) {
            System.out.println("Perfil invalido.");
            return;
        }
        boolean ok = ADMIN_SERVICE.updateUser(idUsuario, apellido, pass, perfil);
        System.out.println(ok ? "Usuario actualizado." : "No se pudo actualizar usuario.");
    }

    private static int parseInt(String text) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void printLines(List<String> lines, String emptyMessage) {
        if (lines.isEmpty()) {
            System.out.println(emptyMessage);
            return;
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
