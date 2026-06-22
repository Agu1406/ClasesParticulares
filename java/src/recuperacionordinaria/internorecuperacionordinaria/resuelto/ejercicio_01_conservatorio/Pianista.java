package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_01_conservatorio;

public class Pianista extends Interprete implements Instrumentista {

	public Pianista(String nombreEstudiante) {
		super(nombreEstudiante);
	}

	@Override
	public void afinarInstrumento() {
		System.out.println(getNombreEstudiante() + ": Afinando piano...");
	}

	@Override
	public void interpretar(String titulo) {
		System.out.println(getNombreEstudiante() + ": Tocando la partitura '" + titulo + "'...");
	}
}
