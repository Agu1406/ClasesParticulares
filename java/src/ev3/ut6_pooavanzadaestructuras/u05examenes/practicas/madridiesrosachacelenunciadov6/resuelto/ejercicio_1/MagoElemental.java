package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.resuelto.ejercicio_1;

/**
 * Mago base de la escuela: todos tienen nombre y pueden lanzar un hechizo.
 */
public abstract class MagoElemental {

	private final String nombre;

	protected MagoElemental(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Lanza el hechizo propio del tipo concreto de mago.
	 */
	public abstract void lanzarHechizo();
}
