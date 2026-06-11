package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.pendiente;

/**
 * Representa una linea de pedido: un producto y la cantidad comprada.
 * En Streams se aplana con {@code flatMap(order -> order.getItems().stream())}
 * para pasar de pedidos a lineas individuales.
 */
public class OrderItem {

	private Product product;
	private int quantity;

	/**
	 * Crea una linea de pedido.
	 *
	 * @param product  producto comprado
	 * @param quantity unidades compradas de ese producto
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return producto de la linea; se extrae en Streams con {@code map(OrderItem::getProduct)}
	 *         o se accede a su categoria/nombre/precio desde ahi
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return cantidad comprada; se suma con {@code mapToInt(OrderItem::getQuantity).sum()}
	 *         para contar unidades vendidas por categoria
	 */
	public int getQuantity() {
		return quantity;
	}

	/** @return representacion legible de la linea de pedido para depuracion */
	@Override
	public String toString() {
		return String.format("OrderItem [product=%s, quantity=%s]", product, quantity);
	}
}
