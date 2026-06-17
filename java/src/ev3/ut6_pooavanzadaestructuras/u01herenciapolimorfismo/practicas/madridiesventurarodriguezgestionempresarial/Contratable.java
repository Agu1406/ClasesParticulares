package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

/**
 * Contrato laboral: metodos que todo empleado contratado debe implementar.
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.</p>
 *
 * <p>La interfaz obliga a calcular nomina y gestionar el sueldo sin importar
 * la clase concreta, lo que permite polimorfismo sobre {@code Contratable}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public interface Contratable {

	String getCodigoEmpleado();

	String getDepartamento();

	float getSueldoAnual();

	float calcularSueldoMensual();

	void subirSalario(float porcentaje) throws GestionEmpresarialException;
}
