package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.pendiente.ejercicio_2;

import java.util.Set;

public interface Abonado {

	boolean registrarActividad();

	boolean cancelarActividad(String nombre);

	String getNif();

	String getNombre();

	Set<Actividad> getActividades();
}
