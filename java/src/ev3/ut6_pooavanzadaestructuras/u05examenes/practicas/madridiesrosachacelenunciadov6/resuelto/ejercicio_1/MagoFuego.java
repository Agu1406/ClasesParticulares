package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.resuelto.ejercicio_1;

/**
 * Mago que domina el fuego y se caracteriza por la superficie que puede incendiar.
 */
public class MagoFuego extends MagoElemental {

	private final double superficieKm2;

	public MagoFuego(String nombre, double superficieKm2) {
		super(nombre);
		this.superficieKm2 = superficieKm2;
	}

	@Override
	public void lanzarHechizo() {
		System.out.printf("%s lanza un hechizo de fuego sobre %.1f Km2%n", getNombre(), superficieKm2);
	}
}
