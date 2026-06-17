package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelmarzo2023.resuelto.ejercicio_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Concierto: grupo, precios, entradas vendidas y codigos disponibles.
 */
public class Concierto {

	private final String nombreGrupo;
	private final double precioEntradaGeneral;
	private final double precioEntradaVip;
	private final Set<Entrada> entradasVendidas = new HashSet<>();
	private final List<Integer> codigosPosibles;

	public Concierto(String nombreGrupo, double precioEntradaGeneral, double precioEntradaVip,
			List<Integer> codigosPosibles) {
		this.nombreGrupo = nombreGrupo;
		this.precioEntradaGeneral = precioEntradaGeneral;
		this.precioEntradaVip = precioEntradaVip;
		this.codigosPosibles = new ArrayList<>(codigosPosibles);
	}

	String getNombreGrupo() {
		return nombreGrupo;
	}

	double getPrecioEntradaGeneral() {
		return precioEntradaGeneral;
	}

	double getPrecioEntradaVip() {
		return precioEntradaVip;
	}

	Set<Entrada> getEntradasVendidas() {
		return entradasVendidas;
	}

	List<Integer> getCodigosPosibles() {
		return codigosPosibles;
	}
}
