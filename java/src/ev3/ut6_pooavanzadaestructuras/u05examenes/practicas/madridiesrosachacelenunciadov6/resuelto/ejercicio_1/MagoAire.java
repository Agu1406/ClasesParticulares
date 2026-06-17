package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.resuelto.ejercicio_1;

/**
 * Mago que domina el aire y se caracteriza por la velocidad de su viento.
 */
public class MagoAire extends MagoElemental {

	private final double velocidadKmH;

	public MagoAire(String nombre, double velocidadKmH) {
		super(nombre);
		this.velocidadKmH = velocidadKmH;
	}

	@Override
	public void lanzarHechizo() {
		System.out.printf("%s lanza un hechizo de aire a %.0f Km/h%n", getNombre(), velocidadKmH);
	}
}
