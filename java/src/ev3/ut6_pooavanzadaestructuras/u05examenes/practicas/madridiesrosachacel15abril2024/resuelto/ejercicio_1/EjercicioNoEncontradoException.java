package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_1;

/**
 * No hay apuntes economicos en el ejercicio (anio) indicado.
 */
public class EjercicioNoEncontradoException extends Exception {

	public EjercicioNoEncontradoException(int ejercicio) {
		super("No hay ningun apunte economico en el ejercicio " + ejercicio);
	}
}
