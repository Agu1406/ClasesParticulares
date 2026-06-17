package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.resuelto.ejercicio_3;

/**
 * Planta para catalogacion botanica.
 */
public class Planta implements Comparable<Planta> {

	private final String nombreCientifico;
	private final double alturaMaxima;

	public Planta(String nombreCientifico, double alturaMaxima) {
		this.nombreCientifico = nombreCientifico;
		this.alturaMaxima = alturaMaxima;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public double getAlturaMaxima() {
		return alturaMaxima;
	}

	@Override
	public int compareTo(Planta otra) {
		return Double.compare(this.alturaMaxima, otra.alturaMaxima);
	}

	@Override
	public String toString() {
		return nombreCientifico + " - " + alturaMaxima + " m";
	}
}
