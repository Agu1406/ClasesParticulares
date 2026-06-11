package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.pendiente;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Representa un pedido completo. Es el elemento principal sobre el que se aplica
 * {@code orders.stream()} en la mayoria de ejercicios del examen.
 */
public class Order {

	private String id;
	private Customer customer;
	private List<OrderItem> items;
	private LocalDateTime orderDate;

	/**
	 * Crea un pedido con todos sus datos.
	 *
	 * @param id        identificador unico del pedido
	 * @param customer  cliente que realiza el pedido
	 * @param items     lineas de pedido (productos y cantidades)
	 * @param orderDate fecha y hora en que se registro el pedido
	 */
	public Order(String id, Customer customer, List<OrderItem> items, LocalDateTime orderDate) {
		this.id = id;
		this.customer = customer;
		this.items = items;
		this.orderDate = orderDate;
	}

	/**
	 * @return identificador del pedido; se extrae en el ejercicio 8 con {@code map(Order::getId)}
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return cliente del pedido; se consulta en filtros para obtener {@code country} y {@code tier}
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return lineas del pedido; se convierten en Stream con {@code order.getItems().stream()}
	 *         dentro de {@code flatMap(...)} para analizar productos individuales
	 */
	public List<OrderItem> getItems() {
		return items;
	}

	/** @return fecha y hora del pedido */
	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	/** @return representacion legible del pedido para depuracion */
	@Override
	public String toString() {
		return String.format("Order [id=%s, customer=%s, items=%s, orderDate=%s]", id, customer, items, orderDate);
	}
}
