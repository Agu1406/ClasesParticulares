package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelmarzo2023.resuelto.ejercicio_1;

/**
 * Entrada VIP: codigo, precio, nombre del comprador y butaca asignada.
 */
public class EntradaVIP implements Entrada {

	private final int codigo;
	private final double precio;
	final String nombreComprador;
	private final String butaca;

	public EntradaVIP(int codigo, double precio, String nombreComprador, String butaca) {
		this.codigo = codigo;
		this.precio = precio;
		this.nombreComprador = nombreComprador;
		this.butaca = butaca;
	}

	@Override
	public boolean comprobarEntrada(int cod) {
		return codigo == cod;
	}

	@Override
	public double devolverPrecioEntrada() {
		return precio;
	}

	@Override
	public String toString() {
		return "EntradaVIP [codigo=" + codigo + ", precio=" + precio
				+ ", nombreComprador=" + nombreComprador + ", butaca=" + butaca + "]";
	}
}
