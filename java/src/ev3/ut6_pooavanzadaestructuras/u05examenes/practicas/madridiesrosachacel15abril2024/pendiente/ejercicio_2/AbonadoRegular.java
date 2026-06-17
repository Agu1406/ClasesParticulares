package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.pendiente.ejercicio_2;

import java.util.HashSet;
import java.util.Set;

public class AbonadoRegular implements Abonado {

	private static int maximoActividades;

	private final String nif;
	private final String nombre;
	private final Set<Actividad> actividades = new HashSet<>();

	public static void configurarMaximo(int maximo) {
		maximoActividades = maximo;
	}

	public AbonadoRegular(String nif, String nombre) {
		this.nif = nif;
		this.nombre = nombre;
	}

	@Override
	public boolean registrarActividad() {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean cancelarActividad(String nombreActividad) {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public String getNif() {
		return nif;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public Set<Actividad> getActividades() {
		return actividades;
	}
}
