package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

public class Autonomo_SIN_RESOLVER extends Trabajador_SIN_RESOLVER {
    private boolean contratado;
    private double cuotaSS;

    public Autonomo_SIN_RESOLVER(String nombre, String apellido, String dni, double sueldo,
                                 boolean contratado, double cuotaSS) {
        super(nombre, apellido, dni, sueldo);
        this.contratado = contratado;
        this.cuotaSS = cuotaSS;
    }

    @Override
    public double calcularSalarioMensual() {
        // TODO: (sueldo - 12 * cuotaSS) / 12
        return 0;
    }
}
