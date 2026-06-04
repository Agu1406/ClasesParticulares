package ev3.ut6.u04repaso.practicas.madridcesjuanpablosegundoext5;

/**
 * Clase principal con el metodo main para probar el sistema de gestion de pedidos
 */
public class Main_SIN_RESOLVER {
    public static void main(String[] args) {
        // Crear un restaurante con datos metidos a mano
        Restaurante_SIN_RESOLVER restaurante = new Restaurante_SIN_RESOLVER("Restaurante_SIN_RESOLVER El Buen Sabor", "B12345678");

        // Crear tres clientes con datos metidos a mano
        Cliente_SIN_RESOLVER cliente1 = new Cliente_SIN_RESOLVER("12345678A", "Juan Perez");
        Cliente_SIN_RESOLVER cliente2 = new Cliente_SIN_RESOLVER("87654321B", "Maria Garcia");
        Cliente_SIN_RESOLVER cliente3 = new Cliente_SIN_RESOLVER("11223344C", "Carlos Lopez");

        // Crear un pedido por cada uno de los tres clientes con productos
        Pedido_SIN_RESOLVER pedido1 = new Pedido_SIN_RESOLVER(cliente1);
        pedido1.addpedido(new Producto_SIN_RESOLVER("Coca-Cola", 2));
        pedido1.addpedido(new Producto_SIN_RESOLVER("Bocadillo de jamon", 4));
        pedido1.addpedido(new Producto_SIN_RESOLVER("Patatas fritas", 2));

        Pedido_SIN_RESOLVER pedido2 = new Pedido_SIN_RESOLVER(cliente2);
        pedido2.addpedido(new Producto_SIN_RESOLVER("Agua", 1));
        pedido2.addpedido(new Producto_SIN_RESOLVER("1er plato: Ensalada mixta", 6));
        pedido2.addpedido(new Producto_SIN_RESOLVER("2? plato: Pollo asado", 9));
        pedido2.addpedido(new Producto_SIN_RESOLVER("Postre: Tarta de chocolate", 4));

        Pedido_SIN_RESOLVER pedido3 = new Pedido_SIN_RESOLVER(cliente3);
        pedido3.addpedido(new Producto_SIN_RESOLVER("Cerveza", 3));
        pedido3.addpedido(new Producto_SIN_RESOLVER("Bocadillo de queso", 3));
        pedido3.addpedido(new Producto_SIN_RESOLVER("Cafe", 1));

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
        Pedido_SIN_RESOLVER pedido4 = new Pedido_SIN_RESOLVER(cliente3);
        pedido4.addpedido(new Producto_SIN_RESOLVER("Refresco", 2));
        restaurante.agregarpedido(pedido4); // Esto deberia dar error

        // Anadir un pedido nuevo al restaurante con el cliente que ya haya pagado su pedido (cliente2)
        System.out.println("\n=== ANADIENDO PEDIDO NUEVO CON CLIENTE2 (que ya pago) ===");
        Pedido_SIN_RESOLVER pedido5 = new Pedido_SIN_RESOLVER(cliente2);
        pedido5.addpedido(new Producto_SIN_RESOLVER("Menu del dia", 12));
        restaurante.agregarpedido(pedido5); // Esto deberia funcionar

        // Mostrar el valor de la caja
        System.out.println("\n=== VALOR DE LA CAJA ===");
        restaurante.mostrarcaja();
    }
}

