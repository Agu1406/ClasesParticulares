package madrid.cesjuanpablosegundo.EX_T5;

/**
 * Clase principal con el metodo main para probar el sistema de gestion de pedidos
 */
public class Main {
    public static void main(String[] args) {
        // Crear un restaurante con datos metidos a mano
        Restaurante restaurante = new Restaurante("Restaurante El Buen Sabor", "B12345678");

        // Crear tres clientes con datos metidos a mano
        Cliente cliente1 = new Cliente("12345678A", "Juan Perez");
        Cliente cliente2 = new Cliente("87654321B", "Maria Garcia");
        Cliente cliente3 = new Cliente("11223344C", "Carlos Lopez");

        // Crear un pedido por cada uno de los tres clientes con productos
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.addpedido(new Producto("Coca-Cola", 2));
        pedido1.addpedido(new Producto("Bocadillo de jamon", 4));
        pedido1.addpedido(new Producto("Patatas fritas", 2));

        Pedido pedido2 = new Pedido(cliente2);
        pedido2.addpedido(new Producto("Agua", 1));
        pedido2.addpedido(new Producto("1er plato: Ensalada mixta", 6));
        pedido2.addpedido(new Producto("2? plato: Pollo asado", 9));
        pedido2.addpedido(new Producto("Postre: Tarta de chocolate", 4));

        Pedido pedido3 = new Pedido(cliente3);
        pedido3.addpedido(new Producto("Cerveza", 3));
        pedido3.addpedido(new Producto("Bocadillo de queso", 3));
        pedido3.addpedido(new Producto("Cafe", 1));

        // Anadir los pedidos al restaurante
        System.out.println("=== ANADIENDO PEDIDOS ===");
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

        // Anadir un pedido nuevo al restaurante con el cliente que todavia no ha pagado su pedido (cliente3)
        System.out.println("=== INTENTANDO ANADIR PEDIDO NUEVO CON CLIENTE3 (que no ha pagado) ===");
        Pedido pedido4 = new Pedido(cliente3);
        pedido4.addpedido(new Producto("Refresco", 2));
        restaurante.agregarpedido(pedido4); // Esto deberia dar error

        // Anadir un pedido nuevo al restaurante con el cliente que ya haya pagado su pedido (cliente2)
        System.out.println("\n=== ANADIENDO PEDIDO NUEVO CON CLIENTE2 (que ya pago) ===");
        Pedido pedido5 = new Pedido(cliente2);
        pedido5.addpedido(new Producto("Menu del dia", 12));
        restaurante.agregarpedido(pedido5); // Esto deberia funcionar

        // Mostrar el valor de la caja
        System.out.println("\n=== VALOR DE LA CAJA ===");
        restaurante.mostrarcaja();
    }
}

