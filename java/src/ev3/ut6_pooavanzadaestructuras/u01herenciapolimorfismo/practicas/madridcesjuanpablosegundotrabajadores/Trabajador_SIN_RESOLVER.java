package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

public abstract class Trabajador_SIN_RESOLVER {
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected double sueldo;

    public Trabajador_SIN_RESOLVER(String nombre, String apellido, String dni, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sueldo = sueldo;
    }

    public abstract double calcularSalarioMensual();

    public void mostrarDatos() { /* TODO */ }
    public String getDni() { return dni; }
}
