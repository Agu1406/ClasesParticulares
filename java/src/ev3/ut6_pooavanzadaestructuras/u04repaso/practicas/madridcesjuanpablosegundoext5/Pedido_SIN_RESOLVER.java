package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridcesjuanpablosegundoext5;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un pedido realizado por un cliente
 */
public class Pedido_SIN_RESOLVER {
    private boolean estado; // true = cobrado, false = no cobrado
    private Cliente_SIN_RESOLVER cliente;
    private List<Producto_SIN_RESOLVER> productos;
    private int cuenta; // Valor total de todos los productos

    /**
     * Constructor de la clase Pedido_SIN_RESOLVER
     * @param cliente Cliente_SIN_RESOLVER que realiza el pedido
     */
    public Pedido_SIN_RESOLVER(Cliente_SIN_RESOLVER cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.cuenta = 0;
        this.estado = false; // Por defecto no esta cobrado
    }

    /**
     * Obtiene el estado del pedido
     * @return true si esta cobrado, false si no esta cobrado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado del pedido
     * @param estado true si esta cobrado, false si no esta cobrado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el cliente del pedido
     * @return Cliente_SIN_RESOLVER del pedido
     */
    public Cliente_SIN_RESOLVER getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente del pedido
     * @param cliente Cliente_SIN_RESOLVER del pedido
     */
    public void setCliente(Cliente_SIN_RESOLVER cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la lista de productos del pedido
     * @return Lista de productos
     */
    public List<Producto_SIN_RESOLVER> getProductos() {
        return productos;
    }

    /**
     * Obtiene el valor total de la cuenta
     * @return Valor total de la cuenta
     */
    public int getCuenta() {
        return cuenta;
    }

    /**
     * Agrega un producto al pedido y actualiza la cuenta
     * @param producto Producto_SIN_RESOLVER a agregar
     */
    public void addpedido(Producto_SIN_RESOLVER producto) {
        productos.add(producto);
        cuenta += producto.getPrecio();
    }

    /**
     * Muestra la informacion de todos los productos del pedido
     */
    public void listaproductos() {
        System.out.println("=== Productos del pedido ===");
        for (Producto_SIN_RESOLVER producto : productos) {
            producto.mostrarDatos();
        }
        System.out.println("Total: " + cuenta + " ?");
    }

    @Override
    public String toString() {
        return "Pedido_SIN_RESOLVER{" +
                "estado=" + (estado ? "Cobrado" : "No cobrado") +
                ", cliente=" + cliente.getNombre() + " (DNI: " + cliente.getDni() + ")" +
                ", cuenta=" + cuenta + " ?" +
                ", numeroProductos=" + productos.size() +
                '}';
    }
}

