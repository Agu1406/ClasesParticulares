package madrid.cesjuanpablosegundo.EX_T5;

/**
 * Clase principal con el método main para probar el sistema de gestión de pedidos
 */
public class Main {
    public static void main(String[] args) {
        // Crear un restaurante con datos metidos a mano
        Restaurante restaurante = new Restaurante("Restaurante El Buen Sabor", "B12345678");

        // Crear tres clientes con datos metidos a mano
        Cliente cliente1 = new Cliente("12345678A", "Juan Pérez");
        Cliente cliente2 = new Cliente("87654321B", "María García");
        Cliente cliente3 = new Cliente("11223344C", "Carlos López");

        // Crear un pedido por cada uno de los tres clientes con productos
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.addpedido(new Producto("Coca-Cola", 2));
        pedido1.addpedido(new Producto("Bocadillo de jamón", 4));
        pedido1.addpedido(new Producto("Patatas fritas", 2));

        Pedido pedido2 = new Pedido(cliente2);
        pedido2.addpedido(new Producto("Agua", 1));
        pedido2.addpedido(new Producto("1er plato: Ensalada mixta", 6));
        pedido2.addpedido(new Producto("2º plato: Pollo asado", 9));
        pedido2.addpedido(new Producto("Postre: Tarta de chocolate", 4));

        Pedido pedido3 = new Pedido(cliente3);
        pedido3.addpedido(new Producto("Cerveza", 3));
        pedido3.addpedido(new Producto("Bocadillo de queso", 3));
        pedido3.addpedido(new Producto("Café", 1));

        // Añadir los pedidos al restaurante
        System.out.println("=== AÑADIENDO PEDIDOS ===");
        restaurante.agregarpedido(pedido1);
        restaurante.agregarpedido(pedido2);
        restaurante.agregarpedido(pedido3);

        // Cobrar los pedidos de dos de los clientes (cliente1, cliente2)
        System.out.println("\n=== COBRANDO PEDIDOS ===");
        restaurante.cobrarpedido(cliente1.getDni());
        restaurante.cobrarpedido(cliente2.getDni());

        // Mostrar la lista de todos los pedidos del restaurante
        restaurante.mostrarTodosLosPedidos();

        // Mostrar la lista de todos los pedidos que han sido cobrados
        restaurante.mostrarPedidosCobrados();

        // Añadir un pedido nuevo al restaurante con el cliente que todavía no ha pagado su pedido (cliente3)
        System.out.println("=== INTENTANDO AÑADIR PEDIDO NUEVO CON CLIENTE3 (que no ha pagado) ===");
        Pedido pedido4 = new Pedido(cliente3);
        pedido4.addpedido(new Producto("Refresco", 2));
        restaurante.agregarpedido(pedido4); // Esto debería dar error

        // Añadir un pedido nuevo al restaurante con el cliente que ya haya pagado su pedido (cliente2)
        System.out.println("\n=== AÑADIENDO PEDIDO NUEVO CON CLIENTE2 (que ya pagó) ===");
        Pedido pedido5 = new Pedido(cliente2);
        pedido5.addpedido(new Producto("Menú del día", 12));
        restaurante.agregarpedido(pedido5); // Esto debería funcionar

        // Mostrar el valor de la caja
        System.out.println("\n=== VALOR DE LA CAJA ===");
        restaurante.mostrarcaja();
    }
}

