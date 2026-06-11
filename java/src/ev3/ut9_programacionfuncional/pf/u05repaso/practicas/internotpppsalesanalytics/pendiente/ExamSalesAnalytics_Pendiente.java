package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.pendiente;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>Enunciado: {@code interno-tpp-exam-sales-analytics.md} (carpeta de la practica).</p>
 * <p><b>OBJETIVO:</b> Implementar los ocho metodos de consulta usando Streams, lambdas
 * y {@code Predicate}. El modelo de datos y el generador ya estan facilitados.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ExamSalesAnalytics_Pendiente {

	/**
	 * Punto de entrada: genera el dataset de prueba y ejecuta los ocho ejercicios del examen.
	 * El ejercicio 8 requiere implementar {@link #getPredicate} y usarlo con
	 * {@code stream()}, {@code filter(...)}, {@code map(Order::getId)} y {@code toList()}.
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
	 * <p>Streams sugeridos: {@code stream()}, {@code filter(...)}, {@code map(orderRevenue)}
	 * y {@code reduce(0.0, Double::sum)}.
	 */
	private static double totalRevenueVIPCustomers(List<Order> orders) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><b>Exercise 2.</b> Comprueba si existe al menos un pedido que contenga algun producto de la categoria indicada.
	 *
	 * @param orders   lista de pedidos a analizar
	 * @param category nombre de la categoria buscada
	 * @return {@code true} si al menos un pedido incluye un producto de esa categoria
	 * <p>Streams sugeridos: {@code stream()} sobre pedidos, {@code anyMatch(...)} anidado con
	 * {@code stream()} y {@code anyMatch(...)} sobre las lineas de cada pedido.
	 */
	private static boolean anyOrderWhereCategoryIs(List<Order> orders, String category) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><b>Exercise 3.</b> Obtiene las categorias de producto distintas compradas por clientes {@link Tier#PREMIUM},
	 * ordenadas alfabeticamente.
	 *
	 * @param orders lista de pedidos a analizar
	 * @return lista de nombres de categoria unicos y ordenados
	 * <p>Streams sugeridos: {@code stream()}, {@code filter(...)}, {@code flatMap(...)},
	 * {@code map(...)}, {@code distinct()}, {@code sorted(...)} y {@code toList()}.
	 */
	private static List<String> uniqueCategoriesByPremiumCustomers(List<Order> orders) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><b>Exercise 4.</b> Devuelve los precios de los cinco productos mas caros que aparecen en los pedidos, sin repetir importes.
	 *
	 * @param orders lista de pedidos a analizar
	 * @return lista con hasta cinco precios ({@code double})
	 * <p>Streams sugeridos: {@code stream()}, {@code flatMap(...)}, {@code map(...)},
	 * {@code sorted(Comparator.comparing(...).reversed())}, {@code map(Product::getPrice)},
	 * {@code distinct()}, {@code limit(5)} y {@code toList()}.
	 */
	private static List<Double> topExpensiveProducts(List<Order> orders) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><b>Exercise 5.</b> Cuenta el total de unidades vendidas de productos de la categoria indicada.
	 *
	 * @param orders   lista de pedidos a analizar
	 * @param category nombre de la categoria
	 * @return numero total de unidades vendidas en esa categoria
	 * <p>Streams sugeridos: {@code stream()}, {@code flatMap(...)}, {@code filter(...)},
	 * {@code mapToInt(...)} y {@code sum()}.
	 */
	private static int totalProductsSoldInCategory(List<Order> orders, String category) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><b>Exercise 6.</b> Lista los nombres unicos de productos comprados por clientes del pais indicado.
	 *
	 * @param orders  lista de pedidos a analizar
	 * @param country nombre del pais del cliente
	 * @return lista de nombres de producto sin repeticiones
	 * <p>Streams sugeridos: {@code stream()}, {@code filter(...)}, {@code flatMap(...)},
	 * {@code map(...)}, {@code distinct()} y {@code toList()}.
	 */
	private static List<String> productsBoughtByCustomersFrom(List<Order> orders, String country) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><b>Exercise 7.</b> Calcula el ingreso total de todos los pedidos tras aplicar una funcion de descuento
	 * al ingreso de cada pedido.
	 *
	 * @param orders           lista de pedidos a analizar
	 * @param discountFunction funcion que aplica el descuento a un ingreso
	 * @return suma de ingresos con descuento
	 * <p>Streams sugeridos: {@code stream()}, {@code map(orderRevenue)}, {@code map(discountFunction)}
	 * y {@code reduce(0.0, Double::sum)}.
	 */
	private static double revenueWithDiscount(List<Order> orders, Function<Double, Double> discountFunction) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><b>Exercise 8.</b> Construye un {@link Predicate} para filtrar pedidos por nivel de cliente, pais e ingreso minimo.
	 *
	 * @param tier             nivel de cliente exigido
	 * @param country          pais del cliente exigido
	 * @param revenueThreshold ingreso minimo del pedido (estrictamente mayor)
	 * @return predicado reutilizable en {@code stream().filter(...)} del Exercise 8
	 * <p>No usa Stream internamente: devuelve una lambda que comprueba las tres condiciones.
	 * Se combina con {@code filter(...)} en el Stream de pedidos del {@code main}.
	 */
	private static Predicate<Order> getPredicate(Tier tier, String country, double revenueThreshold) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/** Calcula el ingreso de una linea de pedido: precio del producto multiplicado por la cantidad. */
	private static final Function<OrderItem, Double> itemRevenue =
			item -> item.getProduct().getPrice() * item.getQuantity();

	/**
	 * Calcula el ingreso total de un pedido sumando el ingreso de cada linea.
	 * <p>Operaciones de Stream ya utilizadas en esta funcion auxiliar (referencia):
	 * {@code stream()}, {@code map(itemRevenue)} y {@code reduce(0.0, Double::sum)}.
	 */
	private static final Function<Order, Double> orderRevenue =
			order -> order.getItems()
					.stream()
					.map(itemRevenue)
					.reduce(0.0, Double::sum);
}
