package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_02_hardware;

public abstract class Componente {

	protected String modelo;
	protected int tdpMaximo;

	protected Componente(String modelo, int tdpMaximo) {
		this.modelo = modelo;
		this.tdpMaximo = tdpMaximo;
	}

	public String getModelo() {
		return modelo;
	}

	public int getTdpMaximo() {
		return tdpMaximo;
	}

	public abstract double calcularPuntuacionRendimiento();
}
