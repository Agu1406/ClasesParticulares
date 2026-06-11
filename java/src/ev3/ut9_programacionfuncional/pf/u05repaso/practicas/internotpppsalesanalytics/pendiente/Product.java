package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.pendiente;

/**
 * Representa un producto del catalogo. Sus atributos {@code category}, {@code name} y {@code price}
 * se extraen con {@code map(...)} y se ordenan con {@code sorted(...)} en las consultas del examen.
 */
public class Product {

	private String id;
	private String name;
	private String category;
	private double price;

	/**
	 * Crea un producto con todos sus datos.
	 *
	 * @param id       identificador unico del producto
	 * @param name     nombre comercial del producto
	 * @param category categoria a la que pertenece (por ejemplo, {@code "Books"})
	 * @param price    precio unitario del producto
	 */
	public Product(String id, String name, String category, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	/** @return identificador unico del producto */
	public String getId() {
		return id;
	}

	/**
	 * @return nombre del producto; se obtiene en Streams con {@code map(Product::getName)}
	 *         o {@code map(item -> item.getProduct().getName())}
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return categoria del producto; se filtra con {@code filter(...)}
	 *         comparando {@code item.getProduct().getCategory().equals(category)}
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return precio unitario; se usa en ordenaciones como
	 *         {@code sorted(Comparator.comparing(Product::getPrice).reversed())}
	 */
	public double getPrice() {
		return price;
	}

	/** @return representacion legible del producto para depuracion */
	@Override
	public String toString() {
		return String.format("Product [id=%s, name=%s, category=%s, price=%s]", id, name, category, price);
	}
}
