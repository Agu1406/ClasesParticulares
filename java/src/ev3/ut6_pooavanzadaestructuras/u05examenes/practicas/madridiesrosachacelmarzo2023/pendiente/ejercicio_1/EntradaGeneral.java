package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelmarzo2023.pendiente.ejercicio_1;

public class EntradaGeneral implements Entrada {

	private final int codigo;
	private final double precio;
	private final String nombreComprador;

	public EntradaGeneral(int codigo, double precio, String nombreComprador) {
		this.codigo = codigo;
		this.precio = precio;
		this.nombreComprador = nombreComprador;
	}

	@Override
	public boolean comprobarEntrada(int cod) {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public double devolverPrecioEntrada() {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		// TODO
		throw new UnsupportedOperationException();
	}
}
