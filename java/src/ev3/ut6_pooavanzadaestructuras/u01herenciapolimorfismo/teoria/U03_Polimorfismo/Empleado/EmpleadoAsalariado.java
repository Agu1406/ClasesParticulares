package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Empleado;

/**
 * Empleado con sueldo fijo mensual.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Empleado
 * @see Main
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EmpleadoAsalariado extends Empleado {

    private double sueldoMensual;

    public EmpleadoAsalariado(String nombre, String dni, int edad, double sueldoMensual) {
        super(nombre, dni, edad);
        this.sueldoMensual = sueldoMensual;
    }

    public EmpleadoAsalariado(String nombre, String dni, double sueldoMensual) {
        super(nombre, dni);
        this.sueldoMensual = sueldoMensual;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    @Override
    public double calcularNomina() {
        return sueldoMensual;
    }
}
