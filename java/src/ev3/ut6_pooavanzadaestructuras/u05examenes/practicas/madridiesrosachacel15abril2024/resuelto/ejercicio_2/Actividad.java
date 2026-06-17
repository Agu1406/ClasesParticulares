package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_2;

import java.util.Objects;

/**
 * Actividad del gimnasio: nombre, cuota y dias de la semana.
 */
public class Actividad {

	private final String nombre;
	private final double cuota;
	private final char[] diasSemana;

	public Actividad(String nombre, double cuota, char[] diasSemana) {
		this.nombre = nombre;
		this.cuota = cuota;
		this.diasSemana = diasSemana;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCuota() {
		return cuota;
	}

	public char[] getDiasSemana() {
		return diasSemana;
	}

	public boolean tieneDia(char dia) {
		for (char diaActividad : diasSemana) {
			if (Character.toUpperCase(diaActividad) == Character.toUpperCase(dia)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object otro) {
		if (this == otro) {
			return true;
		}
		if (!(otro instanceof Actividad actividad)) {
			return false;
		}
		return Objects.equals(nombre, actividad.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
}
