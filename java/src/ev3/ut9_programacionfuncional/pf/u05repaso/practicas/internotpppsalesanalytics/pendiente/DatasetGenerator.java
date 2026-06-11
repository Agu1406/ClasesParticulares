package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.pendiente;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Genera datos de prueba deterministas para el examen (semilla fija {@code 84}).
 * Usa {@link IntStream} para crear colecciones de clientes, productos y pedidos.
 */
public class DatasetGenerator {

	private static final Random rnd = new Random(84);

	private static final List<String> COUNTRIES = List.of(
			"Spain", "Germany", "France", "Italy", "UK", "USA");

	private static final List<String> CATEGORIES = List.of(
			"Electronics", "Books", "Clothing", "Home", "Sports", "Toys");

	/**
	 * Genera una lista de clientes aleatorios pero reproducibles.
	 *
	 * @param count numero de clientes a crear
	 * @return lista inmutable de clientes
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code IntStream.range(0, count)} — genera indices del 0 al count-1.</li>
	 *   <li>{@code mapToObj(...)} — transforma cada indice en un objeto {@link Customer}.</li>
	 *   <li>{@code toList()} — recoge los clientes en una lista inmutable.</li>
	 * </ul>
	 */
	public static List<Customer> generateCustomers(int count) {
		return IntStream.range(0, count)
				.mapToObj(i -> new Customer(
						"C" + i,
						"Customer-" + i,
						randomFrom(COUNTRIES),
						randomTier()))
				.toList();
	}

	/**
	 * Genera una lista de productos aleatorios pero reproducibles.
	 *
	 * @param count numero de productos a crear
	 * @return lista inmutable de productos
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code IntStream.range(0, count)} — genera indices del 0 al count-1.</li>
	 *   <li>{@code mapToObj(...)} — transforma cada indice en un objeto {@link Product}.</li>
	 *   <li>{@code toList()} — recoge los productos en una lista inmutable.</li>
	 * </ul>
	 */
	public static List<Product> generateProducts(int count) {
		return IntStream.range(0, count)
				.mapToObj(i -> new Product(
						"P" + i,
						"Product-" + i,
						randomFrom(CATEGORIES),
						randomPrice()))
				.toList();
	}

	/**
	 * Genera una lista de pedidos aleatorios asociados a clientes y productos existentes.
	 *
	 * @param count     numero de pedidos a crear
	 * @param customers lista de clientes disponibles para asignar a cada pedido
	 * @param products  lista de productos disponibles para las lineas de pedido
	 * @return lista inmutable de pedidos
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code IntStream.range(0, count)} — genera indices del 0 al count-1.</li>
	 *   <li>{@code mapToObj(...)} — transforma cada indice en un objeto {@link Order}.</li>
	 *   <li>{@code toList()} — recoge los pedidos en una lista inmutable.</li>
	 * </ul>
	 */
	public static List<Order> generateOrders(int count, List<Customer> customers, List<Product> products) {
		return IntStream.range(0, count)
				.mapToObj(i -> new Order(
						"O" + i,
						randomFrom(customers),
						generateItems(products),
						randomDate()))
				.toList();
	}

	/**
	 * Genera entre 1 y 5 lineas de pedido con productos y cantidades aleatorias.
	 *
	 * @param products catalogo de productos del que elegir
	 * @return lista inmutable de lineas de pedido
	 * <p>Operaciones de Stream utilizadas:
	 * <ul>
	 *   <li>{@code IntStream.range(0, itemsCount)} — genera tantos indices como lineas tenga el pedido.</li>
	 *   <li>{@code mapToObj(...)} — crea un {@link OrderItem} por cada indice.</li>
	 *   <li>{@code toList()} — recoge las lineas en una lista inmutable.</li>
	 * </ul>
	 */
	private static List<OrderItem> generateItems(List<Product> products) {
		int itemsCount = rnd.nextInt(1, 6);

		return IntStream.range(0, itemsCount)
				.mapToObj(i -> new OrderItem(
						randomFrom(products),
						rnd.nextInt(1, 4)))
				.toList();
	}

	/**
	 * @return nivel de cliente aleatorio con distribucion: 70% STANDARD, 20% PREMIUM, 10% VIP
	 */
	private static Tier randomTier() {
		double r = rnd.nextDouble();
		if (r < 0.7) {
			return Tier.STANDARD;
		}
		if (r < 0.9) {
			return Tier.PREMIUM;
		}
		return Tier.VIP;
	}

	/** @return precio aleatorio entre 5.0 y 1500.0 */
	private static double randomPrice() {
		return rnd.nextDouble(5, 1500);
	}

	/** @return fecha aleatoria dentro de los ultimos dos anos */
	private static LocalDateTime randomDate() {
		LocalDateTime start = LocalDateTime.now().minusYears(2);
		long days = rnd.nextLong(0, 730);
		return start.plusDays(days);
	}

	/**
	 * @param list lista de la que extraer un elemento
	 * @param <T>  tipo de elemento
	 * @return elemento elegido al azar de la lista
	 */
	private static <T> T randomFrom(List<T> list) {
		return list.get(rnd.nextInt(list.size()));
	}
}
