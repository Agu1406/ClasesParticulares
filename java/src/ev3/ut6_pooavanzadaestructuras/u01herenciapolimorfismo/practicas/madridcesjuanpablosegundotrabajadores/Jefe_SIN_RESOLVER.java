package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

public class Jefe_SIN_RESOLVER extends Trabajador_SIN_RESOLVER {
    private int acciones;
    private double beneficio;

    public Jefe_SIN_RESOLVER(String nombre, String apellido, String dni, double sueldo,
                             int acciones, double beneficio) {
        super(nombre, apellido, dni, sueldo);
        this.acciones = acciones;
        this.beneficio = beneficio;
    }

    @Override
    public double calcularSalarioMensual() {
        // TODO: sueldo / 12
        return 0;
    }
}
