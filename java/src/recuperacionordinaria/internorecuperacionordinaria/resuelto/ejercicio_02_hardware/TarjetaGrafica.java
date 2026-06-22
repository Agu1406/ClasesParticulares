package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_02_hardware;

public class TarjetaGrafica extends Componente {

	private final int vramGB;
	private final int tensorCores;

	public TarjetaGrafica(String modelo, int tdpMaximo, int vramGB, int tensorCores) {
		super(modelo, tdpMaximo);
		this.vramGB = vramGB;
		this.tensorCores = tensorCores;
	}

	@Override
	public double calcularPuntuacionRendimiento() {
		return (vramGB * 50) + (tensorCores * 2);
	}
}
