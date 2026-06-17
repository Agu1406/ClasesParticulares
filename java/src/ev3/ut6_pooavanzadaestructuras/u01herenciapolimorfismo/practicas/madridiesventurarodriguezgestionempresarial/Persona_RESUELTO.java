package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Clase abstracta padre: datos comunes de cualquier persona en el sistema.
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public abstract class Persona_RESUELTO {

	protected final ClaseDNI_RESUELTO dniObjeto;
	protected final String nombre;
	protected final String apellido;
	protected final LocalDate fechaNacimiento;

	protected Persona_RESUELTO(String dni, String nombre, String apellido, LocalDate fechaNacimiento)
			throws GestionEmpresarialException {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new GestionEmpresarialException("El nombre no puede estar vacio.");
		}
		if (apellido == null || apellido.trim().isEmpty()) {
			throw new GestionEmpresarialException("El apellido no puede estar vacio.");
		}
		if (fechaNacimiento == null) {
			throw new GestionEmpresarialException("La fecha de nacimiento es obligatoria.");
		}
		if (fechaNacimiento.isAfter(LocalDate.now())) {
			throw new GestionEmpresarialException("La fecha de nacimiento no puede ser futura.");
		}

		String dniNormalizado = ClaseDNI_RESUELTO.aniadirCerosHasta9CharsDNI(dni.toUpperCase());
		if (!ClaseDNI_RESUELTO.validarNIF(dniNormalizado)) {
			throw new GestionEmpresarialException("DNI no valido: " + dni);
		}

		this.dniObjeto = new ClaseDNI_RESUELTO(Integer.parseInt(dniNormalizado.substring(0, 8)));
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
		Persona_RESUELTO persona = (Persona_RESUELTO) estancia;
		return Objects.equals(getIdentificador(), persona.getIdentificador());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdentificador());
	}
}
