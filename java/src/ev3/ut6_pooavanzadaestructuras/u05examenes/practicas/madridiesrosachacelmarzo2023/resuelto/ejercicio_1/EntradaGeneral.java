package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelmarzo2023.resuelto.ejercicio_1;

/**
 * Entrada general: codigo, precio y nombre del comprador.
 */
public class EntradaGeneral implements Entrada {

	private final int codigo;
	private final double precio;
	final String nombreComprador;

	public EntradaGeneral(int codigo, double precio, String nombreComprador) {
		this.codigo = codigo;
		this.precio = precio;
		this.nombreComprador = nombreComprador;
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
		return "EntradaGeneral [codigo=" + codigo + ", precio=" + precio
				+ ", nombreComprador=" + nombreComprador + "]";
	}
}
