package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.resuelto;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>Intento parcial recuperado del examen (alumna). No compila del todo: conserva apuntes y
 * borradores comentados tal como se entregaron.</p>
 * <p>Referencia de correccion: {@link ExamSalesAnalytics_Resuelto}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class ExamSalesAnalytics_AlumnaParcial {

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

	/** <p><b>Exercise 1.</b> Total revenue VIP Customers.</p> */
	private static double totalRevenueVIPCustomers(List<Order> orders) {
		// TODO
		//si quiero el importe total de los vips me apoyo en orderRevenue
		//orders.stream()
		//		?????
		//		.filter(n -> n.VIP) //filtramos por los customer que son vip
		//		.forEach(n -> System.out.prinln(orderRevenue.apply(n));
		return 0; //242710
	}

	/** <p><b>Exercise 2.</b> Is there any order with products from a category.</p> */
	private static boolean anyOrderWhereCategoryIs(List<Order> orders, String category) {
		// TODO
		//Si quiero encontrar al menos un pedido con la categoria dada
		//orders.stream()
		//		?????
		//		.anyMatch(n -> n.getCategory == category);
		return false; //true
	}

	/** <p><b>Exercise 3.</b> Categories where PREMIUM customers buy.</p> */
	private static List<String> uniqueCategoriesByPremiumCustomers(List<Order> orders) {
		// TODO
		//si quiero devolver la lista de categorias sin repeticiones de los productos de los clientes vip
		//orders.stream()
		//		?????
		//		.filter(n -> n.getCategory == "PREMIUM" ) //filtro por las categorias
		//		.sorted(String::toLowerCase) //convierto todas las palabras en minuscula
		//		.distinct() //para eliminar repeticiones
		return null; //Casa, electronica, libros, deportes, ropa y juguetes en ingles
	}

	/** <p><b>Exercise 4.</b> Top most expensive products.</p> */
	private static List<Double> topExpensiveProducts(List<Order> orders) {
		// TODO
		//si quiero la lista de los nombres de los 5 mas caros sin repeticiones
		//orders.stream()
		//		?????
		//		.filter(Product::getName) //obtengo los nombres de los productos
		//		.sorted(Comparator.comparing(Product::getPrice) //ordeno por los mas caros
		//		.distinct() //elimino repetidos
		//		.limit(5) 	//me quedo con los 5 mayores
		return null; //60 27 93 78 12
	}

	/** <p><b>Exercise 5.</b> Total amount of products sold in a category.</p> */
	private static int totalProductsSoldInCategory(List<Order> orders, String category) {
		// TODO
		// si quiero el numero total en los pedidos de los productos de la categoria indicada
		//orders.stream()
		//		?????
		//		.filter(n -> n.getCategory == category)
		return 0; //1568
	}

	/** <p><b>Exercise 6.</b> Products bought by customers from a country.</p> */
	private static List<String> productsBoughtByCustomersFrom(List<Order> orders, String country) {
		// TODO
		//si quiero que devuelva una lista con los nombres ed los productos de los pedidos
		//en los que el cliente es del pais indicado
		return null;
	}

	/** <p><b>Exercise 7.</b> Total revenue considering a discount.</p> */
	private static double revenueWithDiscount(List<Order> orders, Function<Double, Double> discountFunction) {
		// TODO
		//si quiero obtener el importe total de los pedidos aplicando sobre el importe original
		//el descuento que se le pasa
		return 0;
	}

	/** <p><b>Exercise 8.</b> Predicate for filtering orders by tier, country and revenue.</p> */
	private static Predicate<Order> getPredicate(Tier tier, String country, double revenueThreshold) {
		// TODO
		//si quiero un predicado
		return null;
	}

	private static final Function<OrderItem, Double> itemRevenue =
			item -> item.getProduct().getPrice() * item.getQuantity();

	private static final Function<Order, Double> orderRevenue =
			order -> order.getItems()
					.stream()
					.map(itemRevenue)
					.reduce(0.0, Double::sum);
}
