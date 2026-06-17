package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.pendiente.ejercicio_2;

public class Particula {

	private final int carga;
	private final double masa;
	private final Punto posicion;

	public Particula(int carga, double masa, Punto posicion) {
		this.carga = carga;
		this.masa = masa;
		this.posicion = posicion;
	}

	public int getCarga() {
		return carga;
	}

	public double getMasa() {
		return masa;
	}

	public Punto getPosicion() {
		return posicion;
	}

	@Override
	public String toString() {
		return "Particula{carga=" + carga + ", masa=" + masa + ", posicion=" + posicion + "}";
	}
}
