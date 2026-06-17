package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_2;

import java.util.Set;

/**
 * Contrato de un abonado del gimnasio.
 */
public interface Abonado {

	boolean registrarActividad();

	boolean cancelarActividad(String nombre);

	String getNif();

	String getNombre();

	Set<Actividad> getActividades();
}
