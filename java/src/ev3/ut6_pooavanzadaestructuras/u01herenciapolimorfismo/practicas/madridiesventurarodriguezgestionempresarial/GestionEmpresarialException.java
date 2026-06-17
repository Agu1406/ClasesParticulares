package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

/**
 * Excepcion comprobada para reglas de negocio del sistema de empleados.
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.</p>
 *
 * <p>Debe capturarse con {@code try-catch} o declararse con {@code throws}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class GestionEmpresarialException extends Exception {

	public GestionEmpresarialException(String mensaje) {
		super(mensaje);
	}
}
