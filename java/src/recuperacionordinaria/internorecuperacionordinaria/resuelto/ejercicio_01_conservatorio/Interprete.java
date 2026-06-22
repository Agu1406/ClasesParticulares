package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_01_conservatorio;

/**
 * Clase abstracta base de un intérprete del conservatorio.
 */
public abstract class Interprete {

	private final String nombreEstudiante;

	protected Interprete(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public abstract void interpretar(String titulo);

	public void saludar() {
		System.out.println("Hola, soy " + nombreEstudiante + ".");
	}
}
