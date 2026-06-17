package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Clase abstracta padre: datos comunes de cualquier persona en el sistema.
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.
 * Solucion de referencia en {@code Persona_RESUELTO.java}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public abstract class Persona_SIN_RESOLVER {

	protected final ClaseDNI_SIN_RESOLVER dniObjeto;
	protected final String nombre;
	protected final String apellido;
	protected final LocalDate fechaNacimiento;

	protected Persona_SIN_RESOLVER(String dni, String nombre, String apellido, LocalDate fechaNacimiento)
			throws GestionEmpresarialException {
		// TODO: validar nombre, apellido, fecha de nacimiento y DNI (usar ClaseDNI_SIN_RESOLVER)
		this.dniObjeto = new ClaseDNI_SIN_RESOLVER(0);
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public abstract String getIdentificador();

	public abstract String getDescripcionCorta();

	public int calcularEdad() {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getDNI() {
		return dniObjeto.getNumeroNIF();
	}

	public boolean cumpleAniosEsteMes() {
		return fechaNacimiento.getMonth() == LocalDate.now().getMonth();
	}

	@Override
	public boolean equals(Object estancia) {
		if (this == estancia) {
			return true;
		}
		if (estancia == null || getClass() != estancia.getClass()) {
			return false;
		}
		Persona_SIN_RESOLVER persona = (Persona_SIN_RESOLVER) estancia;
		return Objects.equals(getIdentificador(), persona.getIdentificador());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdentificador());
	}
}
