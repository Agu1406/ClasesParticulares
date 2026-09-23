package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

public class Asalariado_SIN_RESOLVER extends Trabajador_SIN_RESOLVER {
    private int numeroPagas;
    private boolean contratado;
    private double cuotaSS;

    public Asalariado_SIN_RESOLVER(String nombre, String apellido, String dni, double sueldo,
                                   int numeroPagas, boolean contratado, double cuotaSS) {
        super(nombre, apellido, dni, sueldo);
        this.numeroPagas = numeroPagas;
        this.contratado = contratado;
        this.cuotaSS = cuotaSS;
    }

    @Override
    public double calcularSalarioMensual() {
        // TODO: (sueldo * 0.79) / numeroPagas
        return 0;
    }
}
