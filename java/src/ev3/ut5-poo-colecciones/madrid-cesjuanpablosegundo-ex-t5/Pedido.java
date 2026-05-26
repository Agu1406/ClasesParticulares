package madrid.cesjuanpablosegundo.EX_T5;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un pedido realizado por un cliente
 */
public class Pedido {
    private boolean estado; // true = cobrado, false = no cobrado
    private Cliente cliente;
    private List<Producto> productos;
    private int cuenta; // Valor total de todos los productos

    /**
     * Constructor de la clase Pedido
     * @param cliente Cliente que realiza el pedido
     */
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.cuenta = 0;
        this.estado = false; // Por defecto no está cobrado
    }

    /**
     * Obtiene el estado del pedido
     * @return true si está cobrado, false si no está cobrado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado del pedido
     * @param estado true si está cobrado, false si no está cobrado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el cliente del pedido
     * @return Cliente del pedido
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente del pedido
     * @param cliente Cliente del pedido
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la lista de productos del pedido
     * @return Lista de productos
     */
    public List<Producto> getProductos() {
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
     * @param producto Producto a agregar
     */
    public void addpedido(Producto producto) {
        productos.add(producto);
        cuenta += producto.getPrecio();
    }

    /**
     * Muestra la información de todos los productos del pedido
     */
    public void listaproductos() {
        System.out.println("=== Productos del pedido ===");
        for (Producto producto : productos) {
            producto.mostrarDatos();
        }
        System.out.println("Total: " + cuenta + " €");
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "estado=" + (estado ? "Cobrado" : "No cobrado") +
                ", cliente=" + cliente.getNombre() + " (DNI: " + cliente.getDni() + ")" +
                ", cuenta=" + cuenta + " €" +
                ", numeroProductos=" + productos.size() +
                '}';
    }
}

