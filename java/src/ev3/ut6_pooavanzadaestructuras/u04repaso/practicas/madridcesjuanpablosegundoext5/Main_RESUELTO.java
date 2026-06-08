package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridcesjuanpablosegundoext5;

/**
 * Clase principal con el metodo main para probar el sistema de gestion de pedidos
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class Main_RESUELTO {
    public static void main(String[] args) {
        // Crear un restaurante con datos metidos a mano
        Restaurante_RESUELTO restaurante = new Restaurante_RESUELTO("Restaurante_RESUELTO El Buen Sabor", "B12345678");

        // Crear tres clientes con datos metidos a mano
        Cliente_RESUELTO cliente1 = new Cliente_RESUELTO("12345678A", "Juan Perez");
        Cliente_RESUELTO cliente2 = new Cliente_RESUELTO("87654321B", "Maria Garcia");
        Cliente_RESUELTO cliente3 = new Cliente_RESUELTO("11223344C", "Carlos Lopez");

        // Crear un pedido por cada uno de los tres clientes con productos
        Pedido_RESUELTO pedido1 = new Pedido_RESUELTO(cliente1);
        pedido1.addpedido(new Producto_RESUELTO("Coca-Cola", 2));
        pedido1.addpedido(new Producto_RESUELTO("Bocadillo de jamon", 4));
        pedido1.addpedido(new Producto_RESUELTO("Patatas fritas", 2));

        Pedido_RESUELTO pedido2 = new Pedido_RESUELTO(cliente2);
        pedido2.addpedido(new Producto_RESUELTO("Agua", 1));
        pedido2.addpedido(new Producto_RESUELTO("1er plato: Ensalada mixta", 6));
        pedido2.addpedido(new Producto_RESUELTO("2? plato: Pollo asado", 9));
        pedido2.addpedido(new Producto_RESUELTO("Postre: Tarta de chocolate", 4));

        Pedido_RESUELTO pedido3 = new Pedido_RESUELTO(cliente3);
        pedido3.addpedido(new Producto_RESUELTO("Cerveza", 3));
        pedido3.addpedido(new Producto_RESUELTO("Bocadillo de queso", 3));
        pedido3.addpedido(new Producto_RESUELTO("Cafe", 1));

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
        Pedido_RESUELTO pedido4 = new Pedido_RESUELTO(cliente3);
        pedido4.addpedido(new Producto_RESUELTO("Refresco", 2));
        restaurante.agregarpedido(pedido4); // Esto deberia dar error

        // Anadir un pedido nuevo al restaurante con el cliente que ya haya pagado su pedido (cliente2)
        System.out.println("\n=== ANADIENDO PEDIDO NUEVO CON CLIENTE2 (que ya pago) ===");
        Pedido_RESUELTO pedido5 = new Pedido_RESUELTO(cliente2);
        pedido5.addpedido(new Producto_RESUELTO("Menu del dia", 12));
        restaurante.agregarpedido(pedido5); // Esto deberia funcionar

        // Mostrar el valor de la caja
        System.out.println("\n=== VALOR DE LA CAJA ===");
        restaurante.mostrarcaja();
    }
}

