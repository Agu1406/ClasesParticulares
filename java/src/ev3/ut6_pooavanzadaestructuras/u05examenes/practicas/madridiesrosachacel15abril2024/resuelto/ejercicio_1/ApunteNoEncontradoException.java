package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_1;

/**
 * El apunte economico solicitado no existe en el HashMap.
 */
public class ApunteNoEncontradoException extends Exception {

	public ApunteNoEncontradoException(int code) {
		super("No se ha encontrado ningun apunte con el code " + code);
	}
}
