package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.resuelto;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>Enunciado: {@code interno-tpp-exam-sales-analytics.md} (carpeta de la practica).</p>
 * <p><b>OBJETIVO:</b> Analizar pedidos de venta con programacion funcional: Streams, lambdas
 * y {@code Predicate}.</p>
 * <br>
 * <p><b>SOLUCION:</b> Cada ejercicio combina operaciones de Stream sobre pedidos, lineas de pedido
 * o productos. Se reutilizan {@code itemRevenue} y {@code orderRevenue} como funciones auxiliares.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ExamSalesAnalytics_Resuelto {

	/**
	 * Punto de entrada: genera el dataset de prueba y ejecuta los ocho ejercicios del examen,
	 * imprimiendo el resultado de cada consulta.
	 * <p>En el ejercicio 8 se usa directamente un Stream sobre la lista de pedidos:
	 * <ul>
	 *   <li>{@code stream()} — convierte la lista de pedidos en Stream.</li>
	 *   <li>{@code filter(getPredicate(...))} — conserva pedidos que cumplen tier, pais e ingreso minimo.</li>
	 *   <li>{@code map(Order::getId)} — extrae el identificador de cada pedido filtrado.</li>
	 *   <li>{@code toList()} — recoge los identificadores en una lista inmutable.</li>
	 * </ul>
	 *
	 * @param args argumentos de linea de comandos (no se utilizan)
	 */
	public static void main(String[] args) {
		List<Customer> customers = DatasetGenerator.generateCustomers(50);
		List<Product> products = DatasetGenerator.generateProducts(100);
		List<Order> orders = DatasetGenerator.generateOrders(1000, customers, products);

		System.out.format("Exercise 1\nTotal revenue VIP Customers: %.2f\n\n", totalRevenueVIPCustomers(orders));
		System.out.format("Exercise 2\nIs there any order with products from Electronics: %b\n\n",
				anyOrderWhereCategoryIs(orders, "Electronics"));
		System.out.format("Exercise 3\nCategories where PREMIUM custormers buy:\n %s\n\n",
				uniqueCategoriesByPremiumCustomers(orders));
		System.out.format("Exercise 4\nTop most expensive products:\n %s\n\n", topExpensiveProducts(orders));
		System.out.format("Exercise 5\nTotal amount of books sold: %d\n\n",
				totalProductsSoldInCategory(orders, "Books"));
		System.out.format("Exercise 6\nProducts bought by customer from Spain:\n %s\n\n",
				productsBoughtByCustomersFrom(orders, "Spain"));
		System.out.format("Exercise 7\nTotal revenue considering a 10%% discount: %.2f\n\n",
				revenueWithDiscount(orders, v -> v * 0.9));
		System.out.format(
				"Exercise 8\nOrders with a revenue greater then 5000 euros, from VIP customers from Spain:\n %s\n\n",
				orders.stream().filter(getPredicate(Tier.VIP, "Spain", 5000)).map(Order::getId).toList());
	}

	/**
	 * <p><b>Exercise 1.</b> Calcula el ingreso total acumulado de todos los pedidos cuyo cliente tiene nivel {@link Tier#VIP}.
	 *
	 * @param orders lista de pedidos a analizar
	 * @return suma de ingresos de los pedidos VIP
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code stream()} — convierte la lista de pedidos en un Stream secuencial.</li>
	 *   <li>{@code filter(...)} — descarta pedidos cuyo cliente no es VIP; conserva solo los que cumplen la condicion.</li>
	 *   <li>{@code map(orderRevenue)} — transforma cada pedido VIP en su ingreso total (funcion auxiliar).</li>
	 *   <li>{@code reduce(0.0, Double::sum)} — combina todos los ingresos en una unica suma, empezando desde 0.0.</li>
	 * </ul>
	 */
	private static double totalRevenueVIPCustomers(List<Order> orders) {
		return orders.stream()
				.filter(order -> order.getCustomer().getTier() == Tier.VIP)
				.map(orderRevenue)
				.reduce(0.0, Double::sum);
	}

	/**
	 * <p><b>Exercise 2.</b> Comprueba si existe al menos un pedido que contenga algun producto de la categoria indicada.
	 *
	 * @param orders   lista de pedidos a analizar
	 * @param category nombre de la categoria buscada (por ejemplo, {@code "Electronics"})
	 * @return {@code true} si al menos un pedido incluye un producto de esa categoria; {@code false} en caso contrario
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code stream()} (sobre pedidos) — recorre cada pedido de la lista.</li>
	 *   <li>{@code anyMatch(...)} (sobre pedidos) — devuelve {@code true} en cuanto encuentra un pedido que cumple la condicion interna.</li>
	 *   <li>{@code stream()} (sobre lineas) — dentro de cada pedido, recorre sus lineas de pedido.</li>
	 *   <li>{@code anyMatch(...)} (sobre lineas) — comprueba si alguna linea tiene un producto con la categoria buscada.</li>
	 * </ul>
	 */
	private static boolean anyOrderWhereCategoryIs(List<Order> orders, String category) {
		return orders.stream()
				.anyMatch(order -> order.getItems().stream()
						.anyMatch(item -> item.getProduct().getCategory().equals(category)));
	}

	/**
	 * <p><b>Exercise 3.</b> Obtiene las categorias de producto distintas compradas por clientes con nivel {@link Tier#PREMIUM},
	 * ordenadas alfabeticamente sin distinguir mayusculas de minusculas.
	 *
	 * @param orders lista de pedidos a analizar
	 * @return lista inmutable de nombres de categoria unicos y ordenados
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code stream()} — inicia el recorrido sobre la lista de pedidos.</li>
	 *   <li>{@code filter(...)} — conserva solo pedidos de clientes PREMIUM.</li>
	 *   <li>{@code flatMap(order -> order.getItems().stream())} — aplana cada pedido en sus lineas;
	 *       pasa de Stream de pedidos a Stream de lineas de pedido.</li>
	 *   <li>{@code map(...)} — extrae la categoria del producto de cada linea.</li>
	 *   <li>{@code distinct()} — elimina categorias repetidas.</li>
	 *   <li>{@code sorted(String.CASE_INSENSITIVE_ORDER)} — ordena alfabeticamente ignorando mayusculas.</li>
	 *   <li>{@code toList()} — materializa el resultado en una lista inmutable.</li>
	 * </ul>
	 */
	private static List<String> uniqueCategoriesByPremiumCustomers(List<Order> orders) {
		return orders.stream()
				.filter(order -> order.getCustomer().getTier() == Tier.PREMIUM)
				.flatMap(order -> order.getItems().stream())
				.map(item -> item.getProduct().getCategory())
				.distinct()
				.sorted(String.CASE_INSENSITIVE_ORDER)
				.toList();
	}

	/**
	 * <p><b>Exercise 4.</b> Devuelve los precios de los cinco productos mas caros que aparecen en los pedidos,
	 * sin repetir importes aunque el mismo producto figure en varios pedidos.
	 *
	 * @param orders lista de pedidos a analizar
	 * @return lista con hasta cinco precios ({@code double}), del mas alto al mas bajo dentro de ese top
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code stream()} — recorre la lista de pedidos.</li>
	 *   <li>{@code flatMap(...)} — convierte cada pedido en el Stream de sus lineas; unifica todas las lineas en un solo Stream.</li>
	 *   <li>{@code map(OrderItem::getProduct)} — obtiene el producto de cada linea.</li>
	 *   <li>{@code sorted(Comparator.comparing(Product::getPrice).reversed())} — ordena productos por precio descendente
	 *       (el mas caro primero).</li>
	 *   <li>{@code map(Product::getPrice)} — extrae el precio de cada producto ya ordenado.</li>
	 *   <li>{@code distinct()} — elimina precios duplicados conservando el primero (el de mayor valor).</li>
	 *   <li>{@code limit(5)} — se queda solo con los cinco primeros elementos del Stream.</li>
	 *   <li>{@code toList()} — recoge el resultado en una lista inmutable.</li>
	 * </ul>
	 */
	private static List<Double> topExpensiveProducts(List<Order> orders) {
		return orders.stream()
				.flatMap(order -> order.getItems().stream())
				.map(OrderItem::getProduct)
				.sorted(Comparator.comparing(Product::getPrice).reversed())
				.map(Product::getPrice)
				.distinct()
				.limit(5)
				.toList();
	}

	/**
	 * <p><b>Exercise 5.</b> Cuenta el total de unidades vendidas de productos pertenecientes a la categoria indicada,
	 * sumando las cantidades de todas las lineas de pedido que coinciden.
	 *
	 * @param orders   lista de pedidos a analizar
	 * @param category nombre de la categoria cuyas unidades vendidas se quieren contar
	 * @return numero total de unidades vendidas en esa categoria
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code stream()} — inicia el recorrido sobre los pedidos.</li>
	 *   <li>{@code flatMap(...)} — aplana todos los pedidos en un Stream unico de lineas de pedido.</li>
	 *   <li>{@code filter(...)} — conserva solo lineas cuyo producto pertenece a la categoria indicada.</li>
	 *   <li>{@code mapToInt(OrderItem::getQuantity)} — convierte cada linea en un valor primitivo {@code int}
	 *       (la cantidad vendida), obteniendo un {@code IntStream}.</li>
	 *   <li>{@code sum()} — suma todas las cantidades del {@code IntStream} y devuelve el total.</li>
	 * </ul>
	 */
	private static int totalProductsSoldInCategory(List<Order> orders, String category) {
		return orders.stream()
				.flatMap(order -> order.getItems().stream())
				.filter(item -> item.getProduct().getCategory().equals(category))
				.mapToInt(OrderItem::getQuantity)
				.sum();
	}

	/**
	 * <p><b>Exercise 6.</b> Lista los nombres unicos de productos comprados por clientes del pais indicado.
	 *
	 * @param orders  lista de pedidos a analizar
	 * @param country nombre del pais del cliente (por ejemplo, {@code "Spain"})
	 * @return lista inmutable de nombres de producto sin repeticiones
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code stream()} — recorre la lista de pedidos.</li>
	 *   <li>{@code filter(...)} — conserva pedidos cuyo cliente es del pais indicado.</li>
	 *   <li>{@code flatMap(...)} — aplana cada pedido filtrado en sus lineas de pedido.</li>
	 *   <li>{@code map(...)} — extrae el nombre del producto de cada linea.</li>
	 *   <li>{@code distinct()} — elimina nombres de producto repetidos.</li>
	 *   <li>{@code toList()} — recoge el resultado en una lista inmutable.</li>
	 * </ul>
	 */
	private static List<String> productsBoughtByCustomersFrom(List<Order> orders, String country) {
		return orders.stream()
				.filter(order -> order.getCustomer().getCountry().equals(country))
				.flatMap(order -> order.getItems().stream())
				.map(item -> item.getProduct().getName())
				.distinct()
				.toList();
	}

	/**
	 * <p><b>Exercise 7.</b> Calcula el ingreso total de todos los pedidos tras aplicar una funcion de descuento
	 * al ingreso individual de cada pedido.
	 *
	 * @param orders           lista de pedidos a analizar
	 * @param discountFunction funcion que transforma el ingreso bruto de un pedido en el ingreso con descuento
	 * @return suma de ingresos con descuento de todos los pedidos
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code stream()} — convierte la lista de pedidos en Stream.</li>
	 *   <li>{@code map(orderRevenue)} — calcula el ingreso bruto de cada pedido.</li>
	 *   <li>{@code map(discountFunction)} — aplica el descuento a cada ingreso bruto.</li>
	 *   <li>{@code reduce(0.0, Double::sum)} — suma todos los ingresos con descuento en un unico valor.</li>
	 * </ul>
	 */
	private static double revenueWithDiscount(List<Order> orders, Function<Double, Double> discountFunction) {
		return orders.stream()
				.map(orderRevenue)
				.map(discountFunction)
				.reduce(0.0, Double::sum);
	}

	/**
	 * <p><b>Exercise 8.</b> Construye un predicado reutilizable para filtrar pedidos que cumplan simultaneamente:
	 * nivel de cliente, pais del cliente e ingreso del pedido superior a un umbral.
	 *
	 * @param tier             nivel de cliente exigido ({@link Tier#STANDARD}, {@link Tier#PREMIUM} o {@link Tier#VIP})
	 * @param country          pais del cliente exigido
	 * @param revenueThreshold ingreso minimo del pedido (exclusivo: debe ser estrictamente mayor)
	 * @return {@link Predicate} que evalua las tres condiciones sobre un {@link Order};
	 *         se usa habitualmente con {@code stream().filter(...)} del Exercise 8
	 * <p>Esta funcion no usa Stream internamente: devuelve una lambda {@link Predicate} que comprueba
	 * el tier del cliente, su pais y el ingreso calculado con {@code orderRevenue.apply(order)}.
	 * Al pasarla a {@code filter(...)} en un Stream de pedidos, solo atraviesan el filtro los que cumplen
	 * las tres condiciones a la vez.
	 */
	private static Predicate<Order> getPredicate(Tier tier, String country, double revenueThreshold) {
		return order -> order.getCustomer().getTier() == tier
				&& order.getCustomer().getCountry().equals(country)
				&& orderRevenue.apply(order) > revenueThreshold;
	}

	/** Calcula el ingreso de una linea de pedido: precio del producto multiplicado por la cantidad. */
	private static final Function<OrderItem, Double> itemRevenue =
			item -> item.getProduct().getPrice() * item.getQuantity();

	/**
	 * Calcula el ingreso total de un pedido sumando el ingreso de cada linea.
	 * <p>Operaciones de Stream utilizadas en esta funcion auxiliar:
	 * <ul>
	 *   <li>{@code stream()} — sobre la lista de lineas del pedido, crea un Stream de {@link OrderItem}.</li>
	 *   <li>{@code map(itemRevenue)} — transforma cada linea en su ingreso ({@code double}).</li>
	 *   <li>{@code reduce(0.0, Double::sum)} — acumula todos los ingresos en una unica suma.</li>
	 * </ul>
	 */
	private static final Function<Order, Double> orderRevenue =
			order -> order.getItems()
					.stream()
					.map(itemRevenue)
					.reduce(0.0, Double::sum);
}
