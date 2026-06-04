package ev3.ut6.u04repaso.practicas.madridcesjuanpablosegundoext5;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona todos los pedidos y la recaudacion del restaurante
 */
public class Restaurante_SIN_RESOLVER {
    private int caja; // Recaudacion de los pedidos
    private String nif; // Identificador de la empresa
    private String nombre; // Nombre de la empresa
    private List<Pedido_SIN_RESOLVER> pedidos; // Lista de pedidos

    /**
     * Constructor sin parametros de la clase Restaurante_SIN_RESOLVER
     */
    public Restaurante_SIN_RESOLVER() {
        this.nif = "";
        this.nombre = "";
        this.pedidos = new ArrayList<>();
        this.caja = 0;
    }

    /**
     * Constructor de la clase Restaurante_SIN_RESOLVER
     * @param nombre Nombre del restaurante
     * @param nif NIF del restaurante
     */
    public Restaurante_SIN_RESOLVER(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = nif;
        this.pedidos = new ArrayList<>();
        this.caja = 0;
    }

    /**
     * Obtiene el valor de la caja
     * @return Valor de la caja
     */
    public int getCaja() {
        return caja;
    }

    /**
     * Muestra el valor de la caja
     */
    public void mostrarcaja() {
        System.out.println("Valor de la caja: " + caja + " ?");
    }

    /**
     * Obtiene el NIF del restaurante
     * @return NIF del restaurante
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el NIF del restaurante
     * @param nif NIF del restaurante
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre del restaurante
     * @return Nombre del restaurante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del restaurante
     * @param nombre Nombre del restaurante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de pedidos
     * @return Lista de pedidos
     */
    public List<Pedido_SIN_RESOLVER> getPedidos() {
        return pedidos;
    }

    /**
     * Agrega un pedido a la lista. No se admiten pedidos de clientes que ya tengan uno activo
     * @param pedido Pedido_SIN_RESOLVER a agregar
     * @return true si se agrego correctamente, false si el cliente ya tiene un pedido activo
     */
    public boolean agregarpedido(Pedido_SIN_RESOLVER pedido) {
        // Verificar si el cliente ya tiene un pedido activo (no cobrado)
        for (Pedido_SIN_RESOLVER p : pedidos) {
            if (p.getCliente().getDni().equals(pedido.getCliente().getDni()) && !p.isEstado()) {
                System.out.println("ERROR: El cliente con DNI " + pedido.getCliente().getDni() + 
                                 " ya tiene un pedido activo que no ha sido cobrado.");
                return false;
            }
        }
        pedidos.add(pedido);
        System.out.println("Pedido_SIN_RESOLVER agregado correctamente para el cliente " + pedido.getCliente().getNombre());
        return true;
    }

    /**
     * Cobra el pedido del cliente con el DNI especificado y emite una factura
     * @param dni DNI del cliente cuyo pedido se va a cobrar
     * @return true si se cobro correctamente, false si no se encontro el pedido o ya estaba cobrado
     */
    public boolean cobrarpedido(String dni) {
        for (Pedido_SIN_RESOLVER pedido : pedidos) {
            if (pedido.getCliente().getDni().equals(dni) && !pedido.isEstado()) {
                // Marcar el pedido como cobrado
                pedido.setEstado(true);
                // Anadir el valor a la caja
                caja += pedido.getCuenta();
                // Emitir factura
                emitirFactura(pedido);
                return true;
            }
        }
        System.out.println("ERROR: No se encontro un pedido activo para el cliente con DNI " + dni);
        return false;
    }

    /**
     * Emite una factura con los productos del pedido, nombre del restaurante y NIF
     * @param pedido Pedido_SIN_RESOLVER del que se emite la factura
     */
    private void emitirFactura(Pedido_SIN_RESOLVER pedido) {
        System.out.println("\n========================================");
        System.out.println("           FACTURA");
        System.out.println("========================================");
        System.out.println("Restaurante_SIN_RESOLVER: " + nombre);
        System.out.println("NIF: " + nif);
        System.out.println("Cliente_SIN_RESOLVER: " + pedido.getCliente().getNombre() + " (DNI: " + pedido.getCliente().getDni() + ")");
        System.out.println("----------------------------------------");
        pedido.listaproductos();
        System.out.println("========================================\n");
    }

    /**
     * Muestra todos los pedidos del restaurante
     */
    public void mostrarTodosLosPedidos() {
        System.out.println("\n=== LISTA DE TODOS LOS PEDIDOS ===");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println((i + 1) + ". " + pedidos.get(i));
            }
        }
        System.out.println();
    }

    /**
     * Muestra solo los pedidos que han sido cobrados
     */
    public void mostrarPedidosCobrados() {
        System.out.println("\n=== LISTA DE PEDIDOS COBRADOS ===");
        List<Pedido_SIN_RESOLVER> pedidosCobrados = new ArrayList<>();
        for (Pedido_SIN_RESOLVER pedido : pedidos) {
            if (pedido.isEstado()) {
                pedidosCobrados.add(pedido);
            }
        }
        if (pedidosCobrados.isEmpty()) {
            System.out.println("No hay pedidos cobrados.");
        } else {
            for (int i = 0; i < pedidosCobrados.size(); i++) {
                System.out.println((i + 1) + ". " + pedidosCobrados.get(i));
            }
        }
        System.out.println();
    }
}

