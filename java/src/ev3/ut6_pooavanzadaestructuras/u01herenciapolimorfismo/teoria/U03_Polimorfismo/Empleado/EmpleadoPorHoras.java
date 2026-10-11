package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Empleado;

/**
 * Empleado pagado por horas (horas * precioHora).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Empleado
 * @see Main
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EmpleadoPorHoras extends Empleado {

    private int horasTrabajadas;
    private double precioHora;

    public EmpleadoPorHoras(String nombre, String dni, int edad,
            int horasTrabajadas, double precioHora) {
        super(nombre, dni, edad);
        this.horasTrabajadas = horasTrabajadas;
        this.precioHora = precioHora;
    }

    public EmpleadoPorHoras(String nombre, String dni, int horasTrabajadas, double precioHora) {
        super(nombre, dni);
        this.horasTrabajadas = horasTrabajadas;
        this.precioHora = precioHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    @Override
    public double calcularNomina() {
        return horasTrabajadas * precioHora;
    }
}
