package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_01_conservatorio;

public class Cantante extends Interprete implements Vocalista {

	public Cantante(String nombreEstudiante) {
		super(nombreEstudiante);
	}

	@Override
	public void calentarVoz() {
		System.out.println(getNombreEstudiante() + ": Haciendo escalas graves...");
	}

	@Override
	public void interpretar(String titulo) {
		System.out.println(getNombreEstudiante() + ": Cantando el aria '" + titulo + "'...");
	}
}
