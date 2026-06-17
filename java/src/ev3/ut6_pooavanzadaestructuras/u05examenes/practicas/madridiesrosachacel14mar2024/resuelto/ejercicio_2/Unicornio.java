package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.resuelto.ejercicio_2;

/**
 * Unicornio con cuerno magico.
 */
public class Unicornio extends CriaturaMistica {

	private final double longitudCuerno;

	public Unicornio(String nombre, int edad, double longitudCuerno) {
		super(nombre, edad);
		this.longitudCuerno = longitudCuerno;
	}

	@Override
	public void describirCriatura() {
		System.out.println("Unicornio " + getNombre() + ", edad " + getEdad()
				+ ", cuerno de " + longitudCuerno + " cm");
	}

	@Override
	public void activarPoder() {
		System.out.println(getNombre() + " cura heridas con la luz de su cuerno.");
	}
}
