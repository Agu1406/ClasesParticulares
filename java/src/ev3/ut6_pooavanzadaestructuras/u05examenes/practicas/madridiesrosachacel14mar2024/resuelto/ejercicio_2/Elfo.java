package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.resuelto.ejercicio_2;

/**
 * Elfo silvano con gran agilidad.
 */
public class Elfo extends CriaturaMistica {

	private final int agilidad;

	public Elfo(String nombre, int edad, int agilidad) {
		super(nombre, edad);
		this.agilidad = agilidad;
	}

	@Override
	public void describirCriatura() {
		System.out.println("Elfo " + getNombre() + ", edad " + getEdad() + ", agilidad: " + agilidad);
	}

	@Override
	public void activarPoder() {
		System.out.println(getNombre() + " se camufla entre los arboles del bosque.");
	}
}
