package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.pendiente.ejercicio_1;

public class ApunteNoEncontradoException extends Exception {

	public ApunteNoEncontradoException(int code) {
		super("No se ha encontrado ningun apunte con el code " + code);
	}
}
