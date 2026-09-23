package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

public class Jefe_RESUELTO extends Trabajador_RESUELTO {
    private int acciones;
    private double beneficio;

    public Jefe_RESUELTO(String nombre, String apellido, String dni, double sueldo,
                         int acciones, double beneficio) {
        super(nombre, apellido, dni, sueldo);
        this.acciones = acciones;
        this.beneficio = beneficio;
    }

    @Override
    public double calcularSalarioMensual() {
        return sueldo / 12;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Tipo = Jefe");
        super.mostrarDatos();
        System.out.println("acciones = " + acciones);
        System.out.println("beneficio = " + beneficio);
    }
}
