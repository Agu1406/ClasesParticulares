package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.pendiente;

/**
 * Representa un cliente que realiza pedidos. Sus atributos {@code country} y {@code tier}
 * se consultan habitualmente con {@code filter(...)} al analizar pedidos con Streams.
 */
public class Customer {

	private String id;
	private String name;
	private String country;
	private Tier tier;

	/**
	 * Crea un cliente con todos sus datos.
	 *
	 * @param id      identificador unico del cliente
	 * @param name    nombre del cliente
	 * @param country pais de residencia del cliente
	 * @param tier    nivel de fidelizacion del cliente
	 */
	public Customer(String id, String name, String country, Tier tier) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.tier = tier;
	}

	/** @return identificador unico del cliente */
	public String getId() {
		return id;
	}

	/** @return nombre del cliente */
	public String getName() {
		return name;
	}

	/**
	 * @return pais del cliente; se compara en filtros como
	 *         {@code filter(order -> order.getCustomer().getCountry().equals(country))}
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return nivel del cliente; se compara en filtros como
	 *         {@code filter(order -> order.getCustomer().getTier() == Tier.VIP)}
	 */
	public Tier getTier() {
		return tier;
	}

	/** @return representacion legible del cliente para depuracion */
	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, country=%s, tier=%s]", id, name, country, tier);
	}
}
