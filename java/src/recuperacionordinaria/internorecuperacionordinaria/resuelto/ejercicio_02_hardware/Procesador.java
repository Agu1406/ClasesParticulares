package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_02_hardware;

public class Procesador extends Componente {

	private final int numeroNucleos;
	private final double frecuenciaGhz;

	public Procesador(String modelo, int tdpMaximo, int numeroNucleos, double frecuenciaGhz) {
		super(modelo, tdpMaximo);
		this.numeroNucleos = numeroNucleos;
		this.frecuenciaGhz = frecuenciaGhz;
	}

	@Override
	public double calcularPuntuacionRendimiento() {
		return numeroNucleos * frecuenciaGhz * 100;
	}
}
