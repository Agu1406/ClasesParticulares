package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.resuelto.ejercicio_2;

/**
 * Base abstracta de las criaturas del mundo magico.
 */
public abstract class CriaturaMistica implements PoderMistico {

	private final String nombre;
	private final int edad;

	protected CriaturaMistica(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public abstract void describirCriatura();
}
