package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

import java.time.LocalDate;
import java.time.Period;

/**
 * Empleado de UMBRELLA CORP: hereda de {@link Persona_SIN_RESOLVER} e implementa {@link Contratable}.
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.
 * Solucion de referencia en {@code Empleado_RESUELTO.java}.</p>
 *
 * @author Paula Diaz (codigo original)
 * @author Agustin. A. Marquez. Pina (adaptacion al repo)
 * @since 03/06/2026
 */
public class Empleado_SIN_RESOLVER extends Persona_SIN_RESOLVER implements Contratable {

	public static final String NOMBRE_EMPRESA = "UMBRELLA CORP";
	public static final LocalDate CREACION_EMPRESA = LocalDate.of(2016, 5, 2);

	private static int numEmpleados = 0;

	private final String departamento;
	private float sueldo;
	private final LocalDate fechaContrato;
	private String codigoEmpleado;

	public Empleado_SIN_RESOLVER(String dni, String nombre, String apellido, String departamento, float sueldo,
			LocalDate fechaContrato, LocalDate fechaNacimiento) throws GestionEmpresarialException {
		super(dni, nombre, apellido, fechaNacimiento);
		// TODO: validar departamento, sueldo y fechas; generar codigo UMBRE0001, UMBRE0002...
		this.departamento = departamento;
		this.sueldo = sueldo;
		this.fechaContrato = fechaContrato;
		this.codigoEmpleado = "UMBRE0000";
		numEmpleados++;
	}

	@Override
	public String getIdentificador() {
		// TODO
		return getDNI();
	}

	@Override
	public String getDescripcionCorta() {
		// TODO: DNI, nombre, edad y sueldo en una linea
		return "";
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

	@Override
	public String toString() {
		// TODO: informacion completa del empleado
		return "";
	}

	@Override
	public void subirSalario(float porcentajeDeseado) throws GestionEmpresarialException {
		// TODO: validar porcentaje (0-50) y aplicar incremento
	}

	@Override
	public float calcularSueldoMensual() {
		// TODO: sueldo base mensual + bonos (antiguedad, comida, cumpleanos)
		return 0f;
	}

	public int calcularAntiguedad() {
		return Period.between(fechaContrato, LocalDate.now()).getYears();
	}
}
