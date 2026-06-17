package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelmarzo2023.pendiente.ejercicio_1;

public class EntradaVIP implements Entrada {

	private final int codigo;
	private final double precio;
	private final String nombreComprador;
	private final String butaca;

	public EntradaVIP(int codigo, double precio, String nombreComprador, String butaca) {
		this.codigo = codigo;
		this.precio = precio;
		this.nombreComprador = nombreComprador;
		this.butaca = butaca;
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
