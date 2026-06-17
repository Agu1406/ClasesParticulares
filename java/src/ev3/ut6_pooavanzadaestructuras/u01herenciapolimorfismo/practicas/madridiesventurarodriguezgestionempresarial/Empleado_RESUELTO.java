package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Empleado de UMBRELLA CORP: hereda de {@link Persona_RESUELTO} e implementa {@link Contratable}.
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.</p>
 *
 * @author Paula Diaz (codigo original)
 * @author Agustin. A. Marquez. Pina (adaptacion al repo)
 * @since 03/06/2026
 */
public class Empleado_RESUELTO extends Persona_RESUELTO implements Contratable {

	public static final String NOMBRE_EMPRESA = "UMBRELLA CORP";
	public static final LocalDate CREACION_EMPRESA = LocalDate.of(2016, 5, 2);
	private static final float PORCENTAJE_MAXIMO_SUBIDA = 50f;

	private static int numEmpleados = 0;
	private static float ayudaComida = 110;
	private static float compromiso = 200;

	private final String departamento;
	private float sueldo;
	private final LocalDate fechaContrato;
	private String codigoEmpleado;

	public Empleado_RESUELTO(String dni, String nombre, String apellido, String departamento, float sueldo,
			LocalDate fechaContrato, LocalDate fechaNacimiento) throws GestionEmpresarialException {
		super(dni, nombre, apellido, fechaNacimiento);

		if (departamento == null || departamento.trim().isEmpty()) {
			throw new GestionEmpresarialException("El departamento no puede estar vacio.");
		}
		if (sueldo < 0) {
			throw new GestionEmpresarialException("El sueldo no puede ser negativo.");
		}
		if (fechaContrato == null) {
			throw new GestionEmpresarialException("La fecha de contrato es obligatoria.");
		}
		if (fechaNacimiento.isAfter(fechaContrato)) {
			throw new GestionEmpresarialException(
					"La fecha de nacimiento no puede ser posterior a la fecha de contrato.");
		}

		this.departamento = departamento;
		this.sueldo = sueldo;
		this.fechaContrato = fechaContrato;
		generarCodigoEmpleado();
		numEmpleados++;
	}

	@Override
	public String getIdentificador() {
		return getDNI();
	}

	@Override
	public String getDescripcionCorta() {
		return "DNI: " + getDNI() + ", Nombre: " + nombre + ", Edad: " + calcularEdad()
				+ ", Sueldo: " + sueldo;
	}

	@Override
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	@Override
	public String getDepartamento() {
		return departamento;
	}

	@Override
	public float getSueldoAnual() {
		return sueldo;
	}

	public Float getSueldo() {
		return sueldo;
	}

	@Override
	public String toString() {
		return "Informacion del empleado: \n"
				+ "DNI: " + getDNI() + "\n"
				+ "Nombre: " + nombre + "\n"
				+ "Apellido: " + apellido + "\n"
				+ "Departamento: " + departamento + "\n"
				+ "Sueldo Actual: " + sueldo + "\n"
				+ "Fecha de Alta: " + fechaContrato + "\n"
				+ "Fecha de nacimiento: " + fechaNacimiento + "\n";
	}

	@Override
	public void subirSalario(float porcentajeDeseado) throws GestionEmpresarialException {
		if (porcentajeDeseado < 0 || porcentajeDeseado > PORCENTAJE_MAXIMO_SUBIDA) {
			throw new GestionEmpresarialException(
					"El porcentaje debe estar entre 0 y " + PORCENTAJE_MAXIMO_SUBIDA + ".");
		}
		float factorDeIncremento = (porcentajeDeseado / 100f) + 1f;
		this.sueldo = this.sueldo * factorDeIncremento;
	}

	public String toStringReducido() {
		return getDescripcionCorta() + ", Codigo: " + codigoEmpleado;
	}

	public void setSueldo(float nuevoSueldo) throws GestionEmpresarialException {
		if (nuevoSueldo < 0) {
			throw new GestionEmpresarialException("El sueldo no puede ser negativo.");
		}
		this.sueldo = nuevoSueldo;
	}

	private void generarCodigoEmpleado() {
		this.codigoEmpleado = "UMBRE" + String.format("%04d", numEmpleados + 1);
	}

	public static void incrementarAyudaComida(float incremento) {
		ayudaComida += incremento;
	}

	public static void incrementarCompromiso(float incremento) {
		compromiso += incremento;
	}

	public LocalDate getFechaContrato() {
		return fechaContrato;
	}

	public int calcularAntiguedad() {
		return Period.between(fechaContrato, LocalDate.now()).getYears();
	}

	public String mostrarTodosLosDatos() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy",
				new Locale("es", "ES"));
		return "Codigo Empleado: " + codigoEmpleado + "\n"
				+ "DNI: " + getDNI() + "\n"
				+ "Nombre: " + nombre + "\n"
				+ "Apellido: " + apellido + "\n"
				+ "Departamento: " + departamento + "\n"
				+ "Antiguedad: " + calcularAntiguedad() + "\n"
				+ "Edad: " + calcularEdad() + "\n"
				+ "Fecha Contrato: " + fechaContrato.format(formatter);
	}

	public String mostrarReducido() {
		return "Codigo Empleado: " + codigoEmpleado + "\n"
				+ "Nombre: " + nombre + "\n"
				+ "Departamento: " + departamento;
	}

	@Override
	public float calcularSueldoMensual() {
		float sueldoBase = sueldo / 12f;
		float bonoAntiguedad = calcularAntiguedad() * compromiso;
		float bonoAyudaComida = ayudaComida;
		float bonoCumpleanos = cumpleAniosEsteMes() ? 50f : 0f;
		float sueldoMensual = sueldoBase + bonoAntiguedad + bonoAyudaComida + bonoCumpleanos;

		System.out.println("Detalles del sueldo mensual:");
		System.out.println("Sueldo Base: " + sueldoBase);
		System.out.println("Bono por Antiguedad: " + bonoAntiguedad);
		System.out.println("Ayuda para comida: " + bonoAyudaComida);
		System.out.println("Bono de Cumpleanos: " + bonoCumpleanos);

		return sueldoMensual;
	}
}
