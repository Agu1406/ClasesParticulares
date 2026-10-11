package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Empleado;

/**
 * Superclase abstracta de empleados.
 *
 * <p>Constructores AllArgs / AnyArgs (edad desconocida) / NoArgs.
 * Contrato polimorfico: {@link #calcularNomina()}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see EmpleadoAsalariado
 * @see EmpleadoPorHoras
 * @see Main
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public abstract class Empleado {

    private String nombre;
    private String dni;
    private Integer edad;

    /**
     * AllArgsConstructor: nombre, DNI y edad.
     */
    public Empleado(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    /**
     * AnyArgsConstructor: nombre y DNI.
     * La edad queda {@code null} (dato desconocido en el alta).
     */
    public Empleado(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = null;
    }

    /**
     * NoArgsConstructor.
     */
    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    /** Puede ser {@code null} si la edad no se indico al crear el empleado. */
    public Integer getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        String mensajeEdad = "desconocido";
        if (this.edad != null) {
            mensajeEdad = this.edad.toString();
        }

        return "\n¡Datos del empleado!\n"
                + "- DNI: " + this.dni + ".\n"
                + "- Nombre: " + this.nombre + ".\n"
                + "- Edad: " + mensajeEdad + ".\n"
                + "- Nomina: " + calcularNomina() + " €.\n";
    }

    public abstract double calcularNomina();
}
