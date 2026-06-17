package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Abonado regular con limite maximo de actividades.
 */
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
		if (actividades.size() >= maximoActividades) {
			return false;
		}

		Scanner teclado = new Scanner(System.in);
		Actividad actividad = leerActividad(teclado);
		if (actividades.contains(actividad)) {
			return false;
		}

		return actividades.add(actividad);
	}

	@Override
	public boolean cancelarActividad(String nombreActividad) {
		return actividades.removeIf(actividad -> actividad.getNombre().equalsIgnoreCase(nombreActividad));
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

	private Actividad leerActividad(Scanner teclado) {
		System.out.print("NOMBRE ACTIVIDAD: ");
		String nombreActividad = teclado.nextLine().trim();
		System.out.print("CUOTA: ");
		double cuota = Double.parseDouble(teclado.nextLine().trim().replace(',', '.'));
		System.out.print("DIAS SEMANA (ej. LMXV): ");
		String diasTexto = teclado.nextLine().trim();
		return new Actividad(nombreActividad, cuota, diasTexto.toCharArray());
	}
}
