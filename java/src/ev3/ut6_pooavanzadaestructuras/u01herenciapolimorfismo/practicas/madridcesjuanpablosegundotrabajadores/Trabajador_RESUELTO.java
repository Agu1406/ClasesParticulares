package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

public abstract class Trabajador_RESUELTO {
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected double sueldo;

    public Trabajador_RESUELTO(String nombre, String apellido, String dni, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sueldo = sueldo;
    }

    public abstract double calcularSalarioMensual();

    public void mostrarDatos() {
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("dni = " + dni);
        System.out.println("sueldo = " + sueldo);
        System.out.println("salario mensual = " + calcularSalarioMensual());
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
}
